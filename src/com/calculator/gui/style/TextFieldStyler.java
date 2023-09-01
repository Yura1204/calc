package com.calculator.gui.style;

import javax.swing.*;
import java.awt.*;

public class TextFieldStyler {
    public static void applyCustomStyle(JTextField textField) {
        Color backgroundColor = new Color(220, 220, 220); // Новый цвет фона текстового поля
        Font textFieldFont = new Font("Arial", Font.BOLD, 30);

        textField.setBackground(backgroundColor); // Задаем новый цвет фона
        textField.setFont(textFieldFont); // Устанавливаем шрифт
        textField.setForeground(Color.BLACK);
        textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Устанавливаем отступы
    }
}

