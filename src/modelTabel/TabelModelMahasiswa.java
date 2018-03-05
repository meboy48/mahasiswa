
package modelTabel;

import model.Mahasiswa;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelModelMahasiswa extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    List<Mahasiswa> list ;

    public TabelModelMahasiswa(List<Mahasiswa> list) {
        this.list = list;
    }
       
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getAlamat();
            case 3 : return list.get(rowIndex).getProdi();    
                default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "NIM";
            case 1 : return "NAMA";
            case 2 : return "ALAMAT";
            case 3 : return "PRODI";   
                default:return null;
        }
    }
    
    

}
