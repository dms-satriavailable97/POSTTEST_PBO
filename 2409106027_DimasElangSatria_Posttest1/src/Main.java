import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<DataJoki> daftar = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int menu;

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
            menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {
                // --- MENU TAMBAH DATA ---
                System.out.println("\n--- TAMBAH DATA (Ketik '0' untuk Kembali) ---");
                System.out.print("Username: "); String user = input.nextLine();
                if (user.equals("0")) continue;

                System.out.print("Password: "); String pass = input.nextLine();
                System.out.print("No HP: "); String hp = input.nextLine();

                System.out.println("\n--- PILIH LAYANAN ---");
                System.out.println("1. Build Character (Rp30.000)");
                System.out.println("2. Joki Event");
                System.out.println("3. Eksplor Map");
                System.out.println("0. Kembali");
                System.out.print("Pilihan: ");
                int pil = input.nextInt();
                input.nextLine();

                if (pil == 1) {
                    System.out.print("Nama Karakter: ");
                    String chara = input.nextLine();
                    daftar.add(new DataJoki(user, pass, hp, "Build Char", chara, 30000));
                    System.out.println(">> Berhasil Ditambahkan!");
                }
                else if (pil == 2) {
                    System.out.print("Nama Event: ");
                    String namaEvent = input.nextLine();

                    System.out.println("\n1. Mudah (Rp15rb)\n2. Menengah (Rp30rb)\n3. Sulit (Rp50rb)\n0. Kembali");
                    System.out.print("Pilih Kesulitan: ");
                    int sulit = input.nextInt();

                    if (sulit != 0) { // Cek: Jika bukan 0, baru diproses
                        int harga = 0;
                        String ket = "";
                        if (sulit == 1) { harga = 15000; ket = namaEvent + " [Mudah]"; }
                        else if (sulit == 2) { harga = 30000; ket = namaEvent + " [Menengah]"; }
                        else { harga = 50000; ket = namaEvent + " [Sulit]"; }

                        daftar.add(new DataJoki(user, pass, hp, "Event", ket, harga));
                        System.out.println(">> Berhasil Ditambahkan!");
                    }
                }
                else if (pil == 3) {
                    System.out.print("Nama Map/Area: ");
                    String namaMap = input.nextLine();

                    System.out.println("\n1. Area Kecil (Rp25rb)\n2. Area Menengah (Rp50rb)\n3. Full Map (Rp100rb)\n0. Kembali");
                    System.out.print("Pilih Luas Map: ");
                    int luas = input.nextInt();

                    if (luas != 0) { // Cek: Jika bukan 0, baru diproses
                        int harga = 0;
                        String ket = "";
                        if (luas == 1) { harga = 25000; ket = namaMap + " [Kecil]"; }
                        else if (luas == 2) { harga = 50000; ket = namaMap + " [Menengah]"; }
                        else { harga = 100000; ket = namaMap + " [Full Map]"; }

                        daftar.add(new DataJoki(user, pass, hp, "Eksplor", ket, harga));
                        System.out.println(">> Berhasil Ditambahkan!");
                    }
                }

            } else if (menu == 2) {
                // --- LIHAT DATA ---
                System.out.println("\n--- [ ANTRIAN AKTIF ] ---");
                for (int i = 0; i < daftar.size(); i++) {
                    if (daftar.get(i).status.equals("BELUM")) {
                        DataJoki d = daftar.get(i);
                        System.out.println((i+1) + ". " + d.jenisLayanan + ": " + d.detail);
                        System.out.println("   [User: " + d.username + " | Pass: " + d.password + " | HP: " + d.noHp + "]");
                    }
                }

                System.out.println("\n--- [ RIWAYAT SELESAI ] ---");
                for (int i = 0; i < daftar.size(); i++) {
                    if (daftar.get(i).status.equals("SELESAI")) {
                        DataJoki d = daftar.get(i);
                        System.out.println((i+1) + ". " + d.jenisLayanan + ": " + d.detail + " - DONE");
                        System.out.println("   [User: " + d.username + " | Pass: " + d.password + "]");
                    }
                }
                System.out.print("\nKetik '0' untuk kembali: ");
                input.nextLine();

            } else if (menu == 3) {
                // --- UPDATE (HANYA TAMPILKAN YANG BELUM) ---
                System.out.println("\n--- PESANAN YANG BELUM SELESAI ---");
                boolean adaBelum = false;
                for (int i = 0; i < daftar.size(); i++) {
                    if (daftar.get(i).status.equals("BELUM")) {
                        System.out.println((i + 1) + ". " + daftar.get(i).username + " (" + daftar.get(i).jenisLayanan + ")");
                        adaBelum = true;
                    }
                }

                if (!adaBelum) {
                    System.out.println("Tidak ada antrian yang perlu diproses.");
                } else {
                    System.out.print("Masukkan Nomor yang SUDAH SELESAI (0 untuk kembali): ");
                    int pilih = input.nextInt();
                    if (pilih != 0 && pilih <= daftar.size()) {
                        daftar.get(pilih - 1).status = "SELESAI";
                        System.out.println(">> Berhasil diupdate!");
                    }
                }

            } else if (menu == 4) {
                // --- HAPUS DATA ---
                System.out.println("\n--- PILIH NOMOR UNTUK DIHAPUS ---");
                for (int i = 0; i < daftar.size(); i++) {
                    System.out.println((i + 1) + ". " + daftar.get(i).username + " (" + daftar.get(i).jenisLayanan + ")");
                }
                System.out.print("Nomor (0 untuk kembali): ");
                int hapus = input.nextInt();
                if (hapus != 0 && hapus <= daftar.size()) {
                    daftar.remove(hapus - 1);
                    System.out.println(">> Berhasil dihapus!");
                }
            }

        } while (menu != 5);
        System.out.println("Program Berhenti. Sampai jumpa!");
    }
}