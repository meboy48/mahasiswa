

package model;


public class Mahasiswa {
    
    private int id;
    private String nama;
    private String alamat;
    private String prodi;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getProdi(){
        return prodi;
    }
    public void setProdi(String prodi){
        this.prodi=prodi;
    }
    

}
