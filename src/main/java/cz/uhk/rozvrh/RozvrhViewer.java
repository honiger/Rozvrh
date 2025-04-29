package cz.uhk.rozvrh;

import javax.swing.*;
import java.awt.*;

public class RozvrhViewer extends JFrame {

    private JTable table;
    private JComboBox<String> comboBudova, comboMistnost;

    public RozvrhViewer() {
        setTitle("Rozvrh místnosti");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Vytvoření tlačítek a panelu
        JPanel topPanel = new JPanel();
        add(topPanel, BorderLayout.NORTH);
        comboBudova = new JComboBox<>(new String[]{"J", "A"});
        comboMistnost = new JComboBox<>(new String[]{"J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10"});
        JButton btnLoad = new JButton("Načíst rozvrh");

        //Přidání věcí do panelu
        topPanel.add(new JLabel("Budova:"));
        topPanel.add(comboBudova);
        topPanel.add(new JLabel("Místnost:"));
        topPanel.add(comboMistnost);
        topPanel.add(btnLoad);



    }
}
