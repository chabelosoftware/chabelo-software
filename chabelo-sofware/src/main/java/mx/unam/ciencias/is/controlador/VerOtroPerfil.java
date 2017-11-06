/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.security.Principal;
import java.util.LinkedList;
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
 * @author luka
 */

@Controller
public class VerOtroPerfil {
    
     @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosDAO Gustos_db;
    
    @RequestMapping(value="/VerOtroPerfil", method = RequestMethod.GET)
    public ModelAndView ver(HttpServletRequest request, ModelMap model, Principal principal){
        String nom_usuario = request.getParameter("u");
        Usuario usuario = Usuario_db.getUsuario(nom_usuario);
        List<Gustos> gustos = Gustos_db.getGustos(usuario);
        List<String> gustosLista = new LinkedList<>();
        model.addAttribute("username", usuario.getVarNombre_Usuario());
        model.addAttribute("nombre", usuario.getVarNombre());
        model.addAttribute("correo", usuario.getVarE_Mail());
       
        
        for(Gustos g :gustos){
            gustosLista.add(g.getVarGusto());
        }
            
        if(gustosLista.contains("Musica"))
            model.addAttribute("m", 1);
        else
            model.addAttribute("m", 0);
        
        if(gustosLista.contains("Peliculas/Series"))
            model.addAttribute("p", 1);
        else
            model.addAttribute("p", 0);
        
        
        if(gustosLista.contains("Juegos"))
            model.addAttribute("j", 1);
        else
            model.addAttribute("j", 0);
        
        if(gustosLista.contains("Libros"))
            model.addAttribute("l", 1);
        else
            model.addAttribute("l", 0);
        
        if(gustosLista.contains("Deportes"))
            model.addAttribute("d", 1);
        else
            model.addAttribute("d", 0);
        
        if(gustosLista.contains("Musica"))
            model.addAttribute("m", 1);
        else
            model.addAttribute("m", 0);
        
        
        return new ModelAndView("consultaDeUnPerfil",model);
        
    }
    
}
