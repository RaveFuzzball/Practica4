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
public enum EnumMes {
    ENERO("01","ENERO"),FEBRERO("02","FEBRERO"),MARZO("03","MARZO"),ABRIL("04","ABRIL"),MAYO("05","MAYO"),JUNIO("06","JUNIO"),JULIO("07","JULIO"),AGOSTO("08","AGOSTO"),SEPTIEMBRE("09","SEPTIEMBRE"),OCTUBRE("10","OCTUBRE"),NOVIEMBRE("11","NOVIEMBRE"),DICIEMBRE("12","DICIEMBRE");
    public String valorNum,nombre;

    private EnumMes(String valorNum,String Nombre) {
        this.valorNum = valorNum;
        this.nombre = Nombre;
    }

    public String getValorNum() {
        return valorNum;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
