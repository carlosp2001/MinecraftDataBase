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
    
    
    public int getID() {
        return _ID;
    }
    
    public void setID(int _ID) {
        this._ID = _ID;
    }
    
    public String getMINECRAFTBLOCKNAME() {
        return _MINECRAFTBLOCKNAME;
    }
    
     public void setMINECRAFTBLOCKNAME(String _MINECRAFTBLOCKNAME) {
        this._MINECRAFTBLOCKNAME= _MINECRAFTBLOCKNAME;
    }
    
    public String getMINECRAFTRECEIPT() {
        return _MINECRAFTRECEIPT;
    }
    
    public void setMINECRAFTRECEIPT(String _MINECRAFTRECEIPT) {
        this._MINECRAFTRECEIPT= _MINECRAFTRECEIPT;
    }
    
    public int getMINECRAFTATTACK() {
        return _MINECRAFTATTACK;
    }
    
    public void setMINECRAFTATTACK(int _MINECRAFTATTACK) {
        this._MINECRAFTATTACK = _MINECRAFTATTACK;
    }

    public int getMINECRAFTDEFENSE() {
        return _MINECRAFTDEFENSE;
    }
    
    public void setMINECRAFTDEFENSE(int _MINECRAFTDEFENSE) {
        this._MINECRAFTDEFENSE = _MINECRAFTDEFENSE;
    }
    
    private int _ID;
    private String _MINECRAFTBLOCKNAME;
    private String _MINECRAFTRECEIPT;
    private int _MINECRAFTATTACK;
    private int _MINECRAFTDEFENSE;
    
    public String obtenerTextoConFormato(){
        return String.format(
                "%d\t%-40s\t%-30s\t%-15d\t%-40d",
                _ID,
                _MINECRAFTBLOCKNAME,
                _MINECRAFTRECEIPT,
                _MINECRAFTATTACK,
                _MINECRAFTDEFENSE
        );
    }

    
}
