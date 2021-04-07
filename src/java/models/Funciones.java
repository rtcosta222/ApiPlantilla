/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lscar
 */

@XmlRootElement
public class Funciones {
    private ArrayList<String> funcion;
    
    public Funciones(){}
    
    public Funciones(ArrayList<String> funcion){
        this.funcion = funcion;
    }

    public ArrayList<String> getFuncion() {
        return funcion;
    }

    public void setFuncion(ArrayList<String> funcion) {
        this.funcion = funcion;
    }

}
