package com.gameprojekt.gottfried.gamepieces;

public enum EColumns {
	
	FIRSTCOLONNE, SECONDCOLONNE, THIRDCOLONNE, ZERRO;
	
    @Override
    public String toString() {
        switch (this) {
        case FIRSTCOLONNE:
            return "Erstes Kolonne";
        case SECONDCOLONNE:
            return "Mittleres Kolonne";
        case THIRDCOLONNE:
        	return "Letztes Kolonne";
        case ZERRO:
            return "null";
        default:
            return "_";
        }
    }

}
