/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ksand
 */
public class usuarioDao {
    public usuario create(usuario cl) throws SQLException, Exception{
        String sqlcommand =  "insert into usuario(id_usuario, cliente_id, clave, rol)"
                + "values(?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);       
        stm.setString(1,cl.getId_usuario());
        stm.setString(2,cl.getCliente_id());
        stm.setString(3,cl.getClave());
        stm.setString(4,Integer.toString(cl.getRol()));
     
        System.out.println(stm);
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Ya existe un usuario con esa información");
        }
        return cl;
        
    }
    
    public usuario read(String id) throws Exception{        
        String sqlcommand = "select * from usuario where id_usuario = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);
        stm.setString(1, id);
        ResultSet rs =  Database.instance().executeQuery(stm);   
        System.out.println(stm);
        System.out.println(rs);
        if (rs.next()) {
            System.out.println("Hace read del usuario");
            return from(rs);
        }
        else{
            throw new Exception ("No se encontró el usuario");
        }
    }
    
    
    public usuario from (ResultSet rs){
        try {
            usuario u = new usuario();
            u.setId_usuario(rs.getString("id_usuario"));
            u.setCliente_id(rs.getString("cliente_id"));            
            u.setClave(rs.getString("clave"));
            u.setRol(rs.getInt("rol"));
            
            System.out.println("Usuario registrado");
            return u;
        } catch (SQLException ex) {
            return null;
        }
    }
}
