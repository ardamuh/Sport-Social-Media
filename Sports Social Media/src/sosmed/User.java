package sosmed;

public class User {
    private String nama;
    private boolean isBlocked;

    public User(String nama) {
        this.nama = nama;
        this.isBlocked = false;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void block() {
        isBlocked = true;
    }

    public void unblock() {
        isBlocked = false;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
