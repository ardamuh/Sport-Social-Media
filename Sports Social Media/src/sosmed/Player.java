package sosmed;

import java.util.ArrayList;

public class Player extends User {
    private int level;
    private ArrayList<String> lencana;
    private ArrayList<Kegiatan> kegiatans;

    public Player(String nama) {
        super(nama);
        this.level = 0;
        this.lencana = new ArrayList<>();
        this.kegiatans = new ArrayList<>();
    }

    public void levelUp() {
        level++;
    }

    public void levelDown() {
        if (level > 0) level--;
    }

    public void addLencana(String len) {
        lencana.add(len);
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<String> getLencana() {
        return lencana;
    }

    public ArrayList<Kegiatan> getKegiatans() {
        return kegiatans;
    }

    public void daftar(Kegiatan kegiatan) {
        kegiatans.add(kegiatan);
        kegiatan.daftarPeserta(this);
        levelUp();
    }

    public void batal(Kegiatan kegiatan) {
        kegiatans.remove(kegiatan);
        kegiatan.getPeserta().remove(this);
        levelDown();
    }

    @Override
    public String toString() {
        return "Nama : " + super.getNama() + "\n" +
                "Status Blokir : " + super.isBlocked() + "\n" +
                "Tipe : " + this.getClass().getSimpleName() + "\n" +
                "Level : " + level + "\n" +
                "Lencana : " + lencana.toString() + "\n";
    }
}