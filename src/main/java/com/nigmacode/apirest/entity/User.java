package com.nigmacode.apirest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="caso_uso")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cod_caso_uso")
    private int cod_caso_uso;

    @Column(name="nombre_caso_uso")
    private String nombre_caso_uso;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha_creacion_caso_uso", updatable = false)
    @CreationTimestamp
    private Date fecha_creacion_caso_uso;

    @Column(name="fecha_modificacion")
    @UpdateTimestamp
    private Date fecha_modificacion;

    @Column(name="cod_proyecto")
    private int cod_proyecto;

    @Column(name="cod_usuario")
    private int cod_usuario;

    public User(){}

    public User(int id, String nombre_caso_uso, String descripcion, int cod_proyecto, int cod_usuario) {
        this.cod_caso_uso = cod_caso_uso;
        this.nombre_caso_uso = nombre_caso_uso;
        this.descripcion = descripcion;
        this.cod_proyecto = cod_proyecto;
        this.cod_usuario = cod_usuario;
    }

    public int getCod_caso_uso() {
        return cod_caso_uso;
    }

    public void setCod_caso_uso(int cod_caso_uso) {
        this.cod_caso_uso = cod_caso_uso;
    }

    public String getNombre_caso_uso() {
        return nombre_caso_uso;
    }

    public void setNombre_caso_uso(String nombre_caso_uso) {
        this.nombre_caso_uso = nombre_caso_uso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_creacion_caso_uso() {
        return fecha_creacion_caso_uso;
    }

    public void setFecha_creacion_caso_uso(Date fecha_creacion_caso_uso) {
        this.fecha_creacion_caso_uso = fecha_creacion_caso_uso;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getCod_proyecto() {
        return cod_proyecto;
    }

    public void setCod_proyecto(int cod_proyecto) {
        this.cod_proyecto = cod_proyecto;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    @Override
    public String toString() {
        return "User{" +
                "cod_caso_uso=" + cod_caso_uso +
                ", nombre_caso_uso='" + nombre_caso_uso + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_creacion_caso_uso=" + fecha_creacion_caso_uso +
                ", fecha_modificacion=" + fecha_modificacion +
                ", cod_proyecto=" + cod_proyecto +
                ", cod_usuario=" + cod_usuario +
                '}';
    }
}
