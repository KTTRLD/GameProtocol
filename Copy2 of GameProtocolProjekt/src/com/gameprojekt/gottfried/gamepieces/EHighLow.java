package com.gameprojekt.gottfried.gamepieces;

public enum EHighLow {
	
	HIGH, LOW, ZERRO;
	
    @Override
    public String toString() {
        switch (this) {
        case HIGH:
            return "Hoch";
        case LOW:
            return "Niedrig";
        case ZERRO:
            return "Null";
        default:
            return "_";
        }
    }

}
