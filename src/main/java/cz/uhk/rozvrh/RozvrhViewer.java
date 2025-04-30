package cz.uhk.rozvrh;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RozvrhViewer extends JFrame {

    private JTable table;
    private JComboBox<String> comboBudova, comboMistnost;

    public RozvrhViewer() {
        // Okno
        setTitle("Rozvrh místnosti");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel
        JPanel topPanel = new JPanel();
        comboBudova = new JComboBox<>(new String[]{"J", "A"});

        // Inicializace místností pro každou budovu
        comboMistnost = new JComboBox<>();
        updateMistnosti("J"); // výchozí budova J

        // Při změně budovy aktualizuj místnosti
        comboBudova.addActionListener(e -> {
            String vybranaBudova = (String) comboBudova.getSelectedItem();
            updateMistnosti(vybranaBudova);
        });

        JButton btnLoad = new JButton("Načíst rozvrh");

        topPanel.add(new JLabel("Budova:"));
        topPanel.add(comboBudova);
        topPanel.add(new JLabel("Místnost:"));
        topPanel.add(comboMistnost);
        topPanel.add(btnLoad);

        add(topPanel, BorderLayout.NORTH);

        // Tabulka
        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Načtení rozvrhu
        btnLoad.addActionListener(e -> {
            String budova = (String) comboBudova.getSelectedItem();
            String mistnost = (String) comboMistnost.getSelectedItem();

            try {
                List<RozvrhovaAkce> akce = RozvrhLoader.loadRozvrh(budova, mistnost);
                table.setModel(new RozvrhTable(akce));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Chyba: " + ex.getMessage());
            }
        });
    }

    private void updateMistnosti(String budova) {
        comboMistnost.removeAllItems();

        String[] mistnosti;
        if ("A".equals(budova)) {
            mistnosti = new String[]{"A1", "A2", "A3", "A4", "A5"};
        } else if ("J".equals(budova)) {
            mistnosti = new String[]{"J1", "J2", "J3", "J4", "J5"};
        } else {
            mistnosti = new String[]{};
        }

        for (String m : mistnosti) {
            comboMistnost.addItem(m);
        }
    }
}
