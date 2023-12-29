/*
 * Adit Limbasia
 * CrapsView
 * Autumn 2023
 */
package View;
import Model.Craps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/**
 * This class is where all the GUI and action listeners are made like panels, buttons
 * labels,text field and other user interaction features
 *
 * @author Adit Limbasia
 * @version Autumn 2023
 */
public class CrapsView extends JPanel implements PropertyChangeListener {
    /** My one bet button */
    private JButton myOne;
    /** My Five bet button */
    private JButton myFive;
    /** my Ten bet button */
    private JButton myTen;
    /** My Fifthy bet button*/
    private JButton myFifthy;
    /** my Hundred bet button*/
    private JButton myHundred;
    /** my Five Hundred bet button*/
    private JButton myFiveHundred;
    /** my roll button*/
    private JButton myRoll;
    /** my play again button*/
    private JButton myPlayAgain;
    /** my set bank button */
    private JButton mySetBank;
    /** my set bet button*/
    private JButton mySetBet;
    /** my roll panel*/
    private JPanel myRollPanel;
    /**  my win panel*/
    private JPanel myWinPanel;
    /** my bank panel*/
    private JPanel myBankPanel;
    /** my bet panel*/
    private JPanel myBetPanel;
    /** my Die1 label*/
    private JLabel myDie1;
    /** my Die2 label*/
    private JLabel myDie2;
    /** my Total label*/
    private JLabel myTotal;
    /** my Point label*/
    private JLabel myPoint;
    /** my Dollar sign label*/
    private JLabel myDollarSign;
    /** my PlayerTotal label*/
    private JLabel myPlayerTotal;
    /** my HouseTotal label*/
    private JLabel myHouseTotal;
    /** my Start menu item*/
    private static JMenuItem myStartMenu;
    /** my Reset menu item*/
    private static JMenuItem myReset;
    /** my Exit menu item*/
    private static JMenuItem myExit;
    /** my About menu item*/
    private static JMenuItem myAbout;
    /** my Rules menu item*/
    private static JMenuItem myRules;
    /** my Shortcuts menu item*/
    private static JMenuItem myShortcuts;
    /** my Die1 text field*/
    private JTextField myDie1Text;
    /** my Die2 text field*/
    private JTextField myDie2Text;
    /** my Total text field*/
    private JTextField myTotalText;
    /** my Bet text field*/
    private JTextField myBet;

