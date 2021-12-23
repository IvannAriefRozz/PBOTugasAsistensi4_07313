package Controller;
import Entity.SiswaEntity;
import java.util.ArrayList;
import Model.SiswaModel;

import java.sql.ResultSet;

public class SiswaController {
    private SiswaModel siswaModel = new SiswaModel();
    public ResultSet getMahasiswa(){
        return siswaModel.getSiswa();
    }
    public ArrayList<SiswaEntity> insert(String nama, String nodaftar, String noTelp){
        return AllObjectController.siswaModel.getinsert(nama,nodaftar, noTelp);
    }
    public ArrayList<SiswaEntity> update(String id, String nama, String nodaftar, String noTelp){
        return AllObjectController.siswaModel.getupdate(id,nama,nodaftar, noTelp);
    }
    public ArrayList<SiswaEntity> delete(String id){
        return AllObjectController.siswaModel.getdelete(id);
    }
}
