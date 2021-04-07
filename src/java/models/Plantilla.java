/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lscar
 */

@XmlRootElement
public class Plantilla {
    private int hcod;
    private int salacod;
    private int empno;
    private String apellido;
    private String funcion;
    private String turno;
    private int salario;

    public Plantilla(){}
    
    public Plantilla(int hcod, int salacod, int empno, String apellido, String funcion, String turno, int salario) {
        this.hcod = hcod;
        this.salacod = salacod;
        this.empno = empno;
        this.apellido = apellido;
        this.funcion = funcion;
        this.turno = turno;
        this.salario = salario;
    }

    public int getHcod() {
        return hcod;
    }

    public void setHcod(int hcod) {
        this.hcod = hcod;
    }

    public int getSalacod() {
        return salacod;
    }

    public void setSalacod(int salacod) {
        this.salacod = salacod;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
