public class JokiEvent extends Layanan implements ManajemenPesanan {
    public JokiEvent(String nama, int tingkat) {
        this.namaGrup = "Joki Event";
        this.dataHarga = new Harga(tingkat, 2);
        this.namaPesanan = nama;
    }

    @Override
    public void tampilDetail() {
        System.out.println("[EVENT : " + namaPesanan.toUpperCase() + "]");
        System.out.println("> Kesulitan : " + dataHarga.getKategori());
        System.out.println("> Catatan   : " + catatanTambahan);
    }

    @Override
    public void konfirmasiPesanan() {
        System.out.println(">> Pesanan Event '" + namaPesanan + "' telah diverifikasi oleh sistem.");
    }

    @Override
    public void estimasiWaktu(String deadline) {
        System.out.println(">> Target penyelesaian event: " + deadline);
    }
}