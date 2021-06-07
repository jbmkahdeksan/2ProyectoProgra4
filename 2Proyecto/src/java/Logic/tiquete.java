/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ksand
 */
public class tiquete {
    private int id_tiquete;
    private int factura_seq;
    private int asiento_funcion_sala_cinema_id;
    private int funcion_sala_numero;
    private Date asiento_funcion_fecha;
    private char asiento_funcion_fila;
    private int asiento_funcion_posicion;
    private double monto;

    public tiquete(int id_tiquete, int factura_seq, int asiento_funcion_sala_cinema_id, int funcion_sala_numero, Date asiento_funcion_fecha, char asiento_funcion_fila, int asiento_funcion_posicion, double monto) {
        this.id_tiquete = id_tiquete;
        this.factura_seq = factura_seq;
        this.asiento_funcion_sala_cinema_id = asiento_funcion_sala_cinema_id;
        this.funcion_sala_numero = funcion_sala_numero;
        this.asiento_funcion_fecha = asiento_funcion_fecha;
        this.asiento_funcion_fila = asiento_funcion_fila;
        this.asiento_funcion_posicion = asiento_funcion_posicion;
        this.monto = monto;
    }
    public tiquete() {
        
    }

    public int getId_tiquete() {
        return id_tiquete;
    }

    public void setId_tiquete(int id_tiquete) {
        this.id_tiquete = id_tiquete;
    }

    public int getFactura_seq() {
        return factura_seq;
    }

    public void setFactura_seq(int factura_seq) {
        this.factura_seq = factura_seq;
    }

    public int getAsiento_funcion_sala_cinema_id() {
        return asiento_funcion_sala_cinema_id;
    }

    public void setAsiento_funcion_sala_cinema_id(int asiento_funcion_sala_cinema_id) {
        this.asiento_funcion_sala_cinema_id = asiento_funcion_sala_cinema_id;
    }

    public int getFuncion_sala_numero() {
        return funcion_sala_numero;
    }

    public void setFuncion_sala_numero(int funcion_sala_numero) {
        this.funcion_sala_numero = funcion_sala_numero;
    }

    public Date getAsiento_funcion_fecha() {
        return asiento_funcion_fecha;
    }

    public void setAsiento_funcion_fecha(Date asiento_funcion_fecha) {
        this.asiento_funcion_fecha = asiento_funcion_fecha;
    }

    public char getAsiento_funcion_fila() {
        return asiento_funcion_fila;
    }

    public void setAsiento_funcion_fila(char asiento_funcion_fila) {
        this.asiento_funcion_fila = asiento_funcion_fila;
    }

    public int getAsiento_funcion_posicion() {
        return asiento_funcion_posicion;
    }

    public void setAsiento_funcion_posicion(int asiento_funcion_posicion) {
        this.asiento_funcion_posicion = asiento_funcion_posicion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id_tiquete;
        hash = 19 * hash + this.factura_seq;
        hash = 19 * hash + this.asiento_funcion_sala_cinema_id;
        hash = 19 * hash + this.funcion_sala_numero;
        hash = 19 * hash + Objects.hashCode(this.asiento_funcion_fecha);
        hash = 19 * hash + this.asiento_funcion_fila;
        hash = 19 * hash + this.asiento_funcion_posicion;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.monto) ^ (Double.doubleToLongBits(this.monto) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final tiquete other = (tiquete) obj;
        if (this.id_tiquete != other.id_tiquete) {
            return false;
        }
        if (this.factura_seq != other.factura_seq) {
            return false;
        }
        if (this.asiento_funcion_sala_cinema_id != other.asiento_funcion_sala_cinema_id) {
            return false;
        }
        if (this.funcion_sala_numero != other.funcion_sala_numero) {
            return false;
        }
        if (this.asiento_funcion_fila != other.asiento_funcion_fila) {
            return false;
        }
        if (this.asiento_funcion_posicion != other.asiento_funcion_posicion) {
            return false;
        }
        if (Double.doubleToLongBits(this.monto) != Double.doubleToLongBits(other.monto)) {
            return false;
        }
        if (!Objects.equals(this.asiento_funcion_fecha, other.asiento_funcion_fecha)) {
            return false;
        }
        return true;
    }
    
    
}
