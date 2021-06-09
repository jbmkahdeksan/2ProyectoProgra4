/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.funcion;
import Logic.pelicula;
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
public class funcionDao {
    public funcion create(funcion o) throws Exception {
        String sql = "insert into funcion (sala_cinema_id, sala_numero, fecha, pelicula_id) "
                + "values(?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getSala_cinema_id()));
        stm.setString(2, Integer.toString(o.getSala_numero()));
        stm.setDate(3, (Date) o.getFecha());
        stm.setString(4, o.getPelicula_id());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Funcion ya existe");
        }
        return o;
    }

    public funcion read(int sala_cinema_id, int sala_numero, Date fecha) throws Exception{
       funcion r;
        String sql="select * from funcion where sala_cinema_id=? AND sala_numero=? AND fecha=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(sala_cinema_id));
        stm.setString(2, Integer.toString(sala_numero));
        stm.setDate(3, fecha);
        ResultSet rs =  Database.instance().executeQuery(stm); 
        if (rs.next()) {
            r = from(rs);
        }
        else{
            throw new Exception ("Funcion no Existe");
        }
        return r;
    }
        
    public void delete(funcion o) throws Exception {
        String sql = "delete from funcion where sala_cinema_id=? AND sala_numero=? AND fecha=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getSala_cinema_id()));
        stm.setString(2, Integer.toString(o.getSala_numero()));
        stm.setDate(3, (Date) o.getFecha());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Funcion no existe");
        }
    }

    public List<funcion> findAll() {
        List<funcion> r = new ArrayList<>();
        String sql = "select * from funcion";
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
        }
        return r;
    }

    public List<funcion> findByPelicula(pelicula o){
        List<funcion> r= new ArrayList<>();
        String sql="select * from funcion f inner join pelicula p on f.pelicula_id=p.id_pelicula where f.pelicula_id=?";
        sql = String.format(sql,o.getId_pelicula());
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
             stm.setString(1,o.getId_pelicula());       
            ResultSet rs =  Database.instance().executeQuery(stm);         
            while (rs.next()) { r.add(from(rs)); } 
        } catch (SQLException ex) { }
            return r;
    }
    
    

    public funcion from(ResultSet rs) {
        try {
            funcion r = new funcion();
            r.setSala_cinema_id(Integer.valueOf(rs.getString("sala_cinema_id")));
            r.setSala_numero(Integer.valueOf(rs.getString("sala_numero")));
            r.setFecha(rs.getDate("fecha"));
            r.setPelicula_id(rs.getString("pelicula_id"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    

    public void close() {
    }
}
