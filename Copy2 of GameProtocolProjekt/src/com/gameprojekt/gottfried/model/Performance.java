package com.gameprojekt.gottfried.model;

import java.util.LinkedList;

public class Performance {

	private String[] allFieldArray = new String[Name.POS_KOLONNE + 1];
	private String gameIDString = "";
	private String dateString = "";
	private String timeString = "";
	private String tableIDString = "";
	private String arrayString = "";
	private String kontostandString = "";
	private String einsatzString = "";
	private String richtungString = "";
	private String ergebnisString = "";
	private String ergebnisNummerString = "";
	private String farbeString = "";
	private String geradeString = "";
	private String hiLoString = "";
	private String dutzenString = "";
	private String kolonneString = "";

	public Performance() {

		for (int i = 0; i < allFieldArray.length; i++) {
			allFieldArray[i] = "0";
		}
	}

	public Performance(String[] line) {

		setAll(line);

	}

	public String getGameIDString() {
		return gameIDString;
	}

	public String getDateString() {
		return dateString;
	}

	public String getTimeString() {
		return timeString;
	}

	public String getTableIDString() {
		return tableIDString;
	}

	public String getArrayString() {
		return arrayString;
	}

	public String getKontostandString() {
		return kontostandString;
	}

	public String getEinsatzString() {
		return einsatzString;
	}

	public String getRichtungString() {
		return richtungString;
	}

	public String getErgebnisString() {
		return ergebnisString;
	}

	public String getFarbeString() {
		return farbeString;
	}

	public String getGeradeString() {
		return geradeString;
	}

	public String getHiLoString() {
		return hiLoString;
	}

	public String getDutzenString() {
		return dutzenString;
	}

	public String getKolonneString() {
		return kolonneString;
	}

	public void setGameIDString(String gameIDString) {
		this.gameIDString = gameIDString;
		this.allFieldArray[Name.POS_GAMEID] = gameIDString;

	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
		this.allFieldArray[Name.POS_DATE] = dateString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
		this.allFieldArray[Name.POS_TIME] = timeString;
	}

	public void setTableIDString(String tableIDString) {
		this.tableIDString = tableIDString;
		this.allFieldArray[Name.POS_TABLEID] = tableIDString;
	}

	public void setArrayString(String arrayString) {
		this.arrayString = arrayString;
		this.allFieldArray[Name.POS_ARRAY] = arrayString;
	}

	public void setKontostandString(String kontostandString) {
		this.kontostandString = kontostandString;
		this.allFieldArray[Name.POS_WALLET] = kontostandString;
	}

	public void setEinsatzString(String einsatzString) {
		this.einsatzString = einsatzString;
		this.allFieldArray[Name.POS_WAGER] = einsatzString;
	}

	public void setRichtungString(String richtungString) {
		this.richtungString = richtungString;
		this.allFieldArray[Name.POS_DIRECTION] = richtungString;
	}

	public void setErgebnisString(String ergebnisString) {
		this.ergebnisString = ergebnisString;
		this.allFieldArray[Name.POS_RESULT] = ergebnisString;
	}

	public void setFarbeString(String farbeString) {
		this.farbeString = farbeString;
		this.allFieldArray[Name.POS_COLOR] = farbeString;
	}

	public void setGeradeString(String geradeString) {
		this.geradeString = geradeString;
		this.allFieldArray[Name.POS_EVENODD] = geradeString;
	}

	public void setHiLoString(String hiLoString) {
		this.hiLoString = hiLoString;
		this.allFieldArray[Name.POS_HILO] = hiLoString;
	}

	public void setDutzenString(String dutzenString) {
		this.dutzenString = dutzenString;
		this.allFieldArray[Name.POS_DUTZEND] = dutzenString;
	}

	public void setKolonneString(String kolonneString) {
		this.kolonneString = kolonneString;
		this.allFieldArray[Name.POS_KOLONNE] = kolonneString;
	}

	public void setErgebnisNummerString(String ergebnisNummerString) {
		this.ergebnisNummerString = ergebnisNummerString;
		this.allFieldArray[Name.POS_RESULTNUMBER] = ergebnisNummerString;
	}

	@Override
	public String toString() {

		// String output2 = allFieldArray.toString();
		String output = gameIDString + ";" + dateString + ";" + timeString + ";" + tableIDString + ";" + arrayString
				+ ";" + kontostandString + ";" + einsatzString + ";" + richtungString + ";" + ergebnisString + ";"
				+ ergebnisNummerString + ";" + farbeString + ";" + geradeString + ";" + hiLoString + ";" + dutzenString
				+ ";" + kolonneString;
		return output;
	}

	public String getErgebnisNummerString() {
		return ergebnisNummerString;
	}

	public String[] getAllFieldArray() {
		return allFieldArray;
	}

	public void setAll(String[] lastLine) {

		allFieldArray = lastLine;

		gameIDString = lastLine[Name.POS_GAMEID];
		dateString = lastLine[Name.POS_DATE];
		timeString = lastLine[Name.POS_TIME];
		tableIDString = lastLine[Name.POS_TABLEID];
		arrayString = lastLine[Name.POS_ARRAY];
		kontostandString = lastLine[Name.POS_WALLET];
		einsatzString = lastLine[Name.POS_WAGER];
		richtungString = lastLine[Name.POS_DIRECTION];
		ergebnisString = lastLine[Name.POS_RESULT];
		ergebnisNummerString = lastLine[Name.POS_RESULTNUMBER];
		farbeString = lastLine[Name.POS_COLOR];
		geradeString = lastLine[Name.POS_EVENODD];
		hiLoString = lastLine[Name.POS_HILO];
		dutzenString = lastLine[Name.POS_DUTZEND];
		kolonneString = lastLine[Name.POS_KOLONNE];

	}

	public LinkedList<Integer> getArrayAsList() {

		int initString = -1;
		String[] firstLineString = Name.ENTRIES;
		for (int i = 0; i < firstLineString.length; i++) {
			String string = firstLineString[i];
			if (string.equalsIgnoreCase(Name.ARRAY)) {
				initString = i;
			}
		}
		if (initString == -1) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < Name.ANZAHL; i++) {
				list.add(Name.EINSATZ);
			}
			return list;
		}

		LinkedList<Integer> lastList = new LinkedList<Integer>();

		String arr = getArrayString();

		String[] items = arr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "").split(",");

		for (int i = 0; i < items.length; i++) {
			try {
				lastList.add(Integer.parseInt(items[i]));
			} catch (NumberFormatException nfe) {
				System.out.println("no number");
			}
			;
		}
		return lastList;

	}
}
