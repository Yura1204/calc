package com.calculator;

import com.calculator.gui.CalculatorFrame;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

/**
 * Главный класс для запуска приложения.
 */
public class AppLauncher {
    public static void main(String[] args) {
        // Установка стиля FlatLaf
        FlatLightLaf.install();

        // Создание и отображение основного окна калькулятора
        SwingUtilities.invokeLater(() -> {
            CalculatorFrame calculatorFrame = new CalculatorFrame();
            calculatorFrame.setVisible(true);
        });
    }
}
