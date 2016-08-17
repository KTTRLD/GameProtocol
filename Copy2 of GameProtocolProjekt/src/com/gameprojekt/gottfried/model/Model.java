package com.gameprojekt.gottfried.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.gameprojekt.gottfried.controler.MainControler;
import com.gameprojekt.gottfried.gamepieces.EGameState2;

public class Model extends Observable {

	private String drehRichtung;
	private EGameState2 ergebnis;

	private static String sCSV = "/Users/user/git/GameProtocol/Copy2 of GameProtocolProjekt/Data/CSV-Projekt4.csv";

	private static LinkedList<Integer> input;
	private TableModel tblModel;
	private CSVClient csvClient;
	private Performance preThrowArray;
	private Performance postThrowArray;
	public Model(MainControler mainapp) {
		tblModel = new GameHistoryTable();
		csvClient = new CSVClient(this, sCSV);

		preThrowArray = new Performance();
		postThrowArray = new Performance();

		if (!csvClient.isCSVFile()) {
			throwSetting(Name.FIRSTSTART);
		}
	}

	// Methode welche nur gebraucht wird, wenn es der allererste Wurf ist
	private void throwSetting(int caseString) {

		if (caseString == Name.FIRSTSTART) {
			LinkedList<Integer> listSet = initStartArray(Name.ANZAHL);
			String[] defaultStrings = { "1", getDate(), getTime(), "0", "0", "leer", "leer", "leer", "leer", "leer",
					"leer", "leer", "leer", "leer", "leer" };
			preThrowArray.setAll(defaultStrings);
			preThrowArray.setArrayString(listSet.toString());
			preThrowArray.setEinsatzString(Integer.toString(listSet.getFirst() + listSet.getLast()));
			setChanged();
			notifyObservers();
		}
		if (caseString == Name.OLDSTART) {

			Performance localThrowArray = new Performance();

			List<String[]> entries = csvClient.getMyEntries();
			for (int i = 1; i < entries.size(); i++) {
				writeToGameTable(entries.get(i));
			}

			String[] lastLine = csvClient.getLastLine();
			localThrowArray.setAll(lastLine);
			localThrowArray.setKontostandString(lastLine[Name.POS_WALLET]);
			localThrowArray.setErgebnisString(lastLine[Name.POS_RESULT]);

			setErgebnis(lastLine[Name.POS_RESULTNUMBER]);
			setDrehrichtung(lastLine[Name.POS_DIRECTION]);
			setNextRound(localThrowArray);

		}
		if (caseString == Name.WINSTART) {
			putInto(Name.WIN);

		}
		if (caseString == Name.LOOSESTART) {
			putInto(Name.LOOSE);

		}

		if (caseString == Name.RESTART) {
			
			int old = Integer.valueOf((preThrowArray.getGameIDString()));
			preThrowArray.setGameIDString(Integer.toString(old));
			LinkedList<Integer> listSet = initStartArray(Name.ANZAHL);
			preThrowArray.setArrayString(listSet.toString());
			preThrowArray.setEinsatzString(Integer.toString(listSet.getFirst() + listSet.getLast()));
			setChanged();
			notifyObservers();
		}

	}

	private void putInto(String win) {
		postThrowArray = preThrowArray;
		postThrowArray.setRichtungString(drehRichtung);
		postThrowArray.setErgebnisString(win);
		postThrowArray.setDateString(getDate());
		postThrowArray.setTimeString(getTime());

		setErgebnisToPerformance();
		writeToCSVAndTable(postThrowArray);
		setNextRound(postThrowArray);
		setChanged();
		notifyObservers();

	}

	// Diese Methode wird ausgelagert aus putInto und wird gebraucht wenn aus
	// bereits vorhanden daten geladen wird
	private void setErgebnisToPerformance() {
		postThrowArray.setErgebnisNummerString(ergebnis.getValue());
		postThrowArray.setFarbeString(ergebnis.getFarbe());
		postThrowArray.setGeradeString(ergebnis.getEvenOddString());
		postThrowArray.setHiLoString(ergebnis.getHighString());
		postThrowArray.setKolonneString(ergebnis.getColumnsString());
		postThrowArray.setDutzenString(ergebnis.getDozenString());
	}

