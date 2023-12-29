/*
 * Adit Limbasia
 * CrapsController
 * Autumn 2023
 */
package Controller;

import Model.Craps;
import View.CrapsView;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/**
 * This class is main is located and where the program runs.
 *This is where user input and updating the view based on model changes happen
 *
 * @author Adit Limbasia
 * @version Autumn 2023
 */
public class CrapsController extends JPanel implements PropertyChangeListener {
    /** The default toolkit used for obtaining the screen size. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    /** The screen size of the default toolkit. */
    private static final Dimension SCREEN_SIZE;
    /** The number of rows in the layout.*/
    private static final int ROW = 4;
    /** The number of columns in the layout.*/
    private static final int COL = 1;
    /** The horizontal margin for the layout.*/
    private static final int HORIZONATAL_MARGIN = 20;
    /** The vertical margin for the layout. */
    private static final int VERTICALL_MARGIN = 10;
    /** The number of columns for the text area.*/
    private static final int TEXT_AREA_COLS = 25;
    /** The default window size. */
    private static final int WINDOW_SIZE = 200;

    private final JTextArea myOutput;

    /**
     * Constructs a new CrapsController with the specified Craps instance.
     * @param theCraps The Craps instance associated with this controller.
     */
    public CrapsController(Craps theCraps) {
        super(new GridLayout(40, 10, 10, 200));
        this.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 100));
        this.myOutput = new JTextArea(4, 25);
    }

    /**
     * The main method that creates an instance of CrapsView, sets up the GUI,
     * and starts the Craps game.
     * @param theArgs The command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final CrapsView mainPanel = new CrapsView();

                final Dimension frameSize = new Dimension( 1000, 1000);
                Craps.getCrapsInstance().addPropertyChangeListener(mainPanel);
                final JFrame window = new JFrame("The Game of Craps :)");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setJMenuBar(mainPanel.menu());
                window.setContentPane(mainPanel);
                window.setSize(frameSize);
                window.setVisible(true);
            }
        });
    }

    /**
     * Handles property change events. If the "Active" property changes to false,
     * displays a message indicating that the game is not active.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() == "Active")
            if ((boolean)evt.getNewValue() == false){
                JOptionPane.showMessageDialog(null, "Game not active!");
            }
    }
    /** Static block to initialize the screen size.*/
    static {
        SCREEN_SIZE = KIT.getScreenSize();
    }
}
