package Model;
import Entity.SiswaEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class SiswaModel {
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    
     public ResultSet getSiswa() {
        Statement stmt = null;
        ResultSet rs = null;
        sql = "SELECT * FROM siswa";
        try {
            stmt = conn.createStatement();
            if (stmt.execute(sql)) {
                rs = stmt.getResultSet();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    
    
    
    public ArrayList<SiswaEntity> getinsert(String nama, String nodaftar, String noTelp) {
         ArrayList<SiswaEntity> arraylistSiswa = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            // query simpan
            String sql = "INSERT INTO siswa (nama, nodaftar, noTelp) VALUE('%s', '%s', '%s')";
            sql = String.format(sql, nama, nodaftar, noTelp);

            // simpan buku
            stat.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arraylistSiswa;
     }
    
    
    
     public ArrayList<SiswaEntity> getupdate( String id, String nama, String nodaftar, String noTelp) {
         ArrayList<SiswaEntity> arraylistSiswa = new ArrayList<>();
    
    try {
            Statement stat = conn.createStatement();
            // query update
            String sql = "UPDATE siswa SET nama='%s', nodaftar='%s', noTelp='%s' WHERE id=%s";
            sql = String.format(sql, nama, nodaftar, noTelp, id);

            // update data buku
            stat.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return arraylistSiswa;
     }

     
     
      public ArrayList<SiswaEntity> getdelete(String id) {
         ArrayList<SiswaEntity> arraylistSiswa = new ArrayList<>();
    
     try {
           Statement stat = conn.createStatement();
            // buat query hapus
            String sql = String.format("DELETE FROM siswa WHERE id=%s", id);

            // hapus data
            stat.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
     return arraylistSiswa;
      }
    
}
