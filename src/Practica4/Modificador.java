package Practica4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Modificador {
    private final String[] [] personas;
    private int numeroPersonas;
    public Modificador(String archivo,Archivo a){
        this.personas = new String[20][10];
        int i,j;
        int salto = 0;
        
        for(i=0;i<this.personas.length;i++){
            for(j=0;j<personas[i].length;j++){
                this.personas[i][j] = "";
            }
        }
        
        i=0;//Divide a el archivo.txt en la informacion de cada persona y lo guarda en un String[]
        for(char palabra:archivo.toCharArray()){
            this.personas[i][0] += palabra;
            if(palabra == '\n'){
                salto++;
            }
            if(salto == 5){
                salto = 0;
                this.numeroPersonas++;
                i++;
            }    
        }
        
        this.extraerDatos();
        
        this.ordenamiento(a);
        
        for(i = 0;i<this.numeroPersonas+1;i++){
           a.salida(this.personas[i][1]+","+this.formatearFecha(this.personas[i][2])+","+this.personas[i][3]);

        }
    }
    private void extraerDatos(){
        int i,j;
        String regex;
        Matcher m1,m2;
        Pattern patron;
        
        //Reaordenar y extrae el nombre en formato ApellidoP ApellidoM Nombre
        String aux = "";
        for(i=0;i<this.numeroPersonas+1;i++){
            this.personas[i][1] = this.personas[i][0].substring(this.personas[i][0].indexOf(" ")+1, this.personas[i][0].indexOf("\n"));
        }    
        for(i=0;i<this.numeroPersonas+1;i++){
            aux = this.personas[i][0].substring(this.personas[i][0].indexOf(" ")+1, this.personas[i][0].indexOf("\n")-1);
            this.personas[i][1] = aux.substring(aux.indexOf(" ")+1)+ " ";
            this.personas[i][1] += aux.substring(0,aux.indexOf(" "));
        }
        
        
        //Extrae la fecha de nacimiento
        regex = "\\d{1,2}\\s\\w{4,10}\\s\\d{4}";//Expresion regular para la fecha
        patron = Pattern.compile(regex);
        for(i=0;i<this.numeroPersonas+1;i++){
            m1 = patron.matcher(this.personas[i][0]);
            m1.find();
            this.personas[i][2] = m1.group();
        }
        
        
        //Extrae el sexo 
        patron = Pattern.compile("\\w{5,6}(INO)"); //Expresion regular para MASCULINO o FEMENINO
        for(i=0;i<this.numeroPersonas+1;i++){
            m2 = patron.matcher(this.personas[i][0]);
            m2.find();
            this.personas[i][3] = m2.group();
        }

    }
    //Cambia el formato de la fecha a dd/mm/aaaa
    private String formatearFecha(String fecha){
        String fechaFormateada = "";
        Pattern p1 = Pattern.compile("(ENERO|FEBRERO|MARZO|ABRIL|MAYO|JUNIO|JULIO|AGOSTO|SEPTIEMBRE|OCTUBRE|NOVIEMBRE|DICIEMBRE)");
        Matcher m1 = p1.matcher(fecha);
        m1.find();
        String mes = m1.group();
        fechaFormateada = fecha.replace(EnumMes.valueOf(mes).getNombre(), EnumMes.valueOf(mes).getValorNum());
        fechaFormateada = fechaFormateada.replace(' ','/');
        return fechaFormateada;
    }
    //Ordena los datos por orden alfabetico tomando referencia del apellido paterno
    private void ordenamiento(Archivo a){
        int i,j;
        
        //Ordenamiento por orden alfabetico
        String[] temp;
        for(i=1;i < this.numeroPersonas+1;i++){
            for (j=0 ; j <this.numeroPersonas; j++){
                if (this.personas[j][1].compareTo(this.personas[j+1][1]) > 1){
                    temp = this.personas[j];
                    this.personas[j] = this.personas[j+1];
                    this.personas[j+1] = temp;
                }
            }
        }
    }
}
