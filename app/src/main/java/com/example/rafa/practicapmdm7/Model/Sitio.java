package com.example.rafa.practicapmdm7.Model;

public class Sitio {

    private Long id;
    private String nombre;
    private Double latitud;
    private Double longitud;
    private String comentario;
    private Float valoracion;
    private Integer categoria;

    public Sitio() {
        this.id = null;
        this.nombre = "";
        this.latitud = null;
        this.longitud = null;
        this.comentario="";
        this.valoracion=0.0f;
        this.categoria=0;
    }

    public Sitio(String nombre, Double latitud, Double longitud, String comentario, Float valoracion, Integer categoria) {
        this.id = null;
        this.nombre = nombre;
        this.latitud=latitud;
        this.longitud=longitud;
        this.comentario=comentario;
        this.valoracion=valoracion;
        this.categoria=categoria;
    }

    public Sitio(Long id, String nombre, Double latitud, Double longitud, String comentario, Float valoracion, Integer categoria) {
        this.id = id;
        this.nombre = nombre;
        this.latitud=latitud;
        this.longitud=longitud;
        this.comentario=comentario;
        this.valoracion=valoracion;
        this.categoria=categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getLatitud() {
        return latitud;
    }
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return longitud;
    }
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentarios(String comentario) {
        this.comentario = comentario;
    }
    public Float getValoracion() {
        return valoracion;
    }
    public void setValoracion(Float valoracion) {
        this.valoracion = valoracion;
    }
    public Integer getCategoria() {
        return categoria;
    }
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Producto {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", comentario=" + comentario +
                ", valoracion=" + valoracion +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
