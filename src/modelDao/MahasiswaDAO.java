

package modelDao;

import model.Mahasiswa;
import modelDatabase.ConnectionDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MahasiswaDAO implements ImplementMahasiswa{
    
    private List<Mahasiswa> list;
            
    @Override
    public void input(Mahasiswa mahasiswa) {
        
        try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement(""
                    + "INSERT INTO mahasiswa (id, nama, alamat, prodi) VALUES (?, ?, ?, ?)");
            statement.setInt(1, mahasiswa.getId());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getAlamat());
            statement.setString(4, mahasiswa.getProdi());
            statement.executeUpdate();
          
          
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Mahasiswa mahasiswa) {
          try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement(""
                    + "UPDATE mahasiswa SET id=?, nama=?, alamat=?, prodi=? WHERE id=? or nama=? or alamat=?");
            
            statement.setInt(1, mahasiswa.getId());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getAlamat());
            statement.setString(4, mahasiswa.getProdi());
            
            statement.setInt(5, mahasiswa.getId());
            statement.setString(6, mahasiswa.getNama());
            statement.setString(7, mahasiswa.getAlamat());
          
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          
    }

    @Override
    public void delete(int id) {
   
          try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement(""
                    + "DELETE FROM mahasiswa WHERE id=?");
            
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

    @Override
    public List<Mahasiswa> getMahasiswa(String nama) {
        list = new ArrayList<Mahasiswa>();
        
        try {
            
            Statement statement = ConnectionDatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM mahasiswa WHERE nama LIKE '%" + nama + "%' ");
            
            while (result.next()) { 
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setId(result.getInt("id"));
                mahasiswa.setNama(result.getString("nama"));
                mahasiswa.setAlamat(result.getString("alamat"));
                mahasiswa.setProdi(result.getString("prodi"));
                list.add(mahasiswa);
            }
            
            statement.close();
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
    list = new ArrayList<Mahasiswa>();
        
        try {
            
            Statement statement = ConnectionDatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM mahasiswa");
            
            while (result.next()) { 
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setId(result.getInt("id"));
                mahasiswa.setNama(result.getString("nama"));
                mahasiswa.setAlamat(result.getString("alamat"));
                mahasiswa.setProdi(result.getString("prodi"));
                list.add(mahasiswa);
            }
            
            
            statement.close();
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
