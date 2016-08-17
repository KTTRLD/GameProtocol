package com.gameprojekt.gottfried.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVClient {

	private static String sCSV = "/Users/user/git/GameProtocol/Copy2 of GameProtocolProjekt/Data/CSV-Projekt4.csv";
	private List<String[]> myEntries;
	private String[] lastLine;
	private boolean isCSVFile;
	private CSVWriter writer;
	private String[] entries = Name.ENTRIES;
	public CSVClient(Model model, String csv) {
		CSVClient.sCSV = csv;
		initCSVReader();
	}

	public CSVClient() {
		initCSVReader();
	}

	public String[] getLastLine() {
		return lastLine;
	}

	public List<String[]> getMyEntries() {
		return myEntries;
	}

	public boolean isCSVFile() {
		return isCSVFile;
	}

	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToCSV(String[] nextLine) {
		writer.writeNext(nextLine);
	}

	private void initCSVReader() {
		CSVReader reader;
		try {
			System.out.println("read File: " + sCSV);
			reader = new CSVReader(new FileReader(sCSV));
			myEntries = reader.readAll();
			if (!myEntries.isEmpty()) {

				// Damit die erste Zeile der lesenden Datei nicht mit
				// aufgenommen wird
				for (int i = 1; i < myEntries.size(); i++) {
					myEntries.get(i);
				}
				setLastLine(myEntries.get(myEntries.size() - 1));
				setIsCSVFile(true);
				initCSVWriter();
			}
		} catch (IOException e) {
			System.out.println("Keine Datei");
			setIsCSVFile(false);
		}
	}

	private void setLastLine(String[] lastLine) {
		this.lastLine = lastLine;
	}

	private void initCSVWriter() {
		writer = null;
		try {
			writer = new CSVWriter(new FileWriter(sCSV));
			if (!myEntries.isEmpty()) {
				String[] ersteZeile = myEntries.get(0);
				// zur Kontrolle der Header-Zeile, falls diese nicht vorhanden,
				// erzeuge neue Zeile
				if (!entries[0].equalsIgnoreCase(ersteZeile[0])) {
					myEntries.remove(0);
					writeToCSV(entries);
				}
				writer.writeAll(myEntries);

				// gameID = Integer.valueOf(getLastDataFromCSV(Name.GAMEID));
				// kontostand =
				// Integer.valueOf(getLastDataFromCSV(Name.WALLET));
				// list = getLastArrayDataFromCSV(Name.ARRAY);
			}
			if (myEntries.isEmpty()) {
				// Headerzeile bei leerer Eingabe
				System.out.println("Datei leer - Erzeuge erste Zeile");
				writeToCSV(entries);
				return;
			}
			System.out.println("writer set File: " + sCSV);

		} catch (IOException e2) {
			System.out.println("not able to write: " + sCSV);

		}
	}

	private void setIsCSVFile(boolean b) {
		this.isCSVFile = b;

	}

	public String getCSV() {
		// TODO Auto-generated method stub
		return CSVClient.sCSV;
	}

}
