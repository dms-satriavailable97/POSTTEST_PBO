public class EksplorMap extends Layanan implements ManajemenPesanan {
    public EksplorMap(String nama, int tingkat) {
        this.namaGrup = "Eksplor Map";
        this.dataHarga = new Harga(tingkat, 3);
        this.namaPesanan = nama;
    }

    @Override
    public void tampilDetail() {
        System.out.println("[EKSPLORASI : " + namaPesanan.toUpperCase() + "]");
        System.out.println("> Area Fokus : " + dataHarga.getKategori());
        System.out.println("> Keterangan : " + catatanTambahan);
    }

    @Override
    public void konfirmasiPesanan() {
        System.out.println(">> Lokasi Map '" + namaPesanan + "' siap dikerjakan.");
    }

    @Override
    public void estimasiWaktu(String deadline) {
        System.out.println(">> Perkiraan eksplorasi selesai dalam: " + deadline);
    }
}