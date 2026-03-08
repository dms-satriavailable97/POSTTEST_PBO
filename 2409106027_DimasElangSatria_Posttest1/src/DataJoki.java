public class DataJoki {
    String username, password, nomorHp;
    int status;
    Layanan infoJoki;

    public DataJoki(String user, String pass, String hp, Layanan l) {
        this.username = user;
        this.password = pass;
        this.nomorHp = hp;
        this.infoJoki = l;
        this.status = 1;
    }
}