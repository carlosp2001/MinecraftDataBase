/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.trabajoenclase;

import com.unicahccpmp.trabajoenclase.dao.Conn;
import com.unicahccpmp.trabajoenclase.dao.DataBaseEntry;
import java.util.ArrayList;
import java.util.Scanner;

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
    
    
    
    }
}
