package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {
	private static final int TIMEOUT = 1000;

	@Test(timeout = TIMEOUT)
	private void testRollAndGetDice1() {
		Dice dices = new Dice();
		dices.rollDice();
		assertNotNull("Lan�amento Inv�lido", dices.getDice1());
	}

	@Test(timeout = TIMEOUT)
	private void testRollAndGetDice2() {
		Dice dices = new Dice();
		dices.rollDice();
		assertNotNull("Lan�amento Inv�lido", dices.getDice2());
	}

}
