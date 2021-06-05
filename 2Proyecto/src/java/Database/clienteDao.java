/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class clienteDao {
    public void create(cliente o) throws Exception {
        String sql = "insert into cliente (id_cliente, apellidos, nombre, telefono, tarjeta_pago) "
                + "values(?,?,?, ?, ?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getId_cliente());
        stm.setString(2, o.getApellidos());
        stm.setString(3, o.getNombre());
        stm.setString(4, o.getTelefono());
        stm.setString(5, o.getTarjeta_pago());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cliente ya existe");
        }
    }

    public cliente read(String id_cliente) throws Exception {
        cliente r;
        String sql = "select * from cliente where id_cliente=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, id_cliente);
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            r = from(rs);
        } else {
            throw new Exception("Cliente no Existe");
        }
        return r;
    }
    
 
    

    public void update(cliente o) throws Exception {
        String sql = "update cliente set apellidos=?, nombre=?, telefono=?, tarjeta_pago=? "
                + "where id_cliente=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getApellidos());
        stm.setString(2, o.getNombre());
        stm.setString(3, o.getTelefono());
        stm.setString(4, o.getTarjeta_pago());
        stm.setString(5, o.getId_cliente());
        
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cliente no existe");
        }
    }

    public void delete(cliente o) throws Exception {
        String sql = "delete from cliente where id_cliente=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getId_cliente());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cliente no existe");
        }
    }

    public List<cliente> findAll() {
        List<cliente> r = new ArrayList<>();
        String sql = "select * from cliente";
       
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm); 
             while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    
   

    public cliente from(ResultSet rs) {
        try {
            
            cliente r = new cliente();
            r.setId_cliente(rs.getString("id_cliente"));
            r.setApellidos(rs.getString("apellidos"));
            r.setNombre(rs.getString("nombre"));
            r.setTelefono(rs.getString("telefono"));
            r.setTarjeta_pago(rs.getString("tarjeta_pago"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
