package com.calculator.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Этот класс отвечает за обработку нажатий кнопок.
 * Он позволяет добавлять текст с нажатых кнопок в поле ввода.
 */
public class ButtonClickListener implements ActionListener {
    private JTextField inputField; // Поле, куда будет добавляться текст

    public ButtonClickListener(JTextField inputField) {
        this.inputField = inputField;
    }

    /**
     * Метод, который будет вызван при нажатии на кнопку.
     *
     * @param e Объект события, содержащий информацию о нажатии
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource(); // Получаем кнопку, на которую нажали
        String buttonText = button.getText(); // Получаем текст с кнопки
        inputField.setText(inputField.getText() + buttonText); // Добавляем к полю текст
    }
}