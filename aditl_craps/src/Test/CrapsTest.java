/*
 * Adit Limbasia
 * CrapsTest
 * Autumn 2023
 */
package Test;

import Model.Craps;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
/**
 * This where I test my Model class for edge cases like positvie numbers, negative, and 0
 *
 * @author Adit Limbasia
 * @version Autumn 2023
 */
public class CrapsTest {
    /** The Craps instance used for testing. */
    private Craps craps;
    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    void setUp() {
        craps = Craps.getCrapsInstance();
    }
    /**
     * Tests the reset method with positive values.
     */
    @org.junit.jupiter.api.Test
    void resetPostive() {
        // Test with a positive number
        craps.setDie1(4);
        craps.setDie2(3);
        craps.setPoint(6);
        craps.setGameActive(true);

        craps.reset();

        assertEquals(0, craps.getDie1());
        assertEquals(0, craps.getDie2());
        assertEquals(0, craps.getPoint());
        assertFalse(craps.getGameActice());
    }
    /**
     * Tests the reset method with zero values.
     */
    @org.junit.jupiter.api.Test
    void resetZero() {
        // Test with a zero number
        craps.setDie1(0);
        craps.setDie2(0);
        craps.setPoint(0);
        craps.setGameActive(false);

        craps.reset();

        assertEquals(0, craps.getDie1());
        assertEquals(0, craps.getDie2());
        assertEquals(0, craps.getPoint());
        assertFalse(craps.getGameActice());
    }
    /**
     * Tests the reset method with negative values.
     */
    @org.junit.jupiter.api.Test
    void resetNegative() {
        // Test with a negative number
        craps.setDie1(-1);
        craps.setDie2(-3);
        craps.setPoint(-2);
        craps.setGameActive(true);

        craps.reset();

        assertEquals(0, craps.getDie1());
        assertEquals(0, craps.getDie2());
        assertEquals(0, craps.getPoint());
        assertFalse(craps.getGameActice());
    }
    /**
     * Tests the getTotal method with positive values.
     */
    @org.junit.jupiter.api.Test
    void getTotalPositive() {
        craps.setTotal(15);
        assertEquals(15, craps.getTotal());
    }
    /**
     * Tests the getTotal method with negative values.
     */
    @org.junit.jupiter.api.Test
    void getTotalNegative() {
        craps.setTotal(-15);
        assertEquals(-15, craps.getTotal());
    }
    /**
     * Tests the getTotal method with zero values.
     */
    @org.junit.jupiter.api.Test
    void getTotalZero() {
        craps.setTotal(0);
        assertEquals(0, craps.getTotal());
    }
    /**
     * Tests the getPoint method with positive values.
     */
    @org.junit.jupiter.api.Test
    void getPointPositive() {
        craps.setPoint(8);
        assertEquals(8, craps.getPoint());
    }
    /**
     * Tests the getPoint method with negative values.
     */
    @org.junit.jupiter.api.Test
    void getPointNegative() {
        craps.setPoint(-8);
        assertEquals(-8, craps.getPoint());
    }
    /**
     * Tests the getPoint method with zero values.
     */
    @org.junit.jupiter.api.Test
    void getPointZero() {
        craps.setPoint(0);
        assertEquals(0, craps.getPoint());
    }
    /**
     * Tests the getDie1 method with positive values.
     */
    @org.junit.jupiter.api.Test
    void getDie1Positive() {
        craps.setDie1(4);
        assertEquals(4, craps.getDie1());
    }
    /**
     * Tests the getDie1 method with negative values.
     */
    @org.junit.jupiter.api.Test
    void getDie1Negative() {
        craps.setDie1(-4);
        assertEquals(-4, craps.getDie1());
    }
    /**
     * Tests the getDie1 method with zero values.
     */
    @org.junit.jupiter.api.Test
    void getDie1Zero() {
        craps.setDie1(0);
        assertEquals(0, craps.getDie1());
    }
    /**
     * Tests the getDie2 method with positive values.
     */
    @org.junit.jupiter.api.Test
    void getDie2Positive() {
        craps.setDie2(3);
        assertEquals(3, craps.getDie2());
    }
    /**
     * Tests the getDie2 method with negative values.
     */
    @org.junit.jupiter.api.Test
    void getDie2Negative() {
        craps.setDie2(-3);
        assertEquals(-3, craps.getDie2());
    }
    /**
     * Tests the getDie2 method with zero values.
     */
    @org.junit.jupiter.api.Test
    void getDie2Zero() {
        craps.setDie2(0);
        assertEquals(0, craps.getDie2());
    }
    /**
     * Tests the getBet method with positive values.
     */
    @org.junit.jupiter.api.Test
    void getBetPositive() {
        craps.setCurrentBet(25);
        assertEquals(25, craps.getBet());
    }
    /**
     * Tests the getBet method with negative values.
     */
    @org.junit.jupiter.api.Test
    void getBetNegative() {
        craps.setCurrentBet(-25);
        assertEquals(-25, craps.getBet());
    }
    /**
     * Tests the getBet method with zero values.
     */
    @org.junit.jupiter.api.Test
    void getBetZero() {
        craps.setCurrentBet(0);
        assertEquals(0, craps.getBet());
    }
    /**
     * Tests the getPlayerWins method with positive values.
     */
    @org.junit.jupiter.api.Test
    void getPlayerWinsPositive() {
        craps.setPlayerWin(3);
        assertEquals(3, craps.getPlayerWins());
    }
    /**
     * Tests the getPlayerWins method with negative values.
     */
    @org.junit.jupiter.api.Test
    void getPlayerWinsNegative() {
        craps.setPlayerWin(-3);
        assertEquals(-3, craps.getPlayerWins());
    }
    /**
     * Tests the getPlayerWins method with zero values.
     */
    @org.junit.jupiter.api.Test
    void getPlayerWinsZero() {
        craps.setPlayerWin(0);
        assertEquals(0, craps.getPlayerWins());
    }
    /**
     * Tests the getMyHouseWins method with positive values.
     */
    @org.junit.jupiter.api.Test
    void getMyHouseWinsPositive() {
        craps.setHouseWin(2);
        assertEquals(2, craps.getMyHouseWins());
    }
    /**
     * Tests the getMyHouseWins method with negative values.
     */
    @org.junit.jupiter.api.Test
    void getMyHouseWinsNegative() {
        craps.setHouseWin(-2);
        assertEquals(-2, craps.getMyHouseWins());
    }
    /**
     * Tests the getMyHouseWins method with zero values.
     */

    @org.junit.jupiter.api.Test
    void getMyHouseWinsZero() {
        craps.setHouseWin(0);
        assertEquals(0, craps.getMyHouseWins());
    }
    /**
     * Tests the getGameActive method with true value.
     */
    @org.junit.jupiter.api.Test
    void getGameActiceTrue() {
        craps.setGameActive(true);
        assertTrue(craps.getGameActice());
    }
    /**
     * Tests the getGameActive method with false value.
     */
    @org.junit.jupiter.api.Test
    void getGameActiceFalse() {
        craps.setGameActive(false);
        assertFalse(craps.getGameActice());
    }
    /**
     * Tests the getMyBankAccount method with positive values.
     */
    @org.junit.jupiter.api.Test
    void getMyBankAccountPositive() {
        // Test with a positive number
        craps.setBankAccount(100);
        assertEquals(100, craps.getMyBankAccount());
    }
    /**
     * Tests the getMyBankAccount method with negative values.
     */
    @org.junit.jupiter.api.Test
    void getMyBankAccountNegative() {
        // Test with a negative number
        craps.setBankAccount(-50);
        assertEquals(-50, craps.getMyBankAccount());
    }
    /**
     * Tests the getMyBankAccount method with zero values.
     */
    @org.junit.jupiter.api.Test
    void getMyBankAccountZero() {
        // Test with 0
        craps.setBankAccount(0);
        assertEquals(0, craps.getMyBankAccount());
    }
    /**
     * Tests the getGameWon method with true value.
     */
    @org.junit.jupiter.api.Test
    void getGameWonTrue() {
        craps.setGameWon(true);
        assertTrue(craps.getGameWon());
    }
    /**
     * Tests the getGameWon method with false value.
     */
    @org.junit.jupiter.api.Test
    void getGameWonFalse() {
        craps.setGameWon(false);
        assertFalse(craps.getGameWon());
    }
    @org.junit.jupiter.api.Test
    void rollGameActive() {
        // Set up the game with active status and initial point
        craps.setGameActive(true);
        craps.setPoint(6);

        // Roll the dice
        craps.roll();

        // Ensure game is still active after rolling
        assertTrue(craps.getGameActice());
    }
    @org.junit.jupiter.api.Test
    void rollGameInactive() {
        // Set up the game with inactive status
        craps.setGameActive(false);

        // Roll the dice
        craps.roll();

        // Ensure game remains inactive after rolling
        assertFalse(craps.getGameActice());
    }
    @org.junit.jupiter.api.Test
    void rollWinningScenario() {
        // Set up the game with active status and initial point
        craps.setGameActive(true);
        craps.setPoint(6);

        // Force a winning scenario (total equals point)
        craps.setDie1(3);
        craps.setDie2(3);

        // Roll the dice
        craps.roll();

        // Ensure player wins and game is inactive after rolling
        assertTrue(craps.getGameWon());
        assertFalse(craps.getGameActice());
    }
    @org.junit.jupiter.api.Test
    void rollLosingScenario() {
        // Set up the game with active status and initial point
        craps.setGameActive(true);
        craps.setPoint(6);

        // Force a losing scenario (total equals 7)
        craps.setDie1(4);
        craps.setDie2(3);

        // Roll the dice
        craps.roll();

        // Ensure house wins and game is inactive after rolling
        assertFalse(craps.getGameWon());
        assertFalse(craps.getGameActice());
    }

    @org.junit.jupiter.api.Test
    void rollContinueGame() {
        // Set up the game with active status and initial point
        craps.setGameActive(true);
        craps.setPoint(6);

        // Force a scenario where the game should continue
        craps.setDie1(2);
        craps.setDie2(4);

        // Roll the dice
        craps.roll();

        // Ensure point is set, and game is still active after rolling
        assertEquals(6, craps.getPoint());
        assertTrue(craps.getGameActice());
    }
}
