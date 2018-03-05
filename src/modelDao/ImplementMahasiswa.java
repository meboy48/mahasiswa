

package modelDao;

import model.Mahasiswa;
import java.util.List;


public interface ImplementMahasiswa {
    
    public void input(Mahasiswa mahasiswa);
    
    public void update(Mahasiswa mahasiswa);
    
    public void delete(int id);
    
    public List<Mahasiswa> getMahasiswa(String nama);
    
    public List<Mahasiswa> getAllMahasiswa();

}
