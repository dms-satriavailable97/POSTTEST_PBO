public class EksplorMap extends Layanan {
    public EksplorMap(String nama, int tingkat) {
        this.namaGrup = "Eksplor Map";
        this.dataHarga = new Harga(tingkat, 3);
        this.namaPesanan = nama + " (" + dataHarga.getKategori() + ")";
    }
}