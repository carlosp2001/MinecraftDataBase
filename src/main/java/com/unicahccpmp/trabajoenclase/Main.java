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
                    eliminarRegistro();
                    break;
            }
            mostrarRegistros();
            mostrarMenu();
        } 
    }
    
   
    
    
    public static void mostrarMenu(){
        System.out.println(SeparadorDeLinea);
        System.out.println("Q Salir\tR Recargar\tN Nuevo\tU Actualizar\tD "
                + "Eliminat\n Presione la opción y Enter: ");
        opcionMenu = entradaTeclado.nextLine();
    }
    
    public static void crearNuevoRegistro(){
        DataBaseEntry nuevoRegistro = new DataBaseEntry();
        System.out.println();
        System.out.println("Getting New Data");
        System.out.println(SeparadorDeLinea);
        System.out.println("MINECRAFT BLOCKNAME: ");
        String _MINECRAFTBLOCKNAME = entradaTeclado.nextLine();
        System.out.println("MINECRAFT RECEIPT: ");
        String _MINECRAFTRECEIPT = entradaTeclado.nextLine();
        boolean variablecon=true;
        while(variablecon==true){
            System.out.println("MINECRAFT ATTACK: ");
            String _MINECRAFTATTACK = entradaTeclado.nextLine();
            if(parseInt(_MINECRAFTATTACK)<=10 && parseInt(_MINECRAFTATTACK)>=0 ){
                nuevoRegistro.setMINECRAFTATTACK(parseInt(_MINECRAFTATTACK));
                variablecon=false;
            }else{
                System.out.println("\nValor Incorrecto: Debe Ingresar un valor"
                        + " mayor o igual 0 y menor o igual 10\n");
            }
        } 
        variablecon=true;
        while(variablecon==true){
            System.out.println("MINECRAFT DEFENSE: ");
            String _MINECRAFTDEFENSE = entradaTeclado.nextLine();
            if(parseInt(_MINECRAFTDEFENSE)<=10 && parseInt(_MINECRAFTDEFENSE)>=0 ){
                nuevoRegistro.setMINECRAFTDEFENSE(parseInt(_MINECRAFTDEFENSE));
                variablecon=false;
            }else{
                System.out.println("\nValor Incorrecto: Debe Ingresar un valor"
                        + " mayor o igual 0 y menor o igual 10\n");
            }
        }
        
        nuevoRegistro.setMINECRAFTBLOCKNAME(_MINECRAFTBLOCKNAME);
        nuevoRegistro.setMINECRAFTRECEIPT(_MINECRAFTRECEIPT);
        miConexion.agregarNuevoRegistro(nuevoRegistro);
        System.out.println();
        
    }
    
    public static void mostrarRegistros(){
        misRegistros = miConexion.obtenerRegistros();
        System.out.println(SeparadorDeLinea);
        System.out.println(String.format("%s\t%-15s\t%-16s\t%-15s\t%-15s\"t%-15s","#","MINECRAFTBLOCKNAME","", "MINECRAFTRECEIPT", "MINECRAFTATTACK", "MINECRAFTDEFENSE"));
        System.out.println(SeparadorDeLinea);
        for (DataBaseEntry _registro : misRegistros) { // pod cada elemento en myEntries asignelo a _entry interando
            System.out.println(_registro.obtenerTextoConFormato());
        }
        
        System.out.println(SeparadorDeLinea);
        System.out.println(String.format("Total Rows: %d",misRegistros.size()));
        
    }
    
    public static void actualizarRegistro(){      
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
    
    public static void eliminarRegistro(){
        System.out.println("Escriba el código del registro a eliminar:");
        int idRegistro = entradaTeclado.nextInt();
        //Patch por que nextInt no lee \n asi que se debe correr nextLine para evitar el no poder encontrar el registro
        entradaTeclado.nextLine();
        // Con el ID se debe extraer la data del registro;
        DataBaseEntry registroAEliminar = miConexion.obtenerUnRegistro(idRegistro);
        if (registroAEliminar.getID() > 0) {
            System.out.println(SeparadorDeLinea);
            System.out.println(registroAEliminar.obtenerTextoConFormato());
            System.out.println(SeparadorDeLinea);

            System.out.println("¿Desea Eliminar el registro? (S/N):");
            String opcion = entradaTeclado.nextLine();
            if (opcion.toUpperCase().equals("S")){
                miConexion.eliminarRegistro(registroAEliminar);
                System.out.println("Registro Eliminado. Presione Enter para continuar.");
            } else {
                System.out.println("Operación cancelada. Presione Enter para continuar.");
            }
        } else {
            System.out.println("No existe Registro !!! Presione Enter para Continuar.");
        }
        
        entradaTeclado.nextLine();
    }
}
