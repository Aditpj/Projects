/*
 * Adit Limbasia
 * Craps
 * Autumn 2023
 */
package Model;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.Scanner;
/**
 * This class follows the singleton pattern, ensuring that there is only one instance
 * of the Craps game and is where the main logic is in.
 *
 * @author Adit Limbasia
 * @version Autumn 2023
 */
public class Craps {
    /** Property chang field */
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    /** Random for the roll */
    private static Random roller = new Random();
    /** Die 1 variable  */
    private int myDie1;
    /** Die 2 variable  */
    private int myDie2;
    /** The Total for the Die variable */
    private int myTotal;
    /** The point for the Dies */
    private int myPoint;
    /** See if games is active */
    private boolean myGameActive;
    /** See if game is won */
    private boolean myGameWon;
    /** Keep track of player wins*/
    private int myPlayerWin;
    /** Keep track of house wins*/
    private int myHouseWin;
    /** Hold my Bank Account number */
    private int myBankAccount;
    /** hold the current bet*/
    private int myCurrentBet;
    /** hold the initial bank number*/
    private int myInitialBank;
    /** instance of craps*/
    private static Craps myInstance = new Craps();
    /**
     * Private constructor to enforce the singleton pattern.
     * Initializes the game by calling the startGame() method.
     */
    private Craps() {
        startGame();
    }
    /**
     * Returns the single instance of the Craps game.
     * @return The single instance of the Craps game.
     */
    public static Craps getCrapsInstance(){
        return myInstance;
    }
    /**
     * Starts a new game by initializing game variables and setting the bank account.
     * If the game is already active, this method has no effect.
     */
    public void startGame(){
        if (!myGameActive) {
          myBankAccount = getBankAccountIntro();

        }
        setGameActive(true);
        setGameWon(false);
        setPoint(0);
    }
    /**
     * Resets the game by setting various game variables to their initial values.
     */
    public void reset() {
        myDie1 = 0;
        myDie2 = 0;
        myPlayerWin = 0;
        myHouseWin = 0;
        myPoint = 0;
        myGameActive = false;
    }
    /**
     * Sets the game's active status and notifies registered listeners of the change.
     * @param theGameActive The new active status of the game.
     */
    public void setGameActive(final boolean theGameActive){
        myGameActive = theGameActive;
        if (!myGameActive) {
            changes.firePropertyChange("active", null, false);
        }
    }
    /** Set Die1 to the Die1 */
    public void setDie1 (final int theDie1) {
        myDie1 = theDie1;
    }
    /** Set Die2 to the Die2 */
    public void setDie2 (final int theDie2) {
        myDie2 = theDie2;
    }
    /** Set Player Win to the Player Win */
    public void setPlayerWin (final int thePlayerWin) {
        myPlayerWin = thePlayerWin;
    }
    /** Set House Win to the House Win*/
    public void setHouseWin (final int theHouseWin) {
        myHouseWin = theHouseWin;
    }
    /** Set mybank to the bank and initialbank to the bank */
    public void setBankAccount(final int theBankAccount) {
        myBankAccount = theBankAccount;
        myInitialBank = theBankAccount;
    }
    /** set game won to the game won*/
    public void setGameWon(final boolean theGameWon){
        myGameWon = theGameWon;
    }
    /** set point to the point*/
    public void setPoint(final int thePoint){
        myPoint = thePoint;
    }
    /** set total to the total*/
    public void setTotal(final int theTotal){
        myTotal = theTotal;
    }
    /** Set Current bet to theBet */
    public void setCurrentBet(final int theBet) {
        myCurrentBet = theBet;
    }
    /** return myTotal
     * @return myTotal
     */
    public int getTotal(){ return myTotal; }

    /** return myPoint
     * @return myPoint
     */
    public int getPoint(){
        return myPoint;
    }
    /** return myDie1
     * @return myDie1
     */
    public int getDie1(){
        return myDie1;
    }
    /** return Die2
     * @return Die2
     */
    public int getDie2() {
        return myDie2;
    }
    /** return myCurrentBet
     * @return myCurrentBet
     */
    public int getBet() {
        return myCurrentBet;
    }
    /** return myPlayerWin
     * @return myPlayerWin
     */
    public int getPlayerWins() {
        return myPlayerWin;
    }
    /** return myHouseWin
     * @return myHouseWin
     */
    public int getMyHouseWins() {
        return myHouseWin;
    }

    /** return myGameActive
     * @return myGameActive
     */
    public boolean getGameActice() {
        return myGameActive;
    }
    /** Gets information for the users Bank Account info.
     * Makes sure the number is not less than 0.
     * @return Bank Amount.
     * @return amount to setBankAccount method.
     */
    public int getBankAccountIntro() {
        String input = JOptionPane.showInputDialog("Enter Bank Account amount:");
        try {
            int amount = Integer.parseInt(input);
            if (amount < 0) {
                throw new NumberFormatException();
            }
            setBankAccount(amount);
            return amount;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a non-negative integer", "Error", JOptionPane.ERROR_MESSAGE);
            return getBankAccountIntro();
        }

    }
    /** return myBankAccount
     * @return myBankAccount
     */
    public int getMyBankAccount() {
        return myBankAccount;
    }
    /** return myInitialBankAccount
     * @return myInitialBankAccount
     */
    public int getMyInitialBankAccount() {
        return myInitialBank;
    }
    /** return myGameWon
     * @return myGameWon
     */
    public boolean getGameWon() {
        return myGameWon;
    }
    /**
     * Rolls the dice and determines the outcome of the game based on the total value.
     * Updates game statistics, such as player wins, house wins, and bank account.
     */
    public void roll() {
        if (myGameActive){
            myDie1 = roller.nextInt(6) + 1;
            myDie2 = roller.nextInt(6) + 1;
            setTotal(myDie1 + myDie2);

            if (myPoint == 0){
                if (myTotal == 2 || myTotal == 3 || myTotal == 12) {
                    myHouseWin++;
                    myBankAccount -= myCurrentBet;
                    myPoint = 0;
                    setGameWon(false);

                }
                else if (myTotal == 7 || myTotal == 11) {
                    myPlayerWin++;
                    myBankAccount = (myCurrentBet * 2) + myBankAccount;
                    setGameWon(true);
                    setGameActive(false);
                }
                else {
                    setPoint(myTotal);
                }
            } else {
                if (myTotal == myPoint){
                    myPlayerWin++;
                    myBankAccount = (myCurrentBet * 2) + myBankAccount;
                    setGameWon(true);
                    setGameActive(false);
                }
                else if (myTotal == 7){
                    myHouseWin++;
                    myBankAccount -= myCurrentBet;
                    setGameWon(false);
                    setGameActive(false);
                }
            }
        }
    }
    /**
     * Adds a PropertyChangeListener to the list of listeners.
     * @param theL The listener to be added.
     */
    public void addPropertyChangeListener(final PropertyChangeListener theL){
        changes.addPropertyChangeListener(theL);
    }
    /**
     * Removes a PropertyChangeListener from the list of listeners.
     * @param theL The listener to be removed.
     */
    public void removePropertyChangeListener(final PropertyChangeListener theL){
        changes.removePropertyChangeListener(theL);
    }

}
