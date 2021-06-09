/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Database.asiento_funcionDao;
import Database.cinemaDao;
import Database.clienteDao;
import Database.facturaDao;
import Database.funcionDao;
import Database.peliculaDao;
import Database.salaDao;
import Database.tiqueteDao;
import Database.usuarioDao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ksand
 */
public class Service {
    private peliculaDao peliculasDAO;
    private usuarioDao usuariosDAO;
    private salaDao salasDAO;
    private funcionDao funcionesDAO;
    private tiqueteDao tiquetesDAO;
    private asiento_funcionDao asientos_funcionDAO;
    private cinemaDao cinemaDAO;
    private facturaDao facturasDAO;
    private clienteDao clientesDAO;
    private static Service theInstance;
    
    
    public static Service instance() {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    public Service() {
        this.peliculasDAO = new peliculaDao();
        this.usuariosDAO = new usuarioDao();
        this.salasDAO = new salaDao();
        this.funcionesDAO = new funcionDao();
        this.tiquetesDAO = new tiqueteDao();
        this.asientos_funcionDAO = new asiento_funcionDao();
        this.cinemaDAO = new cinemaDao();
        this.facturasDAO = new facturaDao();
        this.clientesDAO = new clienteDao();
    }
    
    
    /*usuarios*/
    
    public usuario crearUsuario(usuario u){
        usuario result = null;
        
        try {
            result = usuariosDAO.create(u);
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
            return result;
    }
    
    public usuario login(usuario u){
        usuario result = null;

        try {
            result = usuariosDAO.read(u.getId_usuario());
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        if (result == null ||
                (!result.getClave().equals(u.getClave())))
        {
            return null;
        }
        return result;
        
    }
    
    
    
    public usuario readuserID(String id) throws Exception{
        return usuariosDAO.read(id);
    }
     
    /*Peliculas*/
     public pelicula readPelicula(String id) throws Exception{
        return peliculasDAO.read(id);
    }
     
    public pelicula crearPelicula(pelicula p){
        pelicula result = null;
        
        try {
            result = peliculasDAO.create(p);
            
            
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return result;
        
    }
    public List<pelicula> TodasPeliculas() {
        try {
            return peliculasDAO.findAll();
        } catch (Exception e) {
            return null;
        }
       }
    public List<pelicula> CarteleraPeliculas() {
        try {
            return peliculasDAO.findEnCartelera();
        } catch (Exception e) {
            return null;
        }
       }
    
    /*Salas*/
    public sala readbyidS(int cinemaid, int id) throws Exception{
        return salasDAO.read(cinemaid, id);
    }
    
    public sala crearSala(sala s){
        sala result = null;
        
        try {
            result = salasDAO.create(s);
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }
        return result;
    }
    
    /*Funcion*/

    public funcion crearFuncion(funcion s){
        funcion result = null;
        
        try {
            result = funcionesDAO.create(s);
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }
        return result;
    }
    
    public tiquete crearTiquetes(tiquete s){
        tiquete result = null;
        
        try {
            result = tiquetesDAO.create(s);
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }
        return result;
    }
      
    
    public List<funcion> funcionPelicula(pelicula proyeccion_id) {
        try {
            return this.funcionesDAO.findByPelicula(proyeccion_id);
        } catch (Exception e) {
            return null;
        }
        }
   
    
      public List<pelicula> peliculasSearch(String nombre) throws Exception {
        List<pelicula> result = new ArrayList<>();
        List<pelicula> uList= peliculasDAO.findAll();
        try {
           for(pelicula u:uList){
               if(u.getTitulo().contains(nombre))
                   result.add(u);
              
           } 
            return result;
        } catch (Exception e) {
            return null;
        }
        }
       
       
      public List<funcion> funcionSearchPelicula(String id_pelicula) throws Exception {
        List<funcion> result = new ArrayList<>();
        List<funcion> uList= funcionesDAO.findAll();
        try {
            if(id_pelicula==""){
                return uList;
            }
           for(funcion u:uList){
               if(u.getPelicula_id()==id_pelicula)
                   result.add(u);
              
           } 
            return result;
        } catch (Exception e) {
            return null;
        }
        }
      
         
          
           
    
}
