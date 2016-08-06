package com.gameprojekt.gottfried.gamepieces;

public enum EGameState {
	NULL(0, EGameBlackRed.ZERRO, EGameEvenOdd.ZERRO, EHighLow.ZERRO, EDozens.ZERRO, EColumns.ZERRO), ONE(1,
			EGameBlackRed.RED, EGameEvenOdd.ODD, EHighLow.LOW, EDozens.FIRSTDOZEN, EColumns.FIRSTCOLONNE), TWO(2,
					EGameBlackRed.BLACK, EGameEvenOdd.EVEN, EHighLow.LOW, EDozens.FIRSTDOZEN,
					EColumns.SECONDCOLONNE), THREE(3, EGameBlackRed.RED, EGameEvenOdd.ODD, EHighLow.LOW,
							EDozens.FIRSTDOZEN, EColumns.THIRDCOLONNE), FOUR(4, EGameBlackRed.BLACK, EGameEvenOdd.EVEN,
									EHighLow.LOW, EDozens.FIRSTDOZEN, EColumns.FIRSTCOLONNE), FIVE(5, EGameBlackRed.RED,
											EGameEvenOdd.ODD, EHighLow.LOW, EDozens.FIRSTDOZEN,
											EColumns.SECONDCOLONNE), SIX(6, EGameBlackRed.BLACK, EGameEvenOdd.EVEN,
													EHighLow.LOW, EDozens.FIRSTDOZEN, EColumns.THIRDCOLONNE), SEVEN(7,
															EGameBlackRed.RED, EGameEvenOdd.ODD, EHighLow.LOW,
															EDozens.FIRSTDOZEN, EColumns.FIRSTCOLONNE), EIGHT(8,
																	EGameBlackRed.BLACK, EGameEvenOdd.EVEN,
																	EHighLow.LOW, EDozens.FIRSTDOZEN,
																	EColumns.SECONDCOLONNE), NINE(9, EGameBlackRed.RED,
																			EGameEvenOdd.ODD, EHighLow.LOW,
																			EDozens.FIRSTDOZEN,
																			EColumns.THIRDCOLONNE), TEN(10,
																					EGameBlackRed.BLACK,
																					EGameEvenOdd.EVEN, EHighLow.LOW,
																					EDozens.FIRSTDOZEN,
																					EColumns.FIRSTCOLONNE), ELEVEN(11,
																							EGameBlackRed.BLACK,
																							EGameEvenOdd.ODD,
																							EHighLow.LOW,
																							EDozens.FIRSTDOZEN,
																							EColumns.SECONDCOLONNE), TWELVE(
																									12,
																									EGameBlackRed.RED,
																									EGameEvenOdd.EVEN,
																									EHighLow.LOW,
																									EDozens.FIRSTDOZEN,
																									EColumns.THIRDCOLONNE), THIRTEEN(
																											13,
																											EGameBlackRed.BLACK,
																											EGameEvenOdd.ODD,
																											EHighLow.LOW,
																											EDozens.SECONDDOZEN,
																											EColumns.FIRSTCOLONNE), FOURTEEN(
																													14,
																													EGameBlackRed.RED,
																													EGameEvenOdd.EVEN,
																													EHighLow.LOW,
																													EDozens.SECONDDOZEN,
																													EColumns.SECONDCOLONNE), FIFTEEN(
																															15,
																															EGameBlackRed.BLACK,
																															EGameEvenOdd.ODD,
																															EHighLow.LOW,
																															EDozens.SECONDDOZEN,
																															EColumns.THIRDCOLONNE), SIXTEEN(
																																	16,
																																	EGameBlackRed.RED,
																																	EGameEvenOdd.EVEN,
																																	EHighLow.LOW,
																																	EDozens.SECONDDOZEN,
																																	EColumns.FIRSTCOLONNE), SEVENTEEN(
																																			17,
																																			EGameBlackRed.BLACK,
																																			EGameEvenOdd.ODD,
																																			EHighLow.LOW,
																																			EDozens.SECONDDOZEN,
																																			EColumns.SECONDCOLONNE), EIGHTTEEN(
																																					18,
																																					EGameBlackRed.RED,
																																					EGameEvenOdd.EVEN,
																																					EHighLow.LOW,
																																					EDozens.SECONDDOZEN,
																																					EColumns.THIRDCOLONNE), NINETEEN(
																																							19,
																																							EGameBlackRed.RED,
																																							EGameEvenOdd.ODD,
																																							EHighLow.HIGH,
																																							EDozens.SECONDDOZEN,
																																							EColumns.FIRSTCOLONNE), TWENTY(
																																									20,
																																									EGameBlackRed.BLACK,
																																									EGameEvenOdd.EVEN,
																																									EHighLow.HIGH,
																																									EDozens.SECONDDOZEN,
																																									EColumns.SECONDCOLONNE), TWENTYONE(
																																											21,
																																											EGameBlackRed.RED,
																																											EGameEvenOdd.ODD,
																																											EHighLow.HIGH,
																																											EDozens.SECONDDOZEN,
																																											EColumns.THIRDCOLONNE), TWENTYTWO(
																																													22,
																																													EGameBlackRed.BLACK,
																																													EGameEvenOdd.EVEN,
																																													EHighLow.HIGH,
																																													EDozens.SECONDDOZEN,
																																													EColumns.FIRSTCOLONNE), TWENTYTHREE(
																																															23,
																																															EGameBlackRed.RED,
																																															EGameEvenOdd.ODD,
																																															EHighLow.HIGH,
																																															EDozens.SECONDDOZEN,
																																															EColumns.SECONDCOLONNE), TWENTYFOUR(
																																																	24,
																																																	EGameBlackRed.BLACK,
																																																	EGameEvenOdd.EVEN,
																																																	EHighLow.HIGH,
																																																	EDozens.SECONDDOZEN,
																																																	EColumns.THIRDCOLONNE), TWENTYFIVE(
																																																			25,
																																																			EGameBlackRed.RED,
																																																			EGameEvenOdd.ODD,
																																																			EHighLow.HIGH,
																																																			EDozens.THIRDDOZEN,
																																																			EColumns.FIRSTCOLONNE), TWENTYSIX(
																																																					26,
																																																					EGameBlackRed.BLACK,
																																																					EGameEvenOdd.EVEN,
																																																					EHighLow.HIGH,
																																																					EDozens.THIRDDOZEN,
																																																					EColumns.SECONDCOLONNE), TWENTYSEVEN(
																																																							27,
																																																							EGameBlackRed.RED,
																																																							EGameEvenOdd.ODD,
																																																							EHighLow.HIGH,
																																																							EDozens.THIRDDOZEN,
																																																							EColumns.THIRDCOLONNE), TWENTYEIGTH(
																																																									28,
																																																									EGameBlackRed.BLACK,
																																																									EGameEvenOdd.EVEN,
																																																									EHighLow.HIGH,
																																																									EDozens.THIRDDOZEN,
																																																									EColumns.FIRSTCOLONNE), TWENTYNINE(
																																																											29,
																																																											EGameBlackRed.BLACK,
																																																											EGameEvenOdd.ODD,
																																																											EHighLow.HIGH,
																																																											EDozens.THIRDDOZEN,
																																																											EColumns.SECONDCOLONNE), THIRTY(
																																																													30,
																																																													EGameBlackRed.RED,
																																																													EGameEvenOdd.EVEN,
																																																													EHighLow.HIGH,
																																																													EDozens.THIRDDOZEN,
																																																													EColumns.THIRDCOLONNE), THIRTYONE(
																																																															31,
																																																															EGameBlackRed.BLACK,
																																																															EGameEvenOdd.ODD,
																																																															EHighLow.HIGH,
																																																															EDozens.THIRDDOZEN,
																																																															EColumns.FIRSTCOLONNE), THIRTYTWO(
																																																																	32,
																																																																	EGameBlackRed.RED,
																																																																	EGameEvenOdd.EVEN,
																																																																	EHighLow.HIGH,
																																																																	EDozens.THIRDDOZEN,
																																																																	EColumns.SECONDCOLONNE), THIRTYTHREE(
																																																																			33,
																																																																			EGameBlackRed.BLACK,
																																																																			EGameEvenOdd.ODD,
																																																																			EHighLow.HIGH,
																																																																			EDozens.THIRDDOZEN,
																																																																			EColumns.THIRDCOLONNE), THIRTYFOUR(
																																																																					34,
																																																																					EGameBlackRed.RED,
																																																																					EGameEvenOdd.EVEN,
																																																																					EHighLow.HIGH,
																																																																					EDozens.THIRDDOZEN,
																																																																					EColumns.FIRSTCOLONNE), THIRTYFIVE(
																																																																							35,
																																																																							EGameBlackRed.BLACK,
																																																																							EGameEvenOdd.ODD,
																																																																							EHighLow.HIGH,
																																																																							EDozens.THIRDDOZEN,
																																																																							EColumns.SECONDCOLONNE), THIRTYSIX(
																																																																									36,
																																																																									EGameBlackRed.RED,
																																																																									EGameEvenOdd.EVEN,
																																																																									EHighLow.HIGH,
																																																																									EDozens.THIRDDOZEN,
																																																																									EColumns.THIRDCOLONNE);

	private int value;
	private EGameBlackRed color;
	private EGameEvenOdd evenOdd;
	private EHighLow highLow;
	private EDozens dozen;
	private EColumns columns;

	private EGameState(int value, EGameBlackRed color, EGameEvenOdd evenodd, EHighLow hightlow, EDozens dozen,
			EColumns columns) {
		this.value = value;
		this.color = color;
		this.evenOdd = evenodd;
		this.highLow = hightlow;
		this.dozen = dozen;
		this.columns = columns;
	}

	@Override
	public String toString() {

		String output = ";" + value + ";"+color.toString()+";"+evenOdd.toString()+";"+highLow.toString()+";"+dozen.toString()+";"+columns.toString();
		return output;
	}
}
