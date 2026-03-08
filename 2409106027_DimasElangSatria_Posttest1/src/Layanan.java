public class Layanan {
    String namaGrup;
    String namaPesanan;
    Harga dataHarga;

    public Layanan(int tipe, String inputNama, int tingkat) {
        if (tipe == 1) this.namaGrup = "Build Char";
        else if (tipe == 2) this.namaGrup = "Joki Event";
        else this.namaGrup = "Eksplor Map";

        this.dataHarga = new Harga(tingkat, tipe);
        this.namaPesanan = inputNama + " (" + this.dataHarga.kategori + ")";
    }
}