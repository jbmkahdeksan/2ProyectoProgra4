/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.cinema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class cinemaDao {
    public void create(cinema o) throws Exception {
        String sql = "insert into cinema (id_cinema, nombre, direccion) "
                + "values(?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getId_cinema()));
        stm.setString(2, o.getNombre());
        stm.setString(3, o.getDireccion());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cinema ya existe");
        }
    }

    public cinema read(int id_cinema) throws Exception {
        cinema r;
        String sql = "select * from cinema where id_cinema=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(id_cinema));
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            r = from(rs);
        } else {
            throw new Exception("Cinema no Existe");
        }
        return r;
    }
    
    public List<cinema> findByDescripcion_String(String c) {
        List<cinema> r = new ArrayList<>();
        String sql = "select * from cinema where nombre like ?";
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%" + c + "%");
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
        }
        return r;
    }
    

    

 

    public cinema from(ResultSet rs) {
        try {
            
            cinema r = new cinema();
            r.setId_cinema(Integer.valueOf(rs.getString("id_cinema")));
            r.setNombre(rs.getString("nombre"));
            r.setDireccion(rs.getString("direccion"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
