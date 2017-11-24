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
@Table(name="Mensajes")
public class Mensaje {
    @Id@GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "id_mensaje")
    private int mensaje_id;
    @Column(name = "mensaje")
    private String varMensaje;
    @ManyToOne
    @JoinColumn(name = "id_chat")
    private Chatear chat_id;

    public int getMensaje_id() {
        return mensaje_id;
    }

    public void setMensaje_id(int mensaje_id) {
        this.mensaje_id = mensaje_id;
    }

    public String getVarMensaje() {
        return varMensaje;
    }

    public void setVarMensaje(String varMensaje) {
        this.varMensaje = varMensaje;
    }

    public Chatear getChat_id() {
        return chat_id;
    }

    public void setChat_id(Chatear chat_id) {
        this.chat_id = chat_id;
    }
}
