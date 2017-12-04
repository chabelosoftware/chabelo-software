/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.security.Principal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import mx.unam.ciencias.is.mapeobd.Gustos;
import mx.unam.ciencias.is.mapeobd.Usuario;
import mx.unam.ciencias.is.modelo.GustosDAO;
import mx.unam.ciencias.is.modelo.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 *
 * @author gaboptm
 */
@Controller
public class IniciarSesion{
    
    @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosDAO Gustos_db;
    
    @RequestMapping(value="/")
    public String inicio(HttpServletRequest request){
        if(request.isUserInRole("ROLE_ADMIN"))
            return "redirect:/sesion/inicioU";
        
        return "inicio";
    }
    
    @RequestMapping(value="/login_error")
    public ModelAndView fallo(HttpServletRequest request,ModelMap model){
        if(request.isUserInRole("ROLE_ADMIN"))
            return new ModelAndView("redirect:/sesion/inicioU");
        
        return new ModelAndView("inicio",model);
    }
    
    @RequestMapping(value="/sesion/inicioU", method = RequestMethod.GET)
    public ModelAndView inicioU(HttpServletRequest request,ModelMap model ,Principal principal){
        
        String u = principal.getName();
        Usuario usuario = Usuario_db.getUsuario(u);
        List<Gustos> gustos = Gustos_db.getGustos(usuario);
        List<String> gustosLista = new LinkedList<>();
        model.addAttribute("username", u);
        model.addAttribute("nombre", usuario.getVarNombre());
        model.addAttribute("apellidoP", usuario.getVarAPaterno());
        model.addAttribute("apellidoM", usuario.getVarAMaterno());
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
        
        
        return new ModelAndView("perfilDeUsuario",model);
    }
}
