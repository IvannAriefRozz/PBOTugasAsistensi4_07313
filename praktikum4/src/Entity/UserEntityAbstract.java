package Entity;

public abstract class UserEntityAbstract {
    protected String id;
    protected String nama;
    public UserEntityAbstract(){
        
    }
    
    public UserEntityAbstract(String nama){
        this.nama = nama;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
