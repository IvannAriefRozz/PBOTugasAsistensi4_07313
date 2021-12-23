package Gui;

import javax.swing.*;

public class Komponen extends JFrame {

    //Jlabel

    protected JLabel labelId = new JLabel("Id : ");
    protected JLabel labelnodaftar = new JLabel("ID Card : ");
    protected JLabel labelnoTelp = new JLabel("no Telp : ");
    protected JLabel labelNama = new JLabel("Nama : ");

    //JtextFIeld
    protected JTextField txtnoTelp = new JTextField();
    protected JTextField txtnodaftar = new JTextField();
    protected JTextField txtNama = new JTextField();
    protected JTextField txtId = new JTextField();

    //Jbutton
    protected JButton btnInsert = new JButton("Insert");
    protected JButton btnUpdate = new JButton("Update");
    protected JButton btnDelete = new JButton("Delete");

    public void successtam(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Sukses Tambah Data !!");
    }
    public void successup(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Sukses Update Data !!");
    }
    public void successhap(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Sukses Hapus Data !!");
    }
    public void failed(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Gagal Tambah Data !!");
    }
    public void error(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Error !!");
    }
}
