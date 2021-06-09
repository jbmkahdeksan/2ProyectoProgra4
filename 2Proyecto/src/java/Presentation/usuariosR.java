/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Service;
import Logic.usuario;
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
@Path("/usuarios")
public class usuariosR {

    
    @GET
    @Path("{cedula}")
    @Produces({MediaType.APPLICATION_JSON})
    public usuario get(@PathParam("cedula") String cedula) {
        try {
            return Service.instance().readuserID(cedula);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    
    @POST
    @Path("{login}")
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces({MediaType.APPLICATION_JSON})
    public usuario login (usuario u) {
        try {
            

            usuario new_user = Service.instance().readuserID(u.getId_usuario());
            new_user.clearClave();
            return new_user;
            
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @POST
    @Path("{registrarse}")
    @Consumes(MediaType.APPLICATION_JSON) 
    public void addUser(usuario p) {  
        try {
            Service.instance().crearUsuario(p);

        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
}
