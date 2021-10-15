package sosmed;

import java.util.ArrayList;
import java.util.Scanner;

public class SosialMediaOlahraga implements Aktifitas {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Kegiatan> kegiatans = new ArrayList<>();

    public static void main(String[] args) {
        SosialMediaOlahraga sosmed = new SosialMediaOlahraga();
        sosmed.run();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        String pengumuman = "";

        users.add(new Organizer("Patrik"));
        users.add(new Player("Kim jing in"));
        users.add(new Player("Budi"));

        while (isRunning) {
            System.out.println("PENGUMUMAN");
            System.out.println(pengumuman);
            System.out.println("================================================================================");
            System.out.println("1. Admin");
            System.out.println("2. sosmed.Organizer");
            System.out.println("3. sosmed.Player");
            System.out.println("4. Keluar");
            System.out.print("Login sebagai: ");
            boolean sesiAktif = true;
            int user = scanner.nextInt();

            switch (user) {
                case 1:
                    while (sesiAktif) {
                        System.out.println("ADMIN");
                        System.out.println("1. Block/unblock user");
                        System.out.println("2. Posting pengumuman");
                        System.out.println("3. Keluar");
                        System.out.print("Masukkan pilihan: ");
                        int menuAdmin = scanner.nextInt();
                        switch (menuAdmin) {
                            case 1:
                                for (User u : users) {
                                    System.out.println(u.toString());
                                }

                                System.out.println("Masukkan nama user: ");
                                scanner.nextLine();
                                String namaBlock = scanner.nextLine();

                                User userBlock = searchUserByName(namaBlock);
                                if (userBlock != null) {
                                    System.out.println("1. Block");
                                    System.out.println("2. Unblock");
                                    System.out.print("Masukkan opsi: ");
                                    int opsiBlock = scanner.nextInt();

                                    if (opsiBlock == 1) {
                                        userBlock.block();
                                        System.out.println("Berhasil mem-block");
                                    } else if (opsiBlock == 2) {
                                        userBlock.unblock();
                                        System.out.println("Berhasil meng-unblock");
                                    } else {
                                        System.out.println("Opsi tidak tersedia");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Masukkan pengumuman: ");
                                scanner.nextLine();
                                pengumuman = scanner.nextLine();
                                break;
                            case 3:
                                sesiAktif = false;
                                System.out.println("Berhasil keluar...");
                                break;
                            default:
                                System.out.println("Opsi tidak tersedia.");
                        }
                    }
                    break;
                case 2:
                    while (sesiAktif) {
                        System.out.println("ORGANIZER");
                        for (User u : users) {
                            if (u instanceof Organizer) {
                                System.out.println(u);
                            }
                        }
                        System.out.print("Masuk sebagai (nama): ");
                        scanner.nextLine();
                        String namaOrganizer = scanner.nextLine();
                        User organizerAktif = null;
                        try {
                            organizerAktif = searchUserByName(namaOrganizer);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        if (organizerAktif == null) {
                            System.out.println("sosmed.Organizer tidak terdaftar");
                            break;
                        }
                        if (!(organizerAktif instanceof Organizer)) {
                            System.out.println("sosmed.User bukan organizer");
                            break;
                        }

                        System.out.println("Menu");
                        System.out.println("1. Lihat program");
                        System.out.println("2. Tambah program");
                        System.out.println("3. Batalkan program");
                        System.out.println("4. Keluar");
                        System.out.print("Masukkan pilihan: ");
                        int opsiOrganizer = scanner.nextInt();
                        switch (opsiOrganizer) {
                            case 1:
                                System.out.println("Daftar kegiatan");
                                for (Kegiatan k : kegiatans) {
                                    System.out.println(k.toString());
                                }
                                break;
                            case 2:
                                System.out.println("Tambah kegiatan");
                                System.out.print("Jenis: ");
                                scanner.nextLine();
                                String jenis = scanner.nextLine();
                                System.out.print("Level: ");
                                String level = scanner.nextLine();
                                System.out.print("Tanggal: ");
                                String tanggal = scanner.nextLine();
                                System.out.print("Tempat: ");
                                String tempat = scanner.nextLine();
                                System.out.print("Minimal Peserta: ");
                                int min = scanner.nextInt();
                                System.out.print("Maksimal Peserta: ");
                                int max = scanner.nextInt();
                                System.out.print("Biaya: ");
                                double biaya = scanner.nextDouble();

                                Kegiatan kegiatan = new Kegiatan(jenis, level, tanggal, tempat, min, max, biaya);
                                kegiatans.add(kegiatan);
                                System.out.println("Berhasil menambah kegiatan");
                                break;
                            case 3:
                                System.out.println("Batalkan kegiatan");
                                int noKegiatan = 1;
                                for (Kegiatan k : kegiatans) {
                                    System.out.println(noKegiatan + "\n" + k.toString());
                                    noKegiatan++;
                                }
                                System.out.print("Masukkan nomor urut kegiatan yang akan dibatalkan: ");
                                int noBatalKegiatan = scanner.nextInt();
                                if (noBatalKegiatan < 1 || noBatalKegiatan > kegiatans.size()) {
                                    System.out.println("sosmed.Kegiatan tidak terdaftar");
                                    break;
                                }
                                kegiatans.get(noBatalKegiatan - 1).batalkan();
                                System.out.println("Berhasil membatalkan kegiatan");
                                break;
                            case 4:
                                sesiAktif = false;
                                System.out.println("Berhasil keluar...");
                                break;
                            default:
                                System.out.println("Opsi tidak tersedia");
                        }
                    }
                    break;
                case 3:
                    while (sesiAktif) {
                        System.out.println("PLAYER");
                        for (User u : users) {
                            if (u instanceof Player) {
                                System.out.println(u);
                            }
                        }
                        System.out.print("Masuk sebagai (nama): ");
                        scanner.nextLine();
                        String namaPlayer = scanner.nextLine();
                        User playerAktif = searchUserByName(namaPlayer);
                        if (playerAktif == null) {
                            System.out.println("sosmed.Player tidak tersedia");
                            break;
                        }
                        if (!(playerAktif instanceof Player)) {
                            System.out.println("sosmed.User bukan player");
                            break;
                        }

                        System.out.println("Menu");
                        System.out.println("1. Mendaftar kegiatan");
                        System.out.println("2. Beri lencana ke peserta");
                        System.out.println("3. Batal ikut kegiatan");
                        System.out.println("4. Keluar");

                        System.out.print("Masukkan pilihan: ");
                        int opsiPeserta = scanner.nextInt();
                        switch (opsiPeserta) {
                            case 1:
                                System.out.println("Daftar kegiatan");
                                int noKegiatan = 1;
                                for (Kegiatan k : kegiatans) {
                                    System.out.println(noKegiatan + "\n" + k.toString());
                                    noKegiatan++;
                                }
                                System.out.print("Masukkan nomor urut kegiatan yang akan didaftar: ");
                                int noDaftarKegiatan = scanner.nextInt();
                                if (noDaftarKegiatan < 1 || noDaftarKegiatan > kegiatans.size()) {
                                    System.out.println("sosmed.Kegiatan tidak terdaftar");
                                    break;
                                }
                                ((Player) playerAktif).daftar(kegiatans.get(noDaftarKegiatan - 1));
                                System.out.println("Berhasil mendaftar");
                                break;
                            case 2:
                                System.out.println("Daftar Peserta");
                                for (User u : users) {
                                    if (u instanceof Player && u != playerAktif) {
                                        System.out.println(u);
                                    }
                                }
                                System.out.print("Masukkan nama peserta: ");
                                scanner.nextLine();
                                String userLencanaNama = scanner.nextLine();
                                User userLencana = searchUserByName(userLencanaNama);
                                if (userLencana == null) {
                                    System.out.println("sosmed.User tidak terdaftar");
                                    break;
                                }
                                if (userLencana instanceof Player) {
                                    System.out.println("sosmed.User tidak terdaftar");
                                    break;
                                }
                                System.out.print("Masukkan nama lencana: ");
                                String lencanaBaru = scanner.nextLine();
                                try {
                                    ((Player) userLencana).addLencana(lencanaBaru);
                                } catch (ClassCastException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                                System.out.println("Berhasil menambah lencana");
                                break;
                            case 3:
                                System.out.println("Daftar kegiatan");
                                int noKegiatanTerdaftar = 1;
                                for (Kegiatan k : ((Player) playerAktif).getKegiatans()) {
                                    System.out.println(noKegiatanTerdaftar + "\n" + k.toString());
                                    noKegiatanTerdaftar++;
                                }
                                System.out.print("Masukkan nomor urut kegiatan yang akan didaftar: ");
                                int noDaftarKegiatanTerdaftar = scanner.nextInt();
                                if (noDaftarKegiatanTerdaftar < 1 || noDaftarKegiatanTerdaftar > kegiatans.size()) {
                                    System.out.println("sosmed.Kegiatan tidak terdaftar");
                                    break;
                                }
                                try {
                                    ((Player) playerAktif).batal(kegiatans.get(noDaftarKegiatanTerdaftar - 1));
                                } catch (ClassCastException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                                System.out.println("Berhasil membatalkan");
                                break;
                            case 4:
                                sesiAktif = false;
                                System.out.println("Berhasil keluar...");
                                break;
                            default:
                                System.out.println("Opsi tidak tersedia");
                        }
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Berhasil keluar...");
                    break;
                default:
                    System.out.println("Opsi tidak tersedia");
            }
        }
    }

    @Override
    public User searchUserByName(String nama) {
        User user = null;
        for (User u : users) {
            if (u.getNama().equalsIgnoreCase(nama)) {
                user = u;
            }
        }
        return user;
    }
}
