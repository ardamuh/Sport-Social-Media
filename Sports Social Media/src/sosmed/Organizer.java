package sosmed;

public class Organizer extends User {
    public Organizer(String nama) {
        super(nama);
    }

    @Override
    public String toString() {
        return "Nama : " + super.getNama() + "\n" +
                "Status Blokir : " + super.isBlocked() + "\n" +
                "Tipe : " + this.getClass().getSimpleName() + "\n";
    }
}
