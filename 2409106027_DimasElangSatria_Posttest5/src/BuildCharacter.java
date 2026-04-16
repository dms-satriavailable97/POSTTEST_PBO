public class BuildCharacter extends Layanan implements ManajemenPesanan {

    public BuildCharacter(String nama, int tingkat) {
        this.namaGrup = "Build Char";
        this.dataHarga = new Harga(tingkat, 1);
        this.namaPesanan = nama;
    }

    public BuildCharacter(String nama, int hargaPromo, String namaPromo) {
        this.namaGrup = "Build Char";
        this.dataHarga = new Harga(hargaPromo, namaPromo);
        this.namaPesanan = nama;
    }

    @Override
    public void tampilDetail() {
        System.out.println("[FOCUS BUILD: " + namaPesanan.toUpperCase() + "]");
        System.out.println("> Kategori/Promo: " + dataHarga.getKategori());
        System.out.println("> Harga: Rp" + dataHarga.getNilai());
        System.out.println("> Catatan Tambahan: "+ catatanTambahan) ;
    }

    // Implementasi method dari Interface ManajemenPesanan
    @Override
    public void konfirmasiPesanan() {
        System.out.println(">> Pesanan Build Character '" + namaPesanan + "' telah masuk antrian.");
    }

    @Override
    public void estimasiWaktu(String deadline) {
        System.out.println(">> Estimasi pengerjaan build: " + deadline);
    }
}