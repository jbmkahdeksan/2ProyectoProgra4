/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.tiquete;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class tiqueteDao {
    public tiquete create(tiquete o) throws Exception {
        String sql = "insert into tiquete (id_tiquete, factura_seq, asiento_funcion_sala_cinema_id, funcion_sala_numero, asiento_funcion_fecha, asiento_funcion_fila, asiento_funcion_posicion, monto) "
                + "values(?,?,?,?,?,?,?,?)";
        
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getId_tiquete()));
        stm.setString(2, Integer.toString(o.getFactura_seq()));
        stm.setString(3, Integer.toString(o.getAsiento_funcion_sala_cinema_id()));
         stm.setString(4, Integer.toString(o.getFuncion_sala_numero()));
          stm.setDate(5, (Date) o.getAsiento_funcion_fecha());
           stm.setString(6, Integer.toString(o.getAsiento_funcion_fila()));
            stm.setString(7, Integer.toString(o.getAsiento_funcion_posicion()));
             stm.setString(8, Double.toString(o.getMonto()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Tiquete ya existe");
        }
        return o;
    }

    public tiquete read(int id_tiquete) throws Exception {
        tiquete r;
        String sql = "select * from tiquete where id_tiquete=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(id_tiquete));
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            r = from(rs);
        } else {
            throw new Exception("Tiquete no Existe");
        }
        return r;
    }
    
    
    


    public void delete(tiquete o) throws Exception {
        String sql = "delete from tiquete where id_tiquete=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getId_tiquete()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Curso no existe");
        }
    }

    public List<tiquete> findAll() {
        List<tiquete> r = new ArrayList<>();
        String sql = "select * from tiquete";
       
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm); 
             while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
   

    public tiquete from(ResultSet rs) {
        try {
            
            tiquete r = new tiquete();
            r.setId_tiquete(Integer.valueOf(rs.getString("id_tiquete")));
            r.setFactura_seq(Integer.valueOf(rs.getString("factura_seq")));
            r.setAsiento_funcion_sala_cinema_id(Integer.valueOf(rs.getString("asiento_funcion_sala_cinema_id")));
            r.setFuncion_sala_numero(Integer.valueOf(rs.getString("funcion_sala_numero")));
            r.setAsiento_funcion_fecha(rs.getDate("funcion_fecha"));
            r.setAsiento_funcion_fila((rs.getString("asiento_funcion_fila").charAt(0)));
            r.setAsiento_funcion_posicion(Integer.valueOf(rs.getString("asiento_funcion_posicion")));
            r.setMonto(Double.valueOf(rs.getString("monto")));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
