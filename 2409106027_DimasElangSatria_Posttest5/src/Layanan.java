public abstract class Layanan {
    protected String namaGrup;
    protected String namaPesanan;
    protected Harga dataHarga;
    protected String catatanTambahan = "-";

    public void setCatatan(String catatan) { this.catatanTambahan = catatan; }
    public String getNamaGrup() { return namaGrup; }
    public String getNamaPesanan() { return namaPesanan; }
    public Harga getDataHarga() { return dataHarga; }

    public abstract void tampilDetail();
}