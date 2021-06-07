/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.sala;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class salaDao {
    public void create(sala o) throws Exception {
        String sql = "insert into sala (cinema_id, numero, capacidad) "
                + "values(?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getCinema_id()));
        stm.setString(1, Integer.toString(o.getNumero()));
        stm.setString(3, Integer.toString(o.getCapacidad()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Sala ya existe");
        }
    }

    public sala read(int cinema_id, int numero) throws Exception {
        sala r;
        String sql = "select * from sala where cinema_id=? AND numero=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(cinema_id));
         stm.setString(2, Integer.toString(numero));
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            r = from(rs);
        } else {
            throw new Exception("Sala no Existe");
        }
        return r;
    }
    
   
  

    public void delete(sala o) throws Exception {
        String sql = "delete from sala where cinema_id=? and numero=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getCinema_id()));
        stm.setString(2, Integer.toString(o.getNumero()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Sala no existe");
        }
    }

    public List<sala> findAll() {
        List<sala> r = new ArrayList<>();
        String sql = "select * from sala";
       
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm); 
             while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    

    public sala from(ResultSet rs) {
        try {
           
            sala r = new sala();
            r.setCinema_id(Integer.valueOf(rs.getString("cinema_id")));
            r.setNumero(Integer.valueOf(rs.getString("numero")));
            r.setCapacidad(Integer.valueOf(rs.getString("capacidad")));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
