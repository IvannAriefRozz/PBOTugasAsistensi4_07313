package Gui;


import Controller.AllObjectController;
import Gui.Komponen;

import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class GUI_siswa extends Komponen {

    DefaultTableModel sisMod;
    JScrollPane sisScr = new JScrollPane();
    JTable sisTab = new JTable();
    Object a;

    public GUI_siswa() {
        initComponent();
    }

    public void initComponent(){
        setSize(700 , 500);
        setLayout(null);
        setLocationRelativeTo(null);

        labelId.setBounds(20 , 0 , 70 , 30);
        labelId.setFont(new Font("Arial" , Font.BOLD,14));
        txtId.setEditable(false);
        txtId.setBounds(90 , 4, 150 , 20);
        add(labelId);
        add(txtId);

        
        labelNama.setBounds(20 , 30 , 70 , 30);
        labelNama.setFont(new Font("Arial" , Font.BOLD,14));
        txtNama.setBounds(90 , 34, 150 , 20);
        add(labelNama);
        add(txtNama);

        labelnodaftar.setBounds(20 , 60 , 70 , 30);
        labelnodaftar.setFont(new Font("Arial" , Font.BOLD,14));
        txtnodaftar.setBounds(90 , 64, 150 , 20);
        add(labelnodaftar);
        add(txtnodaftar);


        
        labelnoTelp.setBounds(20 , 90 , 70 , 30);
        labelnoTelp.setFont(new Font("Arial" , Font.BOLD,14));
        txtnoTelp.setBounds(90 , 94, 150 , 20);
        add(labelnoTelp);
        add(txtnoTelp);

        sisScr.setViewportView(sisTab);
        sisMod = (DefaultTableModel) sisTab.getModel();
        sisTab.setDefaultEditor(Object.class, null);
        sisMod.addColumn("Id");
        sisMod.addColumn("Nama");
        sisMod.addColumn("nodaftar");
        sisMod.addColumn("noTelp");
        
        sisScr.setBounds(380 , 30 , 300 , 400);
        add(sisScr);
        
        btnInsert.setBounds(20 , 180 , 100 , 30);
        add(btnInsert);
        
        btnUpdate.setBounds(130 , 180 , 100 , 30);
        add(btnUpdate);
        
        btnDelete.setBounds(240 , 180 , 100 , 30);
        add(btnDelete);

        //
       sisTab.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = sisTab.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				
				String id = (String) sisTab.getValueAt(pilih, 0);
				txtId.setText(id);
				String nama = (String) sisTab.getValueAt(pilih, 1);
				txtNama.setText(nama);
				String nodaftar = (String) sisTab.getValueAt(pilih, 2);
				txtnodaftar.setText(nodaftar);
				String noTelp = (String) sisTab.getValueAt(pilih, 3);
				txtnoTelp.setText(noTelp);
                        }
		});
//        Cetak data dulu

        cetakMhs();
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    successtam((MouseEvent) a);
                    AllObjectController.siswaModel.getinsert(txtNama.getText(),txtnodaftar.getText(),txtnoTelp.getText());
                    cetakMhs();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    successup((MouseEvent) a);
                    AllObjectController.siswaModel.getupdate(txtId.getText(),txtNama.getText(),txtnodaftar.getText(),txtnoTelp.getText());
                    cetakMhs();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    successhap((MouseEvent) a);
                    AllObjectController.siswaModel.getdelete(txtId.getText());
                    cetakMhs();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
    }

    public void cetakMhs(){
        sisMod.setRowCount(0);
        try{
            ResultSet result = AllObjectController.siswaModel.getSiswa();
            while (result.next()){
                Object[] obj = new Object[4];
                obj[0] = result.getString("id");
                obj[1] = result.getString("nama");
                obj[2] = result.getString("nodaftar");
                obj[3] = result.getString("noTelp");
                sisMod.addRow(obj);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
