/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.asiento_funcion;
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
public class asiento_funcionDao {
    public void create(asiento_funcion o) throws Exception {
        String sql = "insert into asiento_funcion (funcion_sala_cinema_id, funcion_sala_numero, funcion_fecha, fila, posicion, ocupado) "
                + "values(?,?,?,?,?,?)";
        
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getFuncion_sala_cinema_id()));
        stm.setString(2, Integer.toString(o.getFuncion_sala_numero()));
        stm.setDate(3, (Date) o.getFuncion_fecha());
        stm.setString(4, Integer.toString(o.getFila()));
        stm.setString(5, Integer.toString(o.getPosicion()));
        stm.setString(6, Integer.toString(o.getOcupado()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Asiento Funcion ya existe");
        }
    }

    public void update(asiento_funcion o) throws Exception {
        String sql = "update asiento_funcion set ocupado=?"
                + "where funcion_sala_cinema_id=? AND funcion_sala_numero=? AND funcion_fecha=? AND fila=? AND posicion=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getOcupado()));
        stm.setString(2, Integer.toString(o.getFuncion_sala_cinema_id()));
        stm.setString(3, Integer.toString(o.getFuncion_sala_numero()));
        stm.setDate(4, (Date) o.getFuncion_fecha());
        stm.setString(5, Integer.toString(o.getFila()));
        stm.setString(6, Integer.toString(o.getPosicion()));
        
        
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Asiento en funcion no existe");
        }
    }

    
    public List<asiento_funcion> findAll() {
        List<asiento_funcion> r = new ArrayList<>();
        String sql = "select * from asiento_funcion";
       
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm); 
             while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    

    public asiento_funcion from(ResultSet rs) {
        try {
          
            asiento_funcion r = new asiento_funcion();
            r.setFuncion_sala_cinema_id(Integer.valueOf(rs.getString("funcion_sala_cinema_id")));
            r.setFuncion_sala_numero(Integer.valueOf(rs.getString("funcion_sala_numero")));
            r.setFuncion_fecha(rs.getDate("funcion_fecha"));
            r.setFila((rs.getString("fila")).charAt(0));
            
            r.setPosicion(Integer.valueOf(rs.getString("posicion")));
            r.setOcupado(Integer.valueOf(rs.getString("ocupado")));
        
       
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
