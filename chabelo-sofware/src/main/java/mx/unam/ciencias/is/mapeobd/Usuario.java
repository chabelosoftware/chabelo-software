/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapeobd;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author luka
 */
@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @Column(name = "nombre_usuario")
    private String varNombre_Usuario;
    @Column(name = "password")
    private String varPassword;
    @Column(name = "nombre")
    private String varNombre;
    @Column(name = "aPaterno")
    private String varAPaterno;
    @Column(name = "aMaterno")
    private String varAMaterno;
    @Column(name = "e_mail")
    private String varE_Mail;
    @Column(name = "rol")
    private String varRol;
    @OneToMany(mappedBy="varNombre_Usuario")
    private Set<Gustos> varGustos;
    @OneToMany(mappedBy="varNombre_UsuarioR")
    private Set<Chatear> varChatsR;
    @OneToMany(mappedBy="varNombre_UsuarioD")
    private Set<Chatear> varChatsD;
    

    public String getVarNombre_Usuario() {
        return varNombre_Usuario;
    }

    public void setVarNombre_Usuario(String varNombre_Usuario) {
        this.varNombre_Usuario = varNombre_Usuario;
    }

    public String getVarPassword() {
        return varPassword;
    }

    public void setVarPassword(String varPassword) {
        this.varPassword = varPassword;
    }

    public String getVarNombre() {
        return varNombre;
    }

    public void setVarNombre(String varNombre) {
        this.varNombre = varNombre;
    }

    public String getVarAPaterno() {
        return varAPaterno;
    }

    public void setVarAPaterno(String varAPaterno) {
        this.varAPaterno = varAPaterno;
    }

    public String getVarAMaterno() {
        return varAMaterno;
    }

    public void setVarAMaterno(String varAMaterno) {
        this.varAMaterno = varAMaterno;
    }

    public String getVarE_Mail() {
        return varE_Mail;
    }

    public void setVarE_Mail(String varE_Mail) {
        this.varE_Mail = varE_Mail;
    }

    public Set<Gustos> getVarGustos() {
        return varGustos;
    }

    public void setVarGustos(Set<Gustos> varGustos) {
        this.varGustos = varGustos;
    }

    public Set<Chatear> getVarChatsR() {
        return varChatsR;
    }

    public void setVarChatsR(Set<Chatear> varChatsR) {
        this.varChatsR = varChatsR;
    }

    public Set<Chatear> getVarChatsD() {
        return varChatsD;
    }

    public void setVarChatsD(Set<Chatear> varChatsD) {
        this.varChatsD = varChatsD;
    }

    public String getVarRol() {
        return varRol;
    }

    public void setVarRol(String varRol) {
        this.varRol = varRol;
    }
    
    
}
