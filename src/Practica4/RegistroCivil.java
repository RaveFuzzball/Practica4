/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica4;

/**
 *
 * @author Usuario
 */
public class RegistroCivil {
    public static void main(String[] args) {
        Archivo archEntrada = new Archivo();
        Modificador c = new Modificador(archEntrada.getTextoEntrada(),archEntrada);
    }
}
