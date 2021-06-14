/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Service;
import Logic.funcion;
import Logic.pelicula;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ksand
 */
@Path("/funciones")
public class FuncionR {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<funcion> search(@DefaultValue("") @QueryParam("titulo") String titulo) throws Exception { 
        return Service.instance().funcionSearchPelicula(titulo);
    } 
    @POST
    @Path("{agregarFuncion}")
    @Consumes(MediaType.APPLICATION_JSON) 
    public void addFuncion(funcion f) {  
        try {
            Service.instance().crearFuncion(f);

        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
}
