/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
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

/**
 * @author ahernandez
 */
@Controller
public class BuscarUsuariosPorGustosEnComun {
    
    @Autowired
    GustosDAO gustos_db;
    @Autowired
    UsuarioDAO usuario_db;
    
    @RequestMapping(value="/sesion/buscGustos", method = RequestMethod.GET)
    public String perfilDeUsuario(){
        return "buscGustos";   
    }
    
    @RequestMapping(value="/sesion/buscMusica", method = RequestMethod.GET)
    public ModelAndView buscMusica(ModelMap model){
        List<Gustos> gustos = gustos_db.getGustosPorNombre("Musica");
        List<Usuario> users;
        users = new LinkedList<>();
        for(Gustos g: gustos){
            users.add(g.getVarNombre_Usuario());
        }
          
        model.addAttribute("usuarios", users);
        
        return new ModelAndView("resultadobusqueda",model);
    
    }
    
    @RequestMapping(value="/sesion/buscJuegos", method = RequestMethod.GET)
    public ModelAndView buscJuegos(ModelMap model){
        List<Gustos> gustos = gustos_db.getGustosPorNombre("Juegos");
        List<Usuario> users;
        users = new LinkedList<>();
        for(Gustos g: gustos){
            users.add(g.getVarNombre_Usuario());
        }
          
        model.addAttribute("usuarios", users);
        
        return new ModelAndView("resultadobusqueda",model);
    
    }
    @RequestMapping(value="/sesion/buscLibros", method = RequestMethod.GET)
    public ModelAndView buscLibros(ModelMap model){
        List<Gustos> gustos = gustos_db.getGustosPorNombre("Libros");
        List<Usuario> users;
        users = new LinkedList<>();
        for(Gustos g: gustos){
            users.add(g.getVarNombre_Usuario());
        }
          
        model.addAttribute("usuarios", users);
        
        return new ModelAndView("resultadobusqueda",model);
    
    }
    
    @RequestMapping(value="/sesion/buscDeportes", method = RequestMethod.GET)
    public ModelAndView buscDeportes(ModelMap model){
        List<Gustos> gustos = gustos_db.getGustosPorNombre("Deportes");
        List<Usuario> users;
        users = new LinkedList<>();
        for(Gustos g: gustos){
            users.add(g.getVarNombre_Usuario());
        }
          
        model.addAttribute("usuarios", users);
        
        return new ModelAndView("resultadobusqueda",model);
    
    }
    
    @RequestMapping(value="/sesion/buscCine", method = RequestMethod.GET)
    public ModelAndView buscCine(ModelMap model){
        List<Gustos> gustos = gustos_db.getGustosPorNombre("Peliculas/Series");
        List<Usuario> users;
        users = new LinkedList<>();
        for(Gustos g: gustos){
            users.add(g.getVarNombre_Usuario());
        }
          
        model.addAttribute("usuarios", users);
        
        return new ModelAndView("resultadobusqueda",model);
    
    }
    
}
