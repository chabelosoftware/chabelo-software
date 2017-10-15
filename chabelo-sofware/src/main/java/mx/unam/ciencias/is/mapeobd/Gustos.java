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
@Table(name="Gustos")
public class Gustos {
    @Id@GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "id_gustos")
    private int gustos_id;
    @Column(name = "gusto")
    private String varGusto;
    @ManyToOne
    @JoinColumn(name = "nombre_usuario")
    private Usuario varNombre_Usuario;

    public int getGustos_id() {
        return gustos_id;
    }

    public void setGustos_id(int gustos_id) {
        this.gustos_id = gustos_id;
    }

    public String getVarGusto() {
        return varGusto;
    }

    public void setVarGusto(String varGusto) {
        this.varGusto = varGusto;
    }

    public Usuario getVarNombre_Usuario() {
        return varNombre_Usuario;
    }

    public void setVarNombre_Usuario(Usuario varNombre_Usuario) {
        this.varNombre_Usuario = varNombre_Usuario;
    }
}
