package latihan.jdbc.model;

public class Karyawan {
    private int id;
    private String nama;
    private String hp;
    private String stats;
    private String kelamin;
    private String jabatan;
    private String bulan;
    private String tanggal;
    private String keterangan;

    public String getBulan() {
        return bulan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabaran) {
        this.jabatan = jabaran;
    }

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

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }


}
