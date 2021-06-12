/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Service;
import Logic.sala;
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
@Path("/salas")
public class SalaR {
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public sala get(@PathParam("cinema_id") int cinema_id,@PathParam("id") int id) {
        try {
            return Service.instance().readbyidS(cinema_id, id);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void addSala(sala s) {  
        try {
            Service.instance().crearSala(s);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
}
