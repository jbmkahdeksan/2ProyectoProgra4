/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.pelicula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class peliculaDao {
    public pelicula create(pelicula o) throws Exception {
        String sql = "insert into pelicula (id_pelicula, titulo, poster_path, movie_data) "
                + "values(?,?,?, ?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getId_pelicula());
        stm.setString(2, o.getTitulo());
        stm.setString(3, o.getPoster_path());
        stm.setString(4, o.getMovie_data());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Pelicula ya existe");
        }
         return o;
    }

    public pelicula read(String id_pelicula) throws Exception {
        pelicula r;
        String sql = "select * from pelicula where id_pelicula=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, id_pelicula);
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            r = from(rs);
        } else {
            throw new Exception("Pelicula no Existe");
        }
        return r;
    }
    
    public List<pelicula> findByTitulo_String(String c) {
        List<pelicula> r = new ArrayList<>();
        String sql = "select * from pelicula where titulo like ?";
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
    

    public void update(pelicula o) throws Exception {
        String sql = "update pelicula set titulo=?, poster_path=?, movie_data=? "
                + "where id_pelicula=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getTitulo());
        stm.setString(2, o.getPoster_path());
        stm.setString(3, o.getMovie_data());
        stm.setString(4, o.getId_pelicula());
        
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Pelicula no existe");
        }
    }

    public void delete(pelicula o) throws Exception {
        String sql = "delete from pelicula where id_pelicula=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getId_pelicula());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Pelicula no existe");
        }
    }

    public List<pelicula> findAll() {
        List<pelicula> r = new ArrayList<>();
        String sql = "select * from pelicula";
       
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm); 
             while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    public List<pelicula> findEnCartelera() {
        List<pelicula> r = new ArrayList<>();
        String sql = "select * from pelicula where id_pelicula in (select pelicula_id from funcion);";
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm); 
             while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }

    public List<pelicula> findByTitulo(pelicula o) {
        List<pelicula> r = new ArrayList<>();
        String sql = "select * from pelicula where titulo like ?";
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%" + o.getTitulo()+ "%");
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
        }
        return r;
    }

    public pelicula from(ResultSet rs) {
        try {
            
            pelicula r = new pelicula();
            r.setId_pelicula(rs.getString("id_pelicula"));
            r.setTitulo(rs.getString("titulo"));
            r.setPoster_path(rs.getString("poster_path"));
            r.setMovie_data(rs.getString("movie_data"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
