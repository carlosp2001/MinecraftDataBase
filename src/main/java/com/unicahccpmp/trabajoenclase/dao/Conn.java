/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.trabajoenclase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Conn {
    Connection c = null;
    public void obtenerConeccion(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:minecraft.db");
            String SQLCrearTabla = "CREATE TABLE IF NOT EXISTS MINECRAFT"
                    + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " MINECRAFTBLOCKNAME TEXT NOT NULL,"
                    + " MINECRATFTCRAFTRECEIPT TEXT NOT NULL,"
                    + " MINECRAFTATTACK INTEGER NULL"
                    + " MINECRAFTDEFENSE INTEGER NULL"
                    + ")";
            Statement comandoSql = c.createStatement();
            comandoSql.executeUpdate(SQLCrearTabla);
            comandoSql.close();
            
        } catch ( Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
        }
    
}
    
public ArrayList<DataBaseEntry> obtenerRegistros(){
        try{
            if (c == null) {
                obtenerConeccion();
            }
            Statement comandoSql = c.createStatement();
            ResultSet rs = comandoSql.executeQuery("SELECT * FROM MINECRAFT;");
            ArrayList<DataBaseEntry> todosMisRegistros = new ArrayList<DataBaseEntry>();
            while(rs.next()){
                DataBaseEntry registroIterando = new DataBaseEntry();
                registroIterando.setID(rs.getInt("ID"));
                registroIterando.setMINECRAFTBLOCKNAME(rs.getString("MINECRAFTBLOCKNAME"));
                registroIterando.setMINECRATFTCRAFTRECEIPT(rs.getString("MINECRATFTCRAFTRECEIPT"));
                registroIterando.setMINECRAFTATTACK(rs.getInt("MINECRAFTATTACK"));
                registroIterando.setMINECRAFTDEFENSE(rs.getInt("MINECRAFTDEFENSE"));
                
                todosMisRegistros.add(registroIterando);
                
            }
            comandoSql.close();
            return todosMisRegistros;
        } catch( Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
            return null;
        }
    }

}