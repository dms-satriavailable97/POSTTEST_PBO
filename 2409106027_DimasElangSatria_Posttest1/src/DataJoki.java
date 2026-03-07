public class DataJoki {
    String username;
    String password;
    String noHp;
    String jenisLayanan;
    String detail;
    int harga;
    String status;

    public DataJoki(String user, String pass, String hp, String layanan, String det, int hrg) {
        this.username = user;
        this.password = pass;
        this.noHp = hp;
        this.jenisLayanan = layanan;
        this.detail = det;
        this.harga = hrg;
        this.status = "BELUM";
    }
}