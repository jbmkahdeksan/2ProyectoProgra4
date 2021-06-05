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
public class factura {
    private int seq_factura;
    private Date fecha;
    private String cliente_id;
    private String tarjeta_pago;

    public factura(int seq_factura, Date fecha, String cliente_id, String tarjeta_pago) {
        this.seq_factura = seq_factura;
        this.fecha = fecha;
        this.cliente_id = cliente_id;
        this.tarjeta_pago = tarjeta_pago;
    }
    public factura() {
        
    }

    public int getSeq_factura() {
        return seq_factura;
    }

    public void setSeq_factura(int seq_factura) {
        this.seq_factura = seq_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getTarjeta_pago() {
        return tarjeta_pago;
    }

    public void setTarjeta_pago(String tarjeta_pago) {
        this.tarjeta_pago = tarjeta_pago;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.seq_factura;
        hash = 29 * hash + Objects.hashCode(this.fecha);
        hash = 29 * hash + Objects.hashCode(this.cliente_id);
        hash = 29 * hash + Objects.hashCode(this.tarjeta_pago);
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
        final factura other = (factura) obj;
        if (this.seq_factura != other.seq_factura) {
            return false;
        }
        if (!Objects.equals(this.cliente_id, other.cliente_id)) {
            return false;
        }
        if (!Objects.equals(this.tarjeta_pago, other.tarjeta_pago)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    
}
