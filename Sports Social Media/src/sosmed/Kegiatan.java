package sosmed;

import java.util.ArrayList;

public class Kegiatan {
    private String jenis;
    private String level;
    private String tanggal;
    private String tempat;
    private int minimal;
    private int maksimal;
    private double biaya;
    private String status;
    private ArrayList<User> peserta;

    public Kegiatan(String jenis, String level, String tanggal, String tempat, int minimal, int maksimal, double biaya) {
        this.jenis = jenis;
        this.level = level;
        this.tanggal = tanggal;
        this.tempat = tempat;
        this.minimal = minimal;
        this.maksimal = maksimal;
        this.biaya = biaya;
        this.status = "Terbuka";
        this.peserta = new ArrayList<>();
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public int getMinimal() {
        return minimal;
    }

    public void setMinimal(int minimal) {
        this.minimal = minimal;
    }

    public int getMaksimal() {
        return maksimal;
    }

    public void setMaksimal(int maksimal) {
        this.maksimal = maksimal;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    public ArrayList<User> getPeserta() {
        return peserta;
    }

    public void buka() {
        status = "Terbuka";
    }

    public void batalkan() {
        status = "Batal";
    }

    public void daftarPeserta(User user) {
        if (peserta.size() < maksimal)
            peserta.add(user);
        else
            System.out.println("Peserta penuh");
    }

    @Override
    public String toString() {
        return "Jenis : " + jenis + "\n" +
                "Level : " + level + "\n" +
                "Tanggal : " + tanggal + "\n" +
                "Status : " + status + "\n" +
                "Peserta Min : " + minimal + "\n" +
                "Jumlah Peserta : " + peserta.size();
    }
}
