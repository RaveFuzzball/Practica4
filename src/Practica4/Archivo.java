/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica4;

import java.io.*;

public class Archivo {
    private String textoEntrada = "";
    public Archivo(){

        InputStream entrada = null;
        try{
            entrada = new FileInputStream("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\PraticasPrograII\\src\\Practica4\\registrosCiudadanos.txt");
            int c;
            while((c = entrada.read()) != -1){
               textoEntrada += (char)c; 
            }
        }catch(FileNotFoundException a){
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Fallo en la entrada de datos");
        }
    }
    public void salida(String sal){
        PrintWriter salida = null;
        try{
            salida = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\PraticasPrograII\\src\\Practica4\\ciudadanosOrden.txt",true)));
            salida.println(sal);
            salida.close();
        }catch(IOException a){
            System.out.println("Fallo de E/S");
        }
    }
    public String getTextoEntrada() {
        return textoEntrada;
    }
    
}
