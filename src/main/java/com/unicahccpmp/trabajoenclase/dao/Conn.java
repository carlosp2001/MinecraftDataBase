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
                    + " MINECRAFTATTACK INTEGER,"
                    + " MINECRAFTDEFENSE INTEGER"
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

public void agregarNuevoRegistro(DataBaseEntry newEntry){
        try {
        String sentenciaSql = "INSERT INTO MINECRAFT (MINECRAFTBLOCKNAME, MINECRAFTRECEIPT, MINECRAFTATTACK, MINECRAFTDEFENSE) valueS ('%s','%s','%s','%s');";
        Statement comandoSql = c.createStatement();
        comandoSql.executeUpdate(String.format(sentenciaSql,
                newEntry.getMINECRAFTBLOCKNAME(),
                newEntry.getMINECRAFTRECEIPT(),
                newEntry.getMINECRAFTATTACK(),
                newEntry.getMINECRAFTDEFENSE()
            )
        );
        comandoSql.close();
        } catch (Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
        }
    }
    public DataBaseEntry obtenerUnRegistro( int idRegistro) {
            try{
                String setenciaSql = "SELECT * from MINECRAFT where ID=%d;";
                Statement comandoSql = c.createStatement();
                ResultSet cursorDeRegistro = comandoSql.executeQuery(
                    String.format(setenciaSql, idRegistro)
                );
                DataBaseEntry miRegistro = new DataBaseEntry();
                while ( cursorDeRegistro.next()){
                    miRegistro.setID(cursorDeRegistro.getInt("ID"));
                    miRegistro.setMINECRAFTBLOCKNAME(cursorDeRegistro.getString("MINECRAFTBLOCKNAME"));
                    miRegistro.setMINECRAFTRECEIPT(cursorDeRegistro.getString("MINECRAFTRECEIPT"));
                    miRegistro.setMINECRAFTATTACK(cursorDeRegistro.getInt("MINECRAFTATTACK"));
                    miRegistro.setMINECRAFTDEFENSE(cursorDeRegistro.getInt("MINECRAFTDEFENSE"));
                }
                return miRegistro;
            } catch (Exception e) {
                System.err.println(" Error " + e.getMessage());
                System.exit(0);
                return null;
            }
}
     public void actualizarRegistro(DataBaseEntry registroAActualizar){
        try {
            String sentencialSQL = "UPDATE MINECRAFT set MINECRAFTBLOCKNAME='%s', "
                    + "MINECRAFTRECEIPT='%s', MINECRAFTATTACK='%s', MINECRAFTDEFENSE='%d' "
                    + "where ID=%d;";
            Statement comandoSQL = c.createStatement();
            comandoSQL.executeUpdate(
                    String.format( 
                            sentencialSQL,
                            registroAActualizar.getMINECRAFTBLOCKNAME(),
                            registroAActualizar.getMINECRAFTRECEIPT(),
                            registroAActualizar.getMINECRAFTATTACK(),
                            registroAActualizar.getMINECRAFTDEFENSE(),
                            registroAActualizar.getID()
                    )
            );
            comandoSQL.close();
        } catch (Exception ex){
            System.err.println(" Error " + ex.getMessage());
            System.exit(0);
        }
    }
}