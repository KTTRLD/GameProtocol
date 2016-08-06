package com.gameprojekt.gottfried.gamepieces;

public enum EDozens {
	
	FIRSTDOZEN, SECONDDOZEN, THIRDDOZEN, ZERRO;
	
    @Override
    public String toString() {
        switch (this) {
        case FIRSTDOZEN:
            return "Erstes Dutzend";
        case SECONDDOZEN:
            return "Mittleres Dutzend";
        case THIRDDOZEN:
        	return "Letztes Dutzend";
        case ZERRO:
            return "Null";
        default:
            return "_";
        }
    }

}
