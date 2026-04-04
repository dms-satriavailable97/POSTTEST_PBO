public class BuildCharacter extends Layanan {
    public BuildCharacter(String nama, int tingkat) {
        this.namaGrup = "Build Char";
        this.dataHarga = new Harga(tingkat, 1);
        this.namaPesanan = nama + " (" + dataHarga.getKategori() + ")";
    }
}