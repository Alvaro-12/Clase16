/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Nota;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *SP_I_Notas
 * @author Alvaro
 */
public class NotasMaterias {
    
    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();
    
     public void AddNota(Nota nt){
    try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_Notas(?,?,?)}");
            cb.setString("PNotas", nt.getNota());
            cb.setString("PIdMateria", nt.getApellido());
            cb.setString("PIdEstudiante", nt.getNombre());
         
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Persona agregada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(),"Mensje sistems",1);
            
        }}
}
