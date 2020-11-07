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

import java.io.*;
import java.util.ArrayList;

public class BetterTextFileExample {
    public static void main(String[] args){
        
        ArrayList<String> list = lineToArray("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\PraticasPrograII\\src\\Practica4\\registrosCiudadanos.txt");
        String stringg = "friend";
        for(int i = 0; i < list.size(); i++){
            switch (i%5){
                case 0:
                    list.set(i,removeSubArray("NOMBRE",list.get(i)).trim());
                    break;
                case 1:
                    list.set(i,removeSubArray("FECHA DE NACIMIENTO",list.get(i)).trim());
                    break;
                case 2:
                    if(list.get(i).contains("MASCULINO"))
                        list.set(i,"MASCULINO");
                    else
                        list.set(i,"FEMENINO");
                    break;
                case 3:
                    list.set(i,removeSubArray("LUGAR DE NACIMIENTO",list.get(i)).trim());
                    break;
            }
        }
       for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
         
    }


    public static ArrayList<String> lineToArray(String file){
        ArrayList<String> arrayList = new ArrayList<String>();
        try{
            String string = new String();
            BufferedReader input = new BufferedReader(new FileReader(file));
            while((string = input.readLine()) != null){
                arrayList.add(string);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return arrayList;
    }

    public static String removeSubArray(String subString,String string ){
        if(!string.contains(subString))
            return string;

        int lowerBound;
        int upperBound;
        int count = 0;
        int i;
        for(i = 0; i < string.length();i++){
            if(string.charAt(i) == subString.charAt(count)){
                count++;
                if(count == subString.length())
                    break;
            }
            else{
                count = 0;
            }
        }
        upperBound = i;
        lowerBound = i-count;
        String tempString = new String("");
        for(i = 0; i < string.length(); i++){
            if(i >= lowerBound && i <= upperBound)
                continue;
            tempString += string.charAt(i);
        }
        return tempString.trim();//para quitar todos los espacios blancos inecesarios
    }

    public static ArrayList<String> seperateWords(String string){
        ArrayList<String> words = new ArrayList<String>();
        String tempString = new String("");
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) != ' '){
                tempString += string.charAt(i);
            }
            else{
                words.add(tempString);
                tempString = "";
            }
        }
        words.add(tempString);
        return words;
    }

    public static String toTitleCase(String string){
        return "";
}

    public static String formatearNombre(String nombre){
        String tempString = new String("");
        ArrayList<String> words = seperateWords(nombre);
        tempString += words.get(1)+" ";
        tempString += words.get(2)+" ";
        tempString += words.get(0);
        return tempString;
    }

}
