public class Harga {
    int nilai;
    String kategori;

    public Harga(int pilihan, int tipeLayanan) {
        // Jika pilih Build Char (1)
        if (tipeLayanan == 1) {
            if (pilihan == 1) { this.nilai = 20000; this.kategori = "Leveling Saja"; }
            else if (pilihan == 2) { this.nilai = 45000; this.kategori = "Build Echo/Artefak"; }
            else { this.nilai = 80000; this.kategori = "Full Build (Siap Pakai)"; }
        }
        // Jika pilih Joki Event (2)
        else if (tipeLayanan == 2) {
            if (pilihan == 1) { this.nilai = 15000; this.kategori = "Mudah"; }
            else if (pilihan == 2) { this.nilai = 30000; this.kategori = "Menengah"; }
            else { this.nilai = 50000; this.kategori = "Sulit"; }
        }
        // Jika pilih Eksplor Map (3)
        else {
            if (pilihan == 1) { this.nilai = 25000; this.kategori = "Area Kecil"; }
            else if (pilihan == 2) { this.nilai = 50000; this.kategori = "Area Sedang"; }
            else { this.nilai = 100000; this.kategori = "Full Map"; }
        }
    }
}