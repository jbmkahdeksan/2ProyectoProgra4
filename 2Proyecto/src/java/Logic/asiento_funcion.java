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
public class asiento_funcion {
    private int funcion_sala_cinema_id;
    private int funcion_sala_numero;
    private Date funcion_fecha;
    private char fila;
    private int posicion;
    private int ocupado;

    public asiento_funcion(int funcion_sala_cinema_id, int funcion_sala_numero, Date funcion_fecha, char fila, int posicion, int ocupado) {
        this.funcion_sala_cinema_id = funcion_sala_cinema_id;
        this.funcion_sala_numero = funcion_sala_numero;
        this.funcion_fecha = funcion_fecha;
        this.fila = fila;
        this.posicion = posicion;
        this.ocupado = ocupado;
    }
     public asiento_funcion() {
       
    }

    public int getFuncion_sala_cinema_id() {
        return funcion_sala_cinema_id;
    }

    public void setFuncion_sala_cinema_id(int funcion_sala_cinema_id) {
        this.funcion_sala_cinema_id = funcion_sala_cinema_id;
    }

    public int getFuncion_sala_numero() {
        return funcion_sala_numero;
    }

    public void setFuncion_sala_numero(int funcion_sala_numero) {
        this.funcion_sala_numero = funcion_sala_numero;
    }

    public Date getFuncion_fecha() {
        return funcion_fecha;
    }

    public void setFuncion_fecha(Date funcion_fecha) {
        this.funcion_fecha = funcion_fecha;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.funcion_sala_cinema_id;
        hash = 37 * hash + this.funcion_sala_numero;
        hash = 37 * hash + Objects.hashCode(this.funcion_fecha);
        hash = 37 * hash + this.fila;
        hash = 37 * hash + this.posicion;
        hash = 37 * hash + this.ocupado;
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
        final asiento_funcion other = (asiento_funcion) obj;
        if (this.funcion_sala_cinema_id != other.funcion_sala_cinema_id) {
            return false;
        }
        if (this.funcion_sala_numero != other.funcion_sala_numero) {
            return false;
        }
        if (this.fila != other.fila) {
            return false;
        }
        if (this.posicion != other.posicion) {
            return false;
        }
        if (this.ocupado != other.ocupado) {
            return false;
        }
        if (!Objects.equals(this.funcion_fecha, other.funcion_fecha)) {
            return false;
        }
        return true;
    }
    
    
}
