/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Funciones;
import models.Plantilla;

/**
 *
 * @author lscar
 */
public class RepositoryPlantilla{
    
    private Connection getConnection() throws SQLException{
        DriverManager.registerDriver(new SQLServerDriver());
        String cadena = "jdbc:sqlserver://sqlserverjavapgs.database.windows.net:1433;databaseName=SQLAZURE";
        Connection cn = DriverManager.getConnection(cadena, "adminsql", "Admin123");
        return cn;
    }
    
    public List<Plantilla> getPlantilla() throws SQLException{
        Connection cn = this.getConnection();
        String sql = "select * from plantilla";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Plantilla> plantilla = new ArrayList<>();
        while(rs.next()){
            int hcod = rs.getInt("HOSPITAL_COD");
            int scod = rs.getInt("SALA_COD");
            int empno = rs.getInt("EMPLEADO_NO");
            String apellido = rs.getString("APELLIDO");
            String funcion = rs.getString("FUNCION");
            String turno = rs.getString("T");
            int salario = rs.getInt("SALARIO");
            Plantilla plan = new Plantilla(hcod, scod, empno, apellido, funcion, turno, salario);
            plantilla.add(plan);
        }
        rs.close();
        cn.close();
        return plantilla;
    }
    
    public Plantilla BuscarElementoPlantilla(int idemp) throws SQLException{
        Connection cn = this.getConnection();
        String sql = "select * from plantilla where empleado_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idemp);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            int hcod = rs.getInt("HOSPITAL_COD");
            int scod = rs.getInt("SALA_COD");
            int empno = rs.getInt("EMPLEADO_NO");
            String apellido = rs.getString("APELLIDO");
            String funcion = rs.getString("FUNCION");
            String turno = rs.getString("T");
            int salario = rs.getInt("SALARIO");
            Plantilla plan = new Plantilla(hcod, scod, empno, apellido, funcion, turno, salario);
            rs.close();
            cn.close();
            return plan;
        } else {
            rs.close();
            cn.close();
            return null;
        }
    }

    public List<Plantilla> getPlantillaFuncion(String fun) throws SQLException{
        Connection cn = this.getConnection();
        String sql = "select * from plantilla where lower(funcion)=lower(?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, fun);
        ResultSet rs = pst.executeQuery();
        ArrayList<Plantilla> plantilla = new ArrayList<>();
        while(rs.next()){
            int hcod = rs.getInt("HOSPITAL_COD");
            int scod = rs.getInt("SALA_COD");
            int empno = rs.getInt("EMPLEADO_NO");
            String apellido = rs.getString("APELLIDO");
            String funcion = rs.getString("FUNCION");
            String turno = rs.getString("T");
            int salario = rs.getInt("SALARIO");
            Plantilla plan = new Plantilla(hcod, scod, empno, apellido, funcion, turno, salario);
            plantilla.add(plan);
        }
        rs.close();
        cn.close();
        return plantilla;
    }
    
    public Funciones getFunciones() throws SQLException{
        Connection cn = this.getConnection();
        String sql = "select distinct funcion from plantilla";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        Funciones funcs = new Funciones();
        ArrayList<String> funciones = new ArrayList<>();
        while(rs.next()){
            String funcion = rs.getString("FUNCION");
            funciones.add(funcion);
        }
        funcs.setFuncion(funciones);
        rs.close();
        cn.close();
        return funcs;
    }
}