	private void setNextRound(Performance localThrowArray) {
		// preThrowArray = localThrowArray;

		// GameID erhöhen;

		// Kontostand um Einsatz erhöhen erniedrigen
		LinkedList<Integer> array = localThrowArray.getArrayAsList();
		preThrowArray.setGameIDString((String.valueOf(incGameID(localThrowArray))));

		if (localThrowArray.getErgebnisString().equalsIgnoreCase(Name.WIN)) {

			LinkedList<Integer> array2 = calculateArrayAfterWin(array);

			preThrowArray.setKontostandString((String.valueOf(incWallet(localThrowArray))));
			preThrowArray.setArrayString(array2.toString());
			preThrowArray.setEinsatzString(String.valueOf(calculateWager(array2)));

			setChanged();
			notifyObservers();

		}
		if (localThrowArray.getErgebnisString().equalsIgnoreCase(Name.LOOSE)) {

			LinkedList<Integer> array2 = calculateArrayAfterLoose(array);
			preThrowArray.setKontostandString((String.valueOf(decWallet(localThrowArray))));
			preThrowArray.setArrayString(array2.toString());
			preThrowArray.setEinsatzString(String.valueOf(calculateWager(array2)));

			setChanged();
			notifyObservers();
		}

	}

	private LinkedList<Integer> calculateArrayAfterLoose(LinkedList<Integer> array) {

		if (array.size() == 1) {
			array.addLast(array.getFirst());
			return array;
		}

		if (!array.isEmpty()) {
			int verlust = array.getFirst() + array.getLast();
			array.addLast(verlust);

		}
		return array;
	}

	private int calculateWager(LinkedList<Integer> inputArray) {
		switch (inputArray.size()) {
		case 1:
			return inputArray.getLast();
		default:
			return inputArray.getFirst() + inputArray.getLast();
		}

	}

	private int incWallet(Performance localThrowArray) {
		int lastWager = Integer.parseInt(localThrowArray.getEinsatzString());
		int lastWallet = Integer.parseInt(localThrowArray.getKontostandString());
		return lastWager + lastWallet;
	}

	private int decWallet(Performance localThrowArray) {
		int lastWager = Integer.parseInt(localThrowArray.getEinsatzString());
		int lastWallet = Integer.parseInt(localThrowArray.getKontostandString());
		localThrowArray.setKontostandString((String.valueOf(lastWallet - lastWager)));
		return lastWallet - lastWager;
	}

	private int incGameID(Performance localThrowArray) {
		int gameId = Integer.parseInt((localThrowArray.getGameIDString()));
		gameId++;
		return gameId;
	}

	public Performance getPreThrowArray() {
		return preThrowArray;
	}

	public void startNewGameAction() {
		this.throwSetting(Name.RESTART);
	}

	public void startFromOldGameAction() {
		this.throwSetting(Name.OLDSTART);
	}

	public void looseAction() {
		throwSetting(Name.LOOSESTART);
	}

	public void winAction() {
		this.throwSetting(Name.WINSTART);
	}

	private LinkedList<Integer> calculateArrayAfterWin(LinkedList<Integer> input) {

		if (input.size() >= 4) {
			input.removeFirst();
			input.removeLast();
			return input;

		} else {
			switch (input.size()) {
			case 1:
				return initStartArray(Name.ANZAHL);
			case 2:
				return initStartArray(Name.ANZAHL);
			case 3:
				input.removeFirst();
				input.removeLast();
				return input;
			default:
				return input;
			}
		}
	}

