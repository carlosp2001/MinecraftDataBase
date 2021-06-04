/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.trabajoenclase.dao;

import java.sql.*;
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
            c = DriverManager.getConnection("jdbc:sqlite:minecraftdb.db");
            String SQLCrearTabla = "CREATE TABLE IF NOT EXISTS MINECRAFT"
                    + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " MINECRAFTBLOCKNAME TEXT NOT NULL,"
                    + " MINECRAFTRECEIPT TEXT NOT NULL,"
                    + " MINECRAFTATTACK INTEGER NOT NULL,"
                    + " MINECRAFTDEFENSE INTEGER NOT NULL"
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
                registroIterando.setMINECRAFTRECEIPT(rs.getString("MINECRAFTRECEIPT"));
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