package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;

    /* CONSTRUCTOR */

    public TicTacToeController(int width) {

        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this,width);

    }

    public String getMarkAsString(int row, int col) {
        return (model.getMark(row, col).toString());
    }
    
    public TicTacToeView getView() {
        return view;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        // INSERT YOUR CODE HERE
        Object source = event.getSource();

        if (source instanceof JButton) {

            JButton button = (JButton)source;

            String buttonName = button.getName();

            int numRow = 0;
            int numCol = 0;
            Character charRow;
            Character charCol;

            charRow = buttonName.charAt(6);
            charCol = buttonName.charAt(7);

            numRow = Character.getNumericValue(charRow);
            numCol = Character.getNumericValue(charCol);

            view.updateSquares(button, model.isXTurn(), model.makeMark(numRow,numCol));
            
            if(!model.getResult().toString().equals("NONE")) {
                
                view.disableSquares();
                view.showResult(model.getResult().toString());
            }
            
        }
    }
}