    /** my Bank text field*/
    private JTextField myBank;
    /** my Point text field*/
    private JTextField myPointText;
    /**
    * Creates a new instance of CrapsView.
    * Initializes the graphical components, layout, and adds event listeners.
    */
    public CrapsView() {
        Craps craps = Model.Craps.getCrapsInstance();
        setLayout(new GridLayout(2, 2, 6, 6));
        // Initialize buttons, labels, and text fields
        myRoll = new JButton("Roll Dice");
        myRoll.setEnabled(false);
        myPlayAgain = new JButton("Play Again");
        myPlayAgain.setEnabled(false);
        myRoll.setMnemonic('n');
        myDie1 = new JLabel("Die1 value:");
        myDie2 = new JLabel("Die2 value:");
        myTotal = new JLabel("Die Total:");
        myPoint = new JLabel("The Point:");
        myPointText = new JTextField(20);

        // Initialize buttons and text fields for roll panel
        myRollPanel = new JPanel(new GridBagLayout());
        GridBagConstraints roll = new GridBagConstraints();
        myDie1Text = new JTextField(20);
        myDie1Text.setText("");
        myDie2Text = new JTextField(20);
        myDie2Text.setText("");
        myTotalText = new JTextField(20);
        myTotalText.setText("");
        // Add buttons and text fields to panel
        myRollPanel.add(myDie1Text);
        myRollPanel.add(myDie2Text);
        myRollPanel.add(myTotalText);
        myRollPanel.add(myDie1);
        myRollPanel.add(myDie2);
        myRollPanel.add(myTotal);
        // Initialize labels and text fields to win panel
        myWinPanel = new JPanel();
        myPlayerTotal = new JLabel("Player Win Total:");
        myHouseTotal = new JLabel("House Win Total:");

        myWinPanel.add(myPlayerTotal);
        myWinPanel.add(myHouseTotal);
        // Initialize labels, buttons, and text fields to bet panel
        myBetPanel = new JPanel();
        mySetBet = new JButton("Set Bet");
        myDollarSign = new JLabel("$");
        myBet = new JTextField(20);
        myBet.setText("0");
        myBet.setEditable(false);
        myOne = new JButton("+$1");
        myFive = new JButton("+$5");
        myTen = new JButton("+$10");
        myFifthy = new JButton("+$50");
        myHundred = new JButton("+$100");
        myFiveHundred = new JButton("+$500");

        mySetBet.setEnabled(false);
        myOne.setEnabled(false);
        myFive.setEnabled(false);
        myTen.setEnabled(false);
        myFifthy.setEnabled(false);
        myHundred.setEnabled(false);
        myFiveHundred.setEnabled(false);

        // Add labels, buttons, and text fields to bet panel
        myBetPanel.add(mySetBet);
        myBetPanel.add(myBet);
        myBetPanel.add(myOne);
        myBetPanel.add(myFive);
        myBetPanel.add(myTen);
        myBetPanel.add(myFifthy);
        myBetPanel.add(myHundred);
        myBetPanel.add(myFiveHundred);
        // Add components to the layout
        myBankPanel = new JPanel(new GridBagLayout());
        GridBagConstraints bank = new GridBagConstraints();
        bank.fill = GridBagConstraints.HORIZONTAL;
        bank.gridx = 0;
        bank.gridy = 0;
        myBankPanel.add(myRoll, bank);

        bank.fill = GridBagConstraints.HORIZONTAL;
        bank.gridx = 0;
        bank.weightx = 1;
        bank.gridy = 2;
        bank.weighty = 1;
        myBankPanel.add(myRoll, bank);
        // Initialize button and text field to bank panel
        myBank = new JTextField(20);
        myBank.setEditable(false);
        myBank.setText("Bank Amount: " + craps.getMyBankAccount());
        myBank.getText();
        mySetBank = new JButton("Set Bank");
        // Add button and text field to bank panel
        myBankPanel.add(myDollarSign);
        myBankPanel.add(myBank);
        myBankPanel.add(mySetBank);
        // Add panels and text fields
        add(myPlayAgain);
        add(myRoll);
        add(myDie1);
        add(myDie2);
        add(myTotal);
        add(myPoint);
        add(myBank);
        add(myBetPanel);
        add(myWinPanel);
        addListeners();
    }

