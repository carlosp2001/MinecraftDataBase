/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.trabajoenclase;

import com.unicahccpmp.trabajoenclase.dao.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

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
     private static String opcionMenu = "R";
    private static ArrayList<DataBaseEntry> misRegistros;
    private static Conn miConexion;
    private static Scanner entradaTeclado;
    private static String SeparadorDeLinea;
    
    public static void main(String args[]) {
     miConexion = new Conn();
        miConexion.obtenerConeccion();
        entradaTeclado = new Scanner(System.in);
        SeparadorDeLinea = new String(new char[118]).replace("\0", "-");
        
        System.out.println(SeparadorDeLinea);
        System.out.println("Iniciando Proyecto");
        System.out.println(SeparadorDeLinea);
        while (!opcionMenu.equalsIgnoreCase("Q")) {
            System.out.println();
            switch (opcionMenu.toUpperCase()) {
                case "R": // refresh
                    
                    break;
                case "N": // new
                    crearNuevoRegistro();
                    break;
                case "U": // update
                    actualizarRegistro();
                    break;
                case "D": //Delete
                    
                    break;
            }
            mostrarRegistros();
            mostrarMenu();
        } 
    }
    
   
    
    
    public static void mostrarMenu(){
        System.out.println(SeparadorDeLinea);
        System.out.println("Q Salir\tR Recargar\tN Nuevo\tU Actualizar\tD Eliminat\tS Buscar\n Presione la opción y Enter: ");
        opcionMenu = entradaTeclado.nextLine();
    }
    
    public static void crearNuevoRegistro(){
        System.out.println();
        System.out.println("Getting New Data");
        System.out.println(SeparadorDeLinea);
        System.out.println("MINECRAFT BLOCKNAME: ");
        String _MINECRAFTBLOCKNAME = entradaTeclado.nextLine();
        System.out.println("MINECRAFT RECEIPT: ");
        String _MINECRAFTRECEIPT = entradaTeclado.nextLine();
        System.out.println("MINECRAFT ATTACK: ");
        String _MINECRAFTATTACK = entradaTeclado.nextLine();
        System.out.println("MINECRAFT DEFENSE: ");
        String _MINECRAFTDEFENSE = entradaTeclado.nextLine();
        
        
        DataBaseEntry nuevoRegistro = new DataBaseEntry();
        nuevoRegistro.setMINECRAFTBLOCKNAME(_MINECRAFTBLOCKNAME);
        nuevoRegistro.setMINECRAFTRECEIPT(_MINECRAFTRECEIPT);
        nuevoRegistro.setMINECRAFTATTACK(parseInt(_MINECRAFTATTACK));
        nuevoRegistro.setMINECRAFTDEFENSE(parseInt(_MINECRAFTDEFENSE));
     
        miConexion.agregarNuevoRegistro(nuevoRegistro);
        
        System.out.println();
        
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
    
    public static void actualizarRegistro(){
        //Primero Obtener el ID de un registro
        System.out.println("Escriba el código del registro a actualizar:");
        int idRegistro = entradaTeclado.nextInt();
        entradaTeclado.nextLine();
        // Con el ID se debe extraer la data del registro;
        DataBaseEntry registroAActualizar = miConexion.obtenerUnRegistro(idRegistro);
       
        
        if (registroAActualizar.getID() > 0){
        
            System.out.println(SeparadorDeLinea);
            System.out.println(registroAActualizar.obtenerTextoConFormato());
            System.out.println(SeparadorDeLinea);
            System.out.println("MINECRAFT BLOCKNAME (" + registroAActualizar.getMINECRAFTBLOCKNAME() + "):");
            String _MINECRAFTBLOCKNAME = entradaTeclado.nextLine();
            if (!_MINECRAFTBLOCKNAME.isEmpty() && !_MINECRAFTBLOCKNAME.equals(registroAActualizar.getMINECRAFTBLOCKNAME())){
                registroAActualizar.setMINECRAFTBLOCKNAME(_MINECRAFTBLOCKNAME);
            }
            System.out.println("MINECRAFT RECEIPT (" + registroAActualizar.getMINECRAFTRECEIPT()+ "):");
            String _MINECRAFTRECEIPT = entradaTeclado.nextLine();
            if (!_MINECRAFTRECEIPT.isEmpty() && !_MINECRAFTRECEIPT.equals(registroAActualizar.getMINECRAFTRECEIPT())){
                registroAActualizar.setMINECRAFTRECEIPT(_MINECRAFTRECEIPT);
            }
 
            System.out.println("MINECRAF ATTACK (" + registroAActualizar.getMINECRAFTATTACK() + "):");
            String _MINECRAFTATTACK = entradaTeclado.nextLine();
            //Integer.parseInt(_MINECRAFTATTACK);
            
            if (!_MINECRAFTATTACK.isEmpty() && !_MINECRAFTATTACK.equals(registroAActualizar.getMINECRAFTATTACK())){
                registroAActualizar.setMINECRAFTATTACK(parseInt(_MINECRAFTATTACK));
            }
 
            System.out.println("MINECRAFT DEFENSE (" + registroAActualizar.getMINECRAFTDEFENSE() + "):");
            String _MINECRAFTDEFENSE = entradaTeclado.nextLine();
            if (!_MINECRAFTDEFENSE.isEmpty() && !_MINECRAFTDEFENSE.equals(registroAActualizar.getMINECRAFTDEFENSE())){
                registroAActualizar.setMINECRAFTDEFENSE(parseInt(_MINECRAFTDEFENSE));
            }
        System.out.println(registroAActualizar.obtenerTextoConFormato());
            miConexion.actualizarRegistro(registroAActualizar);
            System.out.println("Registro Actualizado!!! Presione Enter para Continuar.");
        } else{
            System.out.println("No existe Registro !!! Presione Enter para Continuar.");
        }
    }
}
