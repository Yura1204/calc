package com.calculator.gui;

import com.calculator.app.ButtonClickListener;
import com.calculator.gui.style.ButtonStyler;
import com.calculator.gui.style.TextFieldStyler;
import com.calculator.math.CalculatorHandler;

import javax.swing.*;
import java.awt.*;

/*
* Графический интерфейс для калькулятора
*/
public class CalculatorFrame extends JFrame {
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton openParenthesisButton;
    private JButton closeParenthesisButton;
    private JButton decimalButton;
    private JButton clearButton;
    private JButton backspaceButton;

    /**
     * Конструктор класса CalculatorFrame, создающий графический интерфейс калькулятора.
     */
    public CalculatorFrame() {
        setTitle("Калькулятор");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        * кнопки с соответствующими знаками операций и функциями.
        */
        inputField = new JTextField();
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        openParenthesisButton = new JButton("(");
        closeParenthesisButton = new JButton(")");
        decimalButton = new JButton(".");
        clearButton = new JButton("C");
        backspaceButton = new JButton("\u232b");

        // Применяем стиль к текстовому полю
        TextFieldStyler.applyCustomStyle(inputField);

        // Применяем стиль к кнопкам
        ButtonStyler.applyCustomStyle1(
                addButton, subtractButton, multiplyButton, divideButton,
                openParenthesisButton, closeParenthesisButton,
                decimalButton, clearButton, backspaceButton, equalsButton
        );

        /*
        * массив из 10 кнопок, каждая из которых соответствует цифре от 0 до 9.
        */
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(new ButtonClickListener(inputField));
        }
        ButtonStyler.applyCustomStyle2(numberButtons);

        /*
        * Для кнопок также добавляется слушатель ButtonClickListener,
        * чтобы они добавляли соответствующий символ в текстовое поле.
        */
        addButton.addActionListener(new ButtonClickListener(inputField));
        subtractButton.addActionListener(new ButtonClickListener(inputField));
        multiplyButton.addActionListener(new ButtonClickListener(inputField));
        divideButton.addActionListener(new ButtonClickListener(inputField));
        openParenthesisButton.addActionListener(new ButtonClickListener(inputField));
        closeParenthesisButton.addActionListener(new ButtonClickListener(inputField));
        decimalButton.addActionListener(new ButtonClickListener(inputField));

        /*
        * Для кнопок "C", "⌫" и "=" настраивается слушатель событий из класса ButtonActionHandler
        */
        CalculatorHandler calculatorHandler = new CalculatorHandler(inputField);
        calculatorHandler.setupButtonActions(clearButton, backspaceButton, equalsButton);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(divideButton);

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(multiplyButton);

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(subtractButton);

        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(openParenthesisButton);
        buttonPanel.add(closeParenthesisButton);
        buttonPanel.add(addButton);

        buttonPanel.add(clearButton);
        buttonPanel.add(backspaceButton);
        buttonPanel.add(decimalButton);
        buttonPanel.add(equalsButton);

        // Установка компоновки элементов на окне
        setLayout(new BorderLayout());
        add(inputField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
