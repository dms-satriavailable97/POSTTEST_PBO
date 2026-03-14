import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main() {
        // List untuk menampung semua data joki yang masuk
        ArrayList<DataJoki> daftarPesanan = new ArrayList<>();
        Scanner inputKeyboard = new Scanner(System.in);
        int menuUtama;

        do {
            System.out.println("\n========================================");
            System.out.println("     SYSTEM MANAGEMENT JOKI WUWA");
            System.out.println("========================================");
            System.out.println("1. Tambah Pesanan Baru");
            System.out.println("2. Lihat Semua Daftar");
            System.out.println("3. Tandai Selesai (Update)");
            System.out.println("4. Hapus Data (Delete)");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: ");
            menuUtama = inputKeyboard.nextInt();
            inputKeyboard.nextLine(); // Pembersih enter

            if (menuUtama == 1) {
                System.out.println("\n--- INPUT DATA AKUN ---");
                System.out.print("Username Akun: "); String user = inputKeyboard.nextLine();
                if (user.equals("0")) continue;

                System.out.print("Password Akun: "); String pass = inputKeyboard.nextLine();
                System.out.print("Nomor HP/WA  : "); String hp = inputKeyboard.nextLine();

                System.out.println("\n--- PILIH TIPE JOKI ---");
                System.out.println("1. Build Character");
                System.out.println("2. Joki Event");
                System.out.println("3. Eksplor Map");
                System.out.println("0. Kembali");
                System.out.print("Pilih: ");
                int tipe = inputKeyboard.nextInt();
                inputKeyboard.nextLine();
                if (tipe == 0) continue;

                System.out.print("Nama (Karakter/Event/Map): ");
                String namaInput = inputKeyboard.nextLine();

                System.out.println("\n--- PILIH TINGKAT LAYANAN ---");
                if (tipe == 1) {
                    System.out.println("1. Leveling Saja (20rb)");
                    System.out.println("2. Build Echo/Artefak (45rb)");
                    System.out.println("3. Full Build (80rb)");
                } else if (tipe == 2) {
                    System.out.println("1. Mudah (15rb)");
                    System.out.println("2. Menengah (30rb)");
                    System.out.println("3. Sulit (50rb)");
                } else {
                    System.out.println("1. Area Kecil (25rb)");
                    System.out.println("2. Area Sedang (50rb)");
                    System.out.println("3. Full Map (100rb)");
                }
                System.out.println("0. Kembali");
                System.out.print("Pilih: ");
                int tingkat = inputKeyboard.nextInt();
                if (tingkat == 0) continue;

                // Membuat objek layanan dan memasukkannya ke daftar
                Layanan layananBaru = new Layanan(tipe, namaInput, tingkat);
                DataJoki dataBaru = new DataJoki(user, pass, hp, layananBaru);
                daftarPesanan.add(dataBaru);
                System.out.println(">> Berhasil Menambahkan Pesanan!");

            } else if (menuUtama == 2) {
                System.out.println("\n--- [ DAFTAR BELUM SELESAI ] ---");
                int nomorAntrian = 1;
                for (DataJoki d : daftarPesanan) {
                    //GETTER
                    if (d.getStatus() == 1) {
                        System.out.println(nomorAntrian + ". " + d.getInfoJoki().getNamaGrup() + ": " + d.getInfoJoki().getNamaPesanan());
                        System.out.println("   [Akun: " + d.getUsername() + " | Pass: " + d.getPassword() + " | WA: " + d.getNomorHp() + "]");
                        System.out.println("   Harga: Rp" + d.getInfoJoki().getDataHarga().getNilai());
                        nomorAntrian++;
                    }
                }
                if (nomorAntrian == 1) System.out.println("(Antrian Kosong)");

                System.out.println("\n--- [ RIWAYAT SUDAH SELESAI ] ---");
                int nomorRiwayat = 1;
                for (DataJoki d : daftarPesanan) {
                    //GETTER
                    if (d.getStatus() == 2) {
                        System.out.println(nomorRiwayat + ". " + d.getInfoJoki().getNamaPesanan() + " (DONE)");
                        nomorRiwayat++;
                    }
                }
                if (nomorRiwayat == 1) System.out.println("(Belum ada riwayat)");

            } else if (menuUtama == 3) {
                System.out.println("\n--- PILIH NOMOR YANG SUDAH SELESAI ---");
                boolean adaBelumSelesai = false;
                for (int i = 0; i < daftarPesanan.size(); i++) {
                    //GETTER
                    if (daftarPesanan.get(i).getStatus() == 1) {
                        System.out.println((i + 1) + ". " + daftarPesanan.get(i).getUsername() + " (" + daftarPesanan.get(i).getInfoJoki().getNamaGrup() + ")");
                        adaBelumSelesai = true;
                    }
                }

                if (adaBelumSelesai) {
                    System.out.print("Pilih Nomor Pesanan (0 Kembali): ");
                    int pilihUpdate = inputKeyboard.nextInt();
                    if (pilihUpdate > 0 && pilihUpdate <= daftarPesanan.size()) {
                        //SETTER
                        daftarPesanan.get(pilihUpdate - 1).setStatus(2);
                        System.out.println(">> Status berhasil diperbarui ke SELESAI!");
                    }
                } else {
                    System.out.println("Semua pesanan sudah selesai atau tidak ada data.");
                }

            } else if (menuUtama == 4) {
                System.out.println("\n--- PILIH NOMOR UNTUK DIHAPUS ---");
                if (daftarPesanan.isEmpty()) {
                    System.out.println("Data kosong.");
                } else {
                    for (int i = 0; i < daftarPesanan.size(); i++) {
                        // GETTER
                        System.out.println((i + 1) + ". " + daftarPesanan.get(i).getUsername() + " [" + daftarPesanan.get(i).getInfoJoki().getNamaGrup() + "]");
                    }
                    System.out.print("Masukkan Nomor (0 Kembali): ");
                    int pilihHapus = inputKeyboard.nextInt();
                    if (pilihHapus > 0 && pilihHapus <= daftarPesanan.size()) {
                        daftarPesanan.remove(pilihHapus - 1);
                        System.out.println(">> Data berhasil dihapus dari sistem!");
                    }
                }
            }

        } while (menuUtama != 5);

        System.out.println("Terima kasih! ");
    }
}