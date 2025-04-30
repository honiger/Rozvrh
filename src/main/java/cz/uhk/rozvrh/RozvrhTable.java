package cz.uhk.rozvrh;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RozvrhTable extends AbstractTableModel {

    private List<RozvrhovaAkce> akce;

    public RozvrhTable(List<RozvrhovaAkce> akce) {
        this.akce = akce;
    }

    private final String[] columnNames = {
            "Zkratka", "Název", "Den", "Začátek", "Konec", "Učitel"
    };

    @Override
    public int getRowCount() {
        return akce.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RozvrhovaAkce a = akce.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> a.predmet;
            case 1 -> a.nazev;
            case 2 -> a.den;
            case 3 -> a.hodinaSkutOd != null ? a.hodinaSkutOd.value : "";
            case 4 -> a.hodinaSkutDo != null ? a.hodinaSkutDo.value : "";
            case 5 -> a.ucitel != null ? (a.ucitel.titulPred + " " + a.ucitel.jmeno + " " + a.ucitel.prijmeni) : "";
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
