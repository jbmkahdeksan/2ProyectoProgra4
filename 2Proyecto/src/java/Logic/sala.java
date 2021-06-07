/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author ksand
 */
public class sala {
    private int cinema_id;
    private int numero;
    private int capacidad;

    public sala(int cinema_id, int numero, int capacidad) {
        this.cinema_id = cinema_id;
        this.numero = numero;
        this.capacidad = capacidad;
    }
public sala() {
        
    }
    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.cinema_id;
        hash = 71 * hash + this.numero;
        hash = 71 * hash + this.capacidad;
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
        final sala other = (sala) obj;
        if (this.cinema_id != other.cinema_id) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.capacidad != other.capacidad) {
            return false;
        }
        return true;
    }
    
    
}
