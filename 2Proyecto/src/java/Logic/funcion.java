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
public class funcion {
    private int sala_cinema_id;
    private int sala_numero;
    private Date fecha;
    private String pelicula_id;

    public funcion(int sala_cinema_id, int sala_numero, Date fecha, String pelicula_id) {
        this.sala_cinema_id = sala_cinema_id;
        this.sala_numero = sala_numero;
        this.fecha = fecha;
        this.pelicula_id = pelicula_id;
    }
    
    public funcion() {
  
    }

    public int getSala_cinema_id() {
        return sala_cinema_id;
    }

    public void setSala_cinema_id(int sala_cinema_id) {
        this.sala_cinema_id = sala_cinema_id;
    }

    public int getSala_numero() {
        return sala_numero;
    }

    public void setSala_numero(int sala_numero) {
        this.sala_numero = sala_numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(String pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.sala_cinema_id;
        hash = 29 * hash + this.sala_numero;
        hash = 29 * hash + Objects.hashCode(this.fecha);
        hash = 29 * hash + Objects.hashCode(this.pelicula_id);
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
        final funcion other = (funcion) obj;
        if (this.sala_cinema_id != other.sala_cinema_id) {
            return false;
        }
        if (this.sala_numero != other.sala_numero) {
            return false;
        }
        if (!Objects.equals(this.pelicula_id, other.pelicula_id)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    
}
