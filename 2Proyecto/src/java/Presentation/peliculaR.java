/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Service;
import Logic.pelicula;
import java.util.List;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ksand
 */
@Path("/peliculas")
public class peliculaR {
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public pelicula get(@PathParam("id") String titulo) {
        try {
            return Service.instance().readPelicula(titulo);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
   
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<pelicula> search(@DefaultValue("") @QueryParam("titulo") String titulo) throws Exception { 
        return Service.instance().peliculasSearch(titulo);
    } 
    
    @POST
    @Path("{agregarPelicula}")
    @Consumes(MediaType.APPLICATION_JSON) 
    public void addPelicula(pelicula p) {  
        try {
            Service.instance().crearPelicula(p);

        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
}
