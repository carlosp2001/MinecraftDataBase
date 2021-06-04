/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.trabajoenclase.dao;

/**
 *
 * @author Carlos
 */
public class DataBaseEntry {
    private int _ID;
    private String _MINECRAFTBLOCKNAME;
    private String _MINECRATFTCRAFTRECEIPT;
    private int _MINECRAFTATTACK;
    private int _MINECRAFTDEFENSE;
    
    public String obtenerTextoConFormato(){
        return String.format(
                "%d\t%-40s\t%-15s\t%-15d\t%-40d",
                _ID,
                _MINECRAFTBLOCKNAME,
                _MINECRATFTCRAFTRECEIPT,
                _MINECRAFTATTACK,
                _MINECRAFTDEFENSE
        );
    }

    void setID(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMINECRAFTBLOCKNAME(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMINECRATFTCRAFTRECEIPT(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMINECRAFTATTACK(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMINECRAFTDEFENSE(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
