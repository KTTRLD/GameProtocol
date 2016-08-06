package com.gameprojekt.gottfried.gamepieces;

public enum EGameEvenOdd {
	EVEN, ODD, ZERRO;
	
    @Override
    public String toString() {
        switch (this) {
        case EVEN:
            return "Gerade";
        case ODD:
            return "Ungerade";
        case ZERRO:
        	return "Null";
        default:
            return "_";
        }
    }

}
