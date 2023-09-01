package com.calculator.gui.style;

import javax.swing.*;
import java.awt.*;

public class ButtonStyler {

    public static void applyCustomStyle1(JButton... buttons) {
        Color buttonColor = new Color(128, 128, 128);

        for (JButton button : buttons) {
            button.setBackground(buttonColor);
            button.setFont(new Font("Hack", Font.BOLD, 20));
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false); // Убираем рамку при фокусе
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Устанавливаем отступы
        }
    }
    public static void applyCustomStyle2(JButton... buttons) {
        Color buttonColor = new Color(255, 165, 0);

        for (JButton button : buttons) {
            button.setBackground(buttonColor);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false); // Убираем рамку при фокусе
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Устанавливаем отступы
        }
    }
}
