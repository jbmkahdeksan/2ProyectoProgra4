/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class facturaDao {

    public void create(factura o) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String sql = "insert into factura (fecha, cliente_id, tarjeta_pago) "
                + "values(?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, formatter.format(o.getFecha()));
        stm.setString(2, o.getCliente_id());
        stm.setString(3, o.getTarjeta_pago());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Factura ya existe");
        }
    }

    public factura read(String cliente_id) throws Exception {
        factura r;
        String sql = "select * from factura where cliente_id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, cliente_id);
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            r = from(rs);
        } else {
            throw new Exception("Factura no Existe");
        }
        return r;
    }

    public void delete(factura o) throws Exception {
        String sql = "delete from factura where seq_factura=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getSeq_factura()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Curso no existe");
        }
    }

    public List<factura> findAll() {
        List<factura> r = new ArrayList<>();
        String sql = "select * from factura";

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

    public factura from(ResultSet rs) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            factura r = new factura();
            r.setFecha(rs.getDate("fecha"));
            r.setSeq_factura(Integer.valueOf(rs.getString("seq_factura")));
            r.setCliente_id(rs.getString("descripcion"));
            r.setTarjeta_pago(rs.getString("tarjeta_pago"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