	public void setErgebnis(String input) {

		switch (input) {
		case "0":
			this.ergebnis = EGameState2.NULL;
			break;
		case "1":
			this.ergebnis = EGameState2.ONE;
			break;
		case "2":
			this.ergebnis = EGameState2.TWO;
			break;
		case "3":
			this.ergebnis = EGameState2.THREE;
			break;
		case "4":
			this.ergebnis = EGameState2.FOUR;
			break;
		case "5":
			this.ergebnis = EGameState2.FIVE;
			break;
		case "6":
			this.ergebnis = EGameState2.SIX;
			break;
		case "7":
			this.ergebnis = EGameState2.SEVEN;
			break;
		case "8":
			this.ergebnis = EGameState2.EIGHT;
			break;
		case "9":
			this.ergebnis = EGameState2.NINE;
			break;
		case "10":
			this.ergebnis = EGameState2.TEN;
			break;
		case "11":
			this.ergebnis = EGameState2.ELEVEN;
			break;
		case "12":
			this.ergebnis = EGameState2.TWELVE;
			break;
		case "13":
			this.ergebnis = EGameState2.THIRTEEN;
			break;
		case "14":
			this.ergebnis = EGameState2.FOURTEEN;
			break;
		case "15":
			this.ergebnis = EGameState2.FIFTEEN;
			break;
		case "16":
			this.ergebnis = EGameState2.SIXTEEN;
			break;
		case "17":
			this.ergebnis = EGameState2.SEVENTEEN;
			break;
		case "18":
			this.ergebnis = EGameState2.EIGHTTEEN;
			break;
		case "19":
			this.ergebnis = EGameState2.NINETEEN;
			break;
		case "20":
			this.ergebnis = EGameState2.TWENTY;
			break;
		case "21":
			this.ergebnis = EGameState2.TWENTYONE;
			break;
		case "22":
			this.ergebnis = EGameState2.TWENTYTWO;
			break;
		case "23":
			this.ergebnis = EGameState2.TWENTYTHREE;
			break;
		case "24":
			this.ergebnis = EGameState2.TWENTYFOUR;
			break;
		case "25":
			this.ergebnis = EGameState2.TWENTYFIVE;
			break;
		case "26":
			this.ergebnis = EGameState2.TWENTYSIX;
			break;
		case "27":
			this.ergebnis = EGameState2.TWENTYSEVEN;
			break;
		case "28":
			this.ergebnis = EGameState2.TWENTYEIGTH;
			break;
		case "29":
			this.ergebnis = EGameState2.TWENTYNINE;
			break;
		case "30":
			this.ergebnis = EGameState2.THIRTY;
			break;
		case "31":
			this.ergebnis = EGameState2.THIRTYONE;
			break;
		case "32":
			this.ergebnis = EGameState2.THIRTYTWO;
			break;
		case "33":
			this.ergebnis = EGameState2.THIRTYTHREE;
			break;
		case "34":
			this.ergebnis = EGameState2.THIRTYFOUR;
			break;
		case "35":
			this.ergebnis = EGameState2.THIRTYFIVE;
			break;
		case "36":
			this.ergebnis = EGameState2.THIRTYSIX;
			break;
		default:
			break;
		}

		setChanged();
		notifyObservers();
	}

	private LinkedList<Integer> initStartArray(int anzahl) {
		LinkedList<Integer> zwischenList = new LinkedList<Integer>();
		for (int i = 0; i < anzahl; i++) {
			zwischenList.add(Name.EINSATZ);
		}
		return zwischenList;
	}

	public static LinkedList<Integer> getList() {
		return input;
	}

	public String getTime() {
		GregorianCalendar now = new GregorianCalendar();
		DateFormat gdt = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.GERMANY);
		return gdt.format(now.getTime());
	}

	public String getDate() {
		GregorianCalendar now = new GregorianCalendar();
		DateFormat gdf = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMANY);
		return gdf.format(now.getTime());
	}

	// von hier wird in die Tabelle und in die CSV-Datei geschrieben.
	private void writeToCSVAndTable(Performance inputThrowArray) {
		String[] nextLine = inputThrowArray.getAllFieldArray();
		csvClient.writeToCSV(nextLine);
		writeToGameTable(nextLine);
		System.out.println("Line " + nextLine.toString() +" added to CSV: "+ csvClient.getCSV());
		System.out.println("Line "+ nextLine.toString() +" added to Table");
		
	}

	// wird von der Methode writeToCSVAndTable() benutzt
	private void writeToGameTable(String[] nextLine) {
		List<String> row = new ArrayList<String>();
		for (int i = 0; i < nextLine.length; i++) {
			String string = nextLine[i];
			row.add(i, string);
			int newrow = ((GameHistoryTable) tblModel).addData(row);
			((AbstractTableModel) tblModel).fireTableRowsInserted(newrow, newrow);
		}
		setChanged();
		notifyObservers();
	}

	public void setDrehrichtung(String drehRichtungString) {
		this.drehRichtung = drehRichtungString;
	}

	public TableModel getTableModel() {
		return tblModel;
	}

	public void close() {
		csvClient.close();
	}

	public void setTableID(String valueOf) {
		preThrowArray.setTableIDString(valueOf);
	}

	public void setKontostand(String input2) {
		preThrowArray.setKontostandString(input2);
		
	}

}
