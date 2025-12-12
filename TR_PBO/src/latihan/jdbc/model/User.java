package latihan.jdbc.model;

public class User {
    private int id;
    private String nama;
    private String hariAbsen; // Menyimpan tanggal dalam format String
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private String password;

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

    public String getHariAbsen() {
        return hariAbsen;
    }

    public void setHariAbsen(String hariAbsen) {
        this.hariAbsen = hariAbsen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
