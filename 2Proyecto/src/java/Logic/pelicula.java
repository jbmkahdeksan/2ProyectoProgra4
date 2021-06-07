/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Objects;

/**
 *
 * @author ksand
 */
public class pelicula {
    private String id_pelicula;
    private String titulo;
    private String poster_path;
    private String movie_data;

    public pelicula(String id_pelicula, String titulo, String poster_path, String movie_data) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.poster_path = poster_path;
        this.movie_data = movie_data;
    }
    
    public pelicula() {
        
    }

    public String getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(String id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getMovie_data() {
        return movie_data;
    }

    public void setMovie_data(String movie_data) {
        this.movie_data = movie_data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id_pelicula);
        hash = 47 * hash + Objects.hashCode(this.titulo);
        hash = 47 * hash + Objects.hashCode(this.poster_path);
        hash = 47 * hash + Objects.hashCode(this.movie_data);
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
        final pelicula other = (pelicula) obj;
        if (!Objects.equals(this.id_pelicula, other.id_pelicula)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.poster_path, other.poster_path)) {
            return false;
        }
        if (!Objects.equals(this.movie_data, other.movie_data)) {
            return false;
        }
        return true;
    }
    
    
}
