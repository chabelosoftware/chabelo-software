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
@Table(name="Chatear")
public class Chatear {
    @Id@GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "id_chat")
    private int chat_id;
    @ManyToOne
    @JoinColumn(name = "nombre_usuarioD")
    private Usuario varNombre_UsuarioD;
    @ManyToOne
    @JoinColumn(name = "nombre_usuarioR")
    private Usuario varNombre_UsuarioR;
    @OneToMany(mappedBy="chat_id")
    private Set<Mensaje> varMensajes;

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public Usuario getVarNombre_UsuarioD() {
        return varNombre_UsuarioD;
    }

    public void setVarNombre_UsuarioD(Usuario varNombre_UsuarioD) {
        this.varNombre_UsuarioD = varNombre_UsuarioD;
    }

    public Usuario getVarNombre_UsuarioR() {
        return varNombre_UsuarioR;
    }

    public void setVarNombre_UsuarioR(Usuario varNombre_UsuarioR) {
        this.varNombre_UsuarioR = varNombre_UsuarioR;
    }

    public Set<Mensaje> getVarMensajes() {
        return varMensajes;
    }

    public void setVarMensajes(Set<Mensaje> varMensajes) {
        this.varMensajes = varMensajes;
    }
}
