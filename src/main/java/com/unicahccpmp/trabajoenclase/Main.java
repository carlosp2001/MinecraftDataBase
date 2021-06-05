/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.trabajoenclase;

import com.unicahccpmp.trabajoenclase.dao.*;
import java.util.ArrayList;

/** Grupo #4
 * Suany Nohemy Garcia Argueta
 * Angel Fernando Hernández Alvarado
 * Carlos ALberto Pineda
 * Joel Enrique Flores Santos
 * José Eduardo Reyes Suazo
 */


/**
 *
 * @author Carlos
 */
public class Main {
    private static ArrayList<DataBaseEntry> misRegistros;
    private static Conn miConexion;
    private static String SeparadorDeLinea;
    
    public static void main(String args[]) {
    miConexion = new Conn();
    miConexion.obtenerConeccion();
    SeparadorDeLinea = new String(new char[118]).replace("\0", "-");
    mostrarRegistros();
    
    
    }
    
     public static void mostrarRegistros(){
        misRegistros = miConexion.obtenerRegistros();
        
        System.out.println(SeparadorDeLinea);
        System.out.println(String.format("%s\t%-15s\t%-16s\t%-15s\t%-15s\t%-15s", "#","MINECRAFTBLOCKNAME","", "MINECRAFTRECEIPT", "MINECRAFTATTACK", "MINECRAFTDEFENSE"));
        System.out.println(SeparadorDeLinea);
        // foreach item in arraylist
        for (DataBaseEntry _registro : misRegistros) { // pod cada elemento en myEntries asignelo a _entry interando
            System.out.println(_registro.obtenerTextoConFormato());
        }
        /*
        for (int i = 0; i < myEntries.size(); i++){
            System.out.println(myEntries.get(i).getFormattedText());
        }
        */
        System.out.println(SeparadorDeLinea);
        System.out.println(String.format("Total Rows: %d",misRegistros.size()));
        
    }
}
