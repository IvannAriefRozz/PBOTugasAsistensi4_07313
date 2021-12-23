package Entity;

public class SiswaEntity extends UserEntityAbstract{
    private String nodaftar;
    private String noTelp;
    public SiswaEntity(){};

    public String getNodaftar() {
        return nodaftar;
    }

    public void setNodaftar(String nodaftar) {
        this.nodaftar = nodaftar;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNotelp(String noTelp) {
        this.noTelp = noTelp;
    }

    
    
}
