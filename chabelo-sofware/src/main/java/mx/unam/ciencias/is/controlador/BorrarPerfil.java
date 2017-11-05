/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mx.unam.ciencias.is.modelo.UsuarioDAO;
import mx.unam.ciencias.is.mapeobd.Usuario;
import mx.unam.ciencias.is.mapeobd.Chatear;
import mx.unam.ciencias.is.modelo.GustosDAO;
import mx.unam.ciencias.is.modelo.ChatearDAO;
import mx.unam.ciencias.is.mapeobd.Gustos;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
/**
 *
 * @author Juan
 */
@Controller
public class BorrarPerfil {
    
    @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosDAO Gustos_db;
    @Autowired
    ChatearDAO Chatear_db;
    
    @RequestMapping(value="/eliminarUsuario", method = RequestMethod.GET)
    public String borrarUsuario(HttpServletRequest request,Principal principal){
        String nom_usuario = principal.getName();
        Usuario us = Usuario_db.getUsuario(nom_usuario);
        List<Gustos> gustos = Gustos_db.getGustos(us);
        List<Chatear> chats = Chatear_db.getChats(us);
       
        
        for(Gustos g : gustos){
           Gustos_db.eliminar(g);
        }
        
        for(Chatear ch : chats){
            Chatear_db.eliminar(ch);
        }
        
        Usuario_db.eliminar(us);
        return "redirect:/";
    }
    
    @RequestMapping(value="/cancelarEliminar", method = RequestMethod.GET)
    public String cancelar(HttpServletRequest request, Principal principal){
        
        return "redirect:/sesion/inicioU";
    }
    
    @RequestMapping(value="/confirmacionElimina", method = RequestMethod.GET)
    public String confirmacion(HttpServletRequest request, Principal principal){
        
        return "eliminacion";
    }
}
