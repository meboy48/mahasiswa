


package controller;

import model.Mahasiswa;
import modelDao.ImplementMahasiswa;
import modelDao.MahasiswaDAO;
import modelTabel.TabelModelMahasiswa;
import view.PanelForm;
import java.util.List;
import javax.swing.JOptionPane;


public class Controller {

    private final PanelForm panel;
    private List<Mahasiswa> list;
    private final ImplementMahasiswa implementMahasiswa;
    
    public Controller(PanelForm panel) {
        
        this.panel = panel;
        implementMahasiswa = new MahasiswaDAO();
        list = implementMahasiswa.getAllMahasiswa();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtNama().setText("");
        panel.getTxtAlamat().setText("");
        panel.getTxtProdi().setText("");
        panel.getTabelMahasiswa().clearSelection();
    }
    
    public void isiTabel(){
        list = implementMahasiswa.getAllMahasiswa();
        panel.getTabelMahasiswa().setModel(new TabelModelMahasiswa(list));
        
    }
    
    public  void getDataField(){
        
        int row = panel.getTabelMahasiswa().getSelectedRow();
        
        if (row != -1){
            
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtNama().setText(list.get(row).getNama());
            panel.getTxtAlamat().setText(list.get(row).getAlamat());
            panel.getTxtProdi().setText(list.get(row).getProdi());
            
        }
       
    }
    
    public void insert(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "ID Tidak Boleh Kosong...!!! ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(Integer.parseInt(panel.getTxtId().getText()));
        mahasiswa.setNama(panel.getTxtNama().getText());
        mahasiswa.setAlamat(panel.getTxtAlamat().getText());
        mahasiswa.setProdi(panel.getTxtProdi().getText());
        implementMahasiswa.input(mahasiswa);
    }

    public void update(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "ID Tidak Boleh Kosong...!!! ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(Integer.parseInt(panel.getTxtId().getText()));
        mahasiswa.setNama(panel.getTxtNama().getText());
        mahasiswa.setAlamat(panel.getTxtAlamat().getText());
        mahasiswa.setProdi(panel.getTxtProdi().getText());
        implementMahasiswa.update(mahasiswa);
    
    }
    
    public void delete(){
        
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Tidak ada data yang dihapus...!!! ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int row = Integer.parseInt(panel.getTxtId().getText());
        
        implementMahasiswa.delete(row);
        
    }
    
    
    public void getData(){
        
        if (panel.getTxtNama().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Isi data Nama yang mau di cari....? ", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nama = panel.getTxtNama().getText();
        
        implementMahasiswa.getMahasiswa(nama);
        isiTabelCari(nama);
    }

   public void isiTabelCari(String nama){
        
        list = implementMahasiswa.getMahasiswa(nama);
        panel.getTabelMahasiswa().setModel(new TabelModelMahasiswa(list));
    }
}
    

