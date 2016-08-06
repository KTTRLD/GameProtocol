package com.gameprojekt.gottfried.model;

public final class Name {

	public static final String NEWGAME = "Neues Spiel";
	public static final String WIN = "gewonnen";
	public static final String LOOSE = "verloren";
	public static final String GAMEID = "GameID";
	public static final String DATE = "Datum";
	public static final String TIME = "Zeit";
	public static final String TABLEID = "TableID";
	public static final String WALLET = "Guthaben";
	public static final String WAGER = "Einsatz";
	public static final String ARRAY = "Spielstand";
	
	public static final int RESTART = 0;
	public static final int FIRSTSTART = 1;
	public static final int OLDSTART = 2;
	public static final int WINSTART = 3;
	public static final int LOOSESTART = 4;
	
	public static final String[] ENTRIES = { Name.GAMEID, Name.DATE, Name.TIME, Name.TABLEID, Name.WALLET, Name.ARRAY,
			Name.WAGER, "Drehrichtung", "Ausgang", "Ergebnis", "Farbe", "Gerade", "HiLo", "Dutzend", "Kolonne" };
	// public static final String ARRAY = "GameArray";

	
	// Positionen für die ArrayFelder
	public static final int POS_GAMEID 			= 0;
	public static final int POS_DATE 			= 1;
	public static final int POS_TIME 			= 2;
	public static final int POS_TABLEID 		= 3;
	public static final int POS_WALLET 			= 4;
	public static final int POS_ARRAY 			= 5;
	public static final int POS_WAGER 			= 6;
	public static final int POS_DIRECTION 		= 7;
	public static final int POS_RESULT 			= 8;
	public static final int POS_RESULTNUMBER 	= 9;
	public static final int POS_COLOR 			= 10;
	public static final int POS_EVENODD 		= 11;
	public static final int POS_HILO 			= 12;
	public static final int POS_DUTZEND 		= 13;
	public static final int POS_KOLONNE			= 14;

	

	// possible modes
	public static final int BUTTON_NEWGAME = 0;
	public static final int BUTTON_UNDO = 1;
	public static final int BUTTON_WIN = 2;
	public static final int BUTTON_LOOSE = 3;
	public static final int BUTTON_CHANGETABLE = 4;

	public static final int ANZAHL = 5;
	public static final int EINSATZ = 1;

}
