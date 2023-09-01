package com.calculator.math;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс CalculatorHandler управляет действиями кнопок калькулятора и соответствующим образом обновляет текстовое поле.
 */
public class CalculatorHandler {
    private JTextField inputField;

    public CalculatorHandler(JTextField inputField) {
        this.inputField = inputField;
    }

    /**
     * Настраивает слушателей действий для предоставленных кнопок.
     *
     * @param clearButton    Кнопка, которая очищает текстовое поле.
     * @param backspaceButton Кнопка, которая удаляет последний символ из текстового поля.
     * @param equalsButton   Кнопка, которая вычисляет ввод и обновляет текстовое поле результатом.
     */
    public void setupButtonActions(JButton clearButton, JButton backspaceButton, JButton equalsButton) {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText(""); // Очищаем текстовое поле
            }
        });

        // Действие кнопки "Возврат на один символ"
        backspaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = inputField.getText();
                if (!currentText.isEmpty()) {
                    inputField.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

        // Действие кнопки "Равно"
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                double result = processInput(input);
                inputField.setText(Double.toString(result)); // Обновление текстового поля
            }
        });
    }

    /*
    * Вычисляет введенное выражение и возвращает результат.
    */
    private double processInput(String input) {
        try {
            ExpressionParser parser = new ExpressionParser(input);
            return parser.parse();
        } catch (Exception e) {
            return 0.0; // Пример значения для некорректного ввода
        }
    }
}
