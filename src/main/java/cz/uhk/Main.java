package cz.uhk;

import cz.uhk.rozvrh.RozvrhViewer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RozvrhViewer().setVisible(true));
    }
}