    public JMenuBar menu() {
        // Make new Menu bar and game and help menu
        final JMenuBar myMenuBar = new JMenuBar();
        final JMenu myGameMenu = new JMenu("Game");
        final JMenu myHelpMenu = new JMenu("Help");


        myGameMenu.setMnemonic(KeyEvent.VK_G);


        myHelpMenu.setMnemonic(KeyEvent.VK_H);
        // Start menu item and action listener for when start is pressed
        myStartMenu = new JMenuItem("Start");
        myStartMenu.setMnemonic(KeyEvent.VK_S);
        KeyStroke keyStart = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        myStartMenu.setAccelerator(keyStart);
        myStartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.Craps.getCrapsInstance().startGame();
                myDie1.setText("Die1");
                myDie2.setText("Die2");
                myTotal.setText("Total");
                myPoint.setText("Point");
                myRoll.setEnabled(true);
                myStartMenu.setEnabled(false);
                mySetBet.setEnabled(true);
                myOne.setEnabled(true);
                myFive.setEnabled(true);
                myTen.setEnabled(true);
                myFifthy.setEnabled(true);
                myHundred.setEnabled(true);
                myFiveHundred.setEnabled(true);
            }
        });
        // Rest of the menu items
        myReset = new JMenuItem("Reset");
        myReset.setMnemonic(KeyEvent.VK_R);
        KeyStroke keyReset = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
        myReset.setAccelerator(keyReset);
        myReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                craps.reset();
                myDie1.setText("Die1: 0");
                myDie2.setText("Die2: 0");
                myTotal.setText("Total: 0");
                myPoint.setText("Point: 0");
                myPlayerTotal.setText("My Player Wins: 0");
                myHouseTotal.setText("My House Wins: 0");
                myBet.setText("Bet Amount: 0");
                myBank.setText("Bank Account: 0");
                myStartMenu.setEnabled(true);
                myPlayAgain.setEnabled(false);
                myRoll.setEnabled(false);
            }
        });
        myExit = new JMenuItem("Exit");
        myExit.setMnemonic(KeyEvent.VK_E);
        KeyStroke keyExit = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        myExit.setAccelerator(keyExit);
        myExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Exit?",
                        "Game of Craps", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        myAbout = new JMenuItem("About");
        myAbout.setMnemonic(KeyEvent.VK_A);
        KeyStroke keyAbout = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        myAbout.setAccelerator(keyAbout);

        myRules = new JMenuItem("Rules");
        myRules.setMnemonic(KeyEvent.VK_T);
        KeyStroke keyRules = KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK);
        myRules.setAccelerator(keyRules);

        myShortcuts = new JMenuItem("Shortcuts", KeyEvent.VK_F);
        myShortcuts.setMnemonic(KeyEvent.VK_F);
        KeyStroke keyShortcuts = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        myShortcuts.setAccelerator(keyShortcuts);
        // Add the menu items to Game and Help menu
        myGameMenu.add(myStartMenu);
        myGameMenu.add(myReset);
        myGameMenu.add(myExit);
        myHelpMenu.add(myAbout);
        myAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String about = "Author: Adit Limbasia, Version 12/13/23, Java JDK 19";
                JOptionPane.showMessageDialog(null, about, "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        myHelpMenu.add(myRules);
        myRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rules = "The rules of the Game of craps are as follows:\n" +
                        "\n" +
                        "A player rolls two dice where each die has six faces in the usual way (values 1 through 6).\n" +
                        "After the dice have come to rest the sum of the two upward faces is calculated.\n" +
                        "The first roll/throw\n" +
                        "If the sum is 7 or 11 on the first throw the roller/player wins.\n" +
                        "If the sum is 2, 3 or 12 the roller/player loses, that is the house wins.\n" +
                        "If the sum is 4, 5, 6, 8, 9, or 10, that sum becomes the roller/player's 'point'.\n" +
                        "Continue rolling given the player's point\n" +
                        "Now the player must roll the 'point' total before rolling a 7 in order to win.\n" +
                        "If they roll a 7 before rolling the point value they got on the first roll the roller/player loses (the 'house' wins).";
                JOptionPane.showMessageDialog(null, rules, "Game Rules", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        myHelpMenu.add(myShortcuts);
        myShortcuts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shortcuts = "Shortcuts: Game menu- G, Help- H, Start- S + CTRL, Reset- R + CTRL, Exit- E + CTRL, About- A + CTRL, Rules- T + CTRL, Shortcuts- F + CTRL";
                JOptionPane.showMessageDialog(null, shortcuts, "Shortcuts", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // Add the Game and Help menu to the menu bar
        myMenuBar.add(myGameMenu);
        myMenuBar.add(myHelpMenu);
        return myMenuBar;
    }
    //Actions when buttons are clicked
    private void addListeners() {


        myRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                mySetBet.setEnabled(false);
                myOne.setEnabled(false);
                myFive.setEnabled(false);
                myTen.setEnabled(false);
                myFifthy.setEnabled(false);
                myHundred.setEnabled(false);
                myFiveHundred.setEnabled(false);
                if (craps.getGameActice()) {
                    craps.roll();
                    myDie1.setText("die1: " + craps.getDie1());
                    myDie2.setText("die2: " + craps.getDie2());
                    myTotal.setText("Total: " + craps.getTotal());
                    myBank.setText("Bank Amount: " + craps.getMyBankAccount());
                    craps.setCurrentBet(0);
                    myBet.setText("Bet Amount: " + craps.getBet());
                    if (craps.getPoint() != 0) {
                        myPoint.setText("point: " + craps.getPoint());
                    } else {
                        myPoint.setText("Point");
                    }
                    if (!craps.getGameActice()) {
                        if (craps.getGameWon()) {
                            JOptionPane.showMessageDialog(null, "You Won!");
                            myRoll.setEnabled(false);
                            myPlayAgain.setEnabled(true);
                            myPlayerTotal.setText("Player Wins: " + craps.getPlayerWins());
                        } else {
                            JOptionPane.showMessageDialog(null, "You Lost :(");
                            if (craps.getMyBankAccount() == 0) {
                                JOptionPane.showMessageDialog(null, "You have no money so you can't play");
                                myRoll.setEnabled(false);
                            } else {
                                myRoll.setEnabled(false);
                                myPlayAgain.setEnabled(true);
                                myHouseTotal.setText("House Wins: " + craps.getMyHouseWins());
                                }
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Game not active!");
                }
            }
        });
        myBank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps bank = Model.Craps.getCrapsInstance();
                try {
                    myBank.setText("Total Money " + bank.getMyBankAccount());
                } catch(NumberFormatException i) {
                    JOptionPane.showMessageDialog(null, "Please enter a non-negative integer", "Error", JOptionPane.ERROR_MESSAGE);
                    myBank.setText("");
                }
            }
        });

        myPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mySetBet.setEnabled(true);
                myOne.setEnabled(true);
                myFive.setEnabled(true);
                myTen.setEnabled(true);
                myFifthy.setEnabled(true);
                myHundred.setEnabled(true);
                myFiveHundred.setEnabled(true);
                myRoll.setEnabled(true);
                myPlayAgain.setEnabled(false);
                Craps craps = Model.Craps.getCrapsInstance();
                craps.setDie1(0);
                craps.setDie2(0);
                craps.setTotal(0);
                craps.setPoint(0);
                craps.setCurrentBet(0);
                craps.setGameActive(true);
                myBet.setText("Bet Amount "+ craps.getBet());
                myDie1Text.setText("Die 1: " + craps.getDie1());
                myDie2Text.setText("Die 2: " + craps.getDie2());
                myTotalText.setText("Total: " + craps.getTotal());
                myPointText.setText("Point: " + craps.getPoint());
            }
        });
        mySetBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                if (craps.getBet() > craps.getMyBankAccount()) {
                    JOptionPane.showMessageDialog(null, "Not enough money to bet");
                    craps.setCurrentBet(0);
                    myBet.setText("Bet Amount: 0");
                } else {
                    craps.setBankAccount(craps.getMyBankAccount() - craps.getBet());
                    myBank.setText("Bank Amount: " + craps.getMyBankAccount());
                    mySetBet.setEnabled(false);
                    myOne.setEnabled(false);
                    myFive.setEnabled(false);
                    myTen.setEnabled(false);
                    myFifthy.setEnabled(false);
                    myHundred.setEnabled(false);
                    myFiveHundred.setEnabled(false);
                }
            }
        });
        myOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                int bankValue = craps.getMyBankAccount();
                if (craps.getBet() > bankValue) {
                    JOptionPane.showMessageDialog(null, "Not enough money to bet");
                }
                else {
                    craps.setCurrentBet(craps.getBet() + 1);
                    myBet.setText("Bet Amount: " + craps.getBet());
                }
            }
        });

        myFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                int bankValue = craps.getMyBankAccount();
                if (craps.getBet() > craps.getMyBankAccount()) {
                    JOptionPane.showMessageDialog(null, "Not enough money to bet");
                } else {
                    craps.setCurrentBet(craps.getBet() + 5);
                    myBet.setText("Bet Amount: " + craps.getBet());
                }
            }
        });

        myTen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                int bankValue = craps.getMyBankAccount();
                if (craps.getBet() > craps.getMyBankAccount()) {
                    JOptionPane.showMessageDialog(null, "Not enough money to bet");
                }
                else {
                    craps.setCurrentBet(craps.getBet() + 10);
                    myBet.setText("Bet Amount: " + craps.getBet());
                }
            }
        });

        myFifthy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                int bankValue = craps.getMyBankAccount();
                if (craps.getBet() > craps.getMyBankAccount()) {
                    JOptionPane.showMessageDialog(null, "Not enough money to bet");
                }
                else {
                    craps.setCurrentBet(craps.getBet() + 50);
                    myBet.setText("Bet Amount: " + craps.getBet());
                }
            }
        });

        myHundred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                int bankValue = craps.getMyBankAccount();
                if (craps.getBet() > craps.getMyBankAccount()) {
                    JOptionPane.showMessageDialog(null, "Not enough money to bet");
                }
                else {
                    craps.setCurrentBet(craps.getBet() + 100);
                    myBet.setText("Bet Amount: " + craps.getBet());
                }
            }
        });

        myFiveHundred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Craps craps = Model.Craps.getCrapsInstance();
                int bankValue = craps.getMyBankAccount();
                if (craps.getBet() > craps.getMyBankAccount()) {
                    JOptionPane.showMessageDialog(null, "Not enough money to bet");
                }
                else {
                    craps.setCurrentBet(craps.getBet() + 500);
                    myBet.setText("Bet Amount: " + craps.getBet());
                }
            }
        });

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
