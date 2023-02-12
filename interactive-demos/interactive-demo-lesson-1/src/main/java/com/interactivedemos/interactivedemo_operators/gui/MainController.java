package com.interactivedemos.interactivedemo_operators.gui;

import com.interactivedemos.interactivedemo_operators.operators.combined.*;
import com.interactivedemos.interactivedemo_operators.operators.standard.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    // Demo 1 Controls
    @FXML
    Button toggleButton;

    @FXML
    TextField inputA;

    @FXML
    TextField inputB;

    @FXML
    Label binaryA;

    @FXML
    Label binaryB;

    @FXML
    Label binaryAnswer;

    @FXML
    Label answerLabel;

    @FXML
    Label errorLabel;

    // Demo 2 Controls
    @FXML
    Button demo2ToggleButton;

    @FXML
    TextField demo2InputA;

    @FXML
    TextField demo2InputB;

    @FXML
    Label demo2BinaryA;

    @FXML
    Label demo2BinaryB;

    @FXML
    Label demo2BinaryAnswer;

    @FXML
    Label demo2AnswerLabel;

    @FXML
    Label demo2ErrorLabel;

    // Array of operator implementations.
    private final Operator[] operators = new Operator[]{
            new AdditionOperator(),
            new SubtractionOperator(),
            new MultiplicationOperator(),
            new DivisionOperator(),
            new RemainderOperator()
    };

    // Array of combined operator implementations.
    private final CombinedOperator[] combinedOperators = new CombinedOperator[]{
            new CombinedAdditionOperator(),
            new CombinedSubtractionOperator(),
            new CombinedMultiplicationOperator(),
            new CombinedDivisionOperator(),
            new CombinedRemainderOperator()
    };

    // Holds the array index number of the currently selected operator.
    private int currentOperatorIndex;

    /** This method is called after the JavaFX stage is initialised.
     * @param url unused.
     * @param resourceBundle unused.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set button signs initially.
        toggleButton.setText(operators[currentOperatorIndex].getSign());
        demo2ToggleButton.setText(combinedOperators[currentOperatorIndex].getSign());
        // Link text between the two sets of input and output fields.
        demo2InputA.textProperty().bindBidirectional(inputA.textProperty());
        demo2InputB.textProperty().bindBidirectional(inputB.textProperty());
        demo2BinaryA.textProperty().bind(binaryA.textProperty());
        demo2BinaryB.textProperty().bind(binaryB.textProperty());
        demo2AnswerLabel.textProperty().bind(answerLabel.textProperty());
        demo2BinaryAnswer.textProperty().bind(binaryAnswer.textProperty());
        demo2ErrorLabel.textProperty().bind(errorLabel.textProperty());
        // Link visibility state between the two error labels.
        demo2ErrorLabel.visibleProperty().bind(errorLabel.visibleProperty());
    }

    /** calculate takes the current inputs A and B, as well as the currently
     *  selected operator. The operator performs the associated calculation,
     *  using the two operands and updates the relevant label with the answer.
     *
     *  In addition, several other labels are update to display the binary equivalent
     *  of all decimal numbers.
     *
     *  This method is triggered as an event handler by key presses in the GUI input text fields. */
    @FXML protected void calculate() {
        try {
            // Hide error label.
            errorLabel.setVisible(false);
            // Get user inputs and parse them as integers for use in calculations.
            int a = Integer.parseInt(inputA.getText());
            int b = Integer.parseInt(inputB.getText());
            // Perform calculation using currently selected operator and operands a & b.
            var answer = operators[currentOperatorIndex].calculate(a,b);
            // Update 'answer' label with answer.
            answerLabel.setText(answer.toString());
            // Update binary representation labels.
            binaryA.setText(Integer.toBinaryString(a));
            binaryB.setText(Integer.toBinaryString(b));
            binaryAnswer.setText(Integer.toBinaryString(answer));
        } catch (NumberFormatException ignored) {
            // Set error label text.
            errorLabel.setText("Error: Invalid inputs.");
            // Show error label.
            errorLabel.setVisible(true);
        }
    }

    /** toggleOperator increments the 'currentOperatorIndex' which is used as
     *  an array index for both the 'operators' and 'combinedOperators' arrays.
     *  This effectively cycles the currently selected operators.
     *
     *  When the index increments past the last operator in both arrays, it wraps around.
     *
     *  This method is called as an eventHandler by a mouse click on the GUI operator buttons.
     *  It triggers a re-calculation of the result given the new operator. */
    @FXML
    protected void toggleOperator() {
        currentOperatorIndex = (currentOperatorIndex + 1 == operators.length) ? -1 : currentOperatorIndex;
        currentOperatorIndex++;
        toggleButton.setText(operators[currentOperatorIndex].getSign());
        demo2ToggleButton.setText(combinedOperators[currentOperatorIndex].getSign());
        calculate();
    }
}