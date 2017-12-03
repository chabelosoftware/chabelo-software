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
    public ModelAndView perfilDeUsuario(HttpServletRequest request,ModelMap model ,Principal principal){
        String u = principal.getName();
        Usuario usuario = usuario_db.getUsuario(u);
        List<Gustos> gustos = gustos_db.getGustos(usuario);
        List<String> gustosLista = new LinkedList<>();
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
        
        
        return new ModelAndView("buscGustos",model);   
    }
    
    @RequestMapping(value="/sesion/buscMusica", method = RequestMethod.GET)
    public ModelAndView buscMusica(ModelMap model, Principal principal){
        
        String u = principal.getName();
        Usuario usuario = usuario_db.getUsuario(u);
        List<Gustos> gustosUsuario = gustos_db.getGustos(usuario);
        List<String> gustosLista = new LinkedList<>();
        for(Gustos g :gustosUsuario){
            gustosLista.add(g.getVarGusto());
        }
            
        if(!gustosLista.contains("Musica"))
            return new ModelAndView("redirect:/sesion/buscGustos");
        
        List<Gustos> gustos = gustos_db.getGustosPorNombre("Musica");
        List<Usuario> users;
        List<Double> percentage;
        users = new LinkedList<>();
        percentage = new LinkedList<>();
        for(Gustos g: gustos)
            users.add(g.getVarNombre_Usuario());
        
        for(Usuario us:users)
            percentage.add(compatibilidad(usuario,us));
        
        model.addAttribute("usuarios", users);
        model.addAttribute("compatibilidad", percentage);
        return new ModelAndView("resultadobusqueda",model);
        
    }
    
    @RequestMapping(value="/sesion/buscJuegos", method = RequestMethod.GET)
    public ModelAndView buscJuegos(ModelMap model, Principal principal){
        
        String u = principal.getName();
        Usuario usuario = usuario_db.getUsuario(u);
        List<Gustos> gustosUsuario = gustos_db.getGustos(usuario);
        List<String> gustosLista = new LinkedList<>();
        for(Gustos g :gustosUsuario){
            gustosLista.add(g.getVarGusto());
        }
            
        if(!gustosLista.contains("Juegos"))
            return new ModelAndView("redirect:/sesion/buscGustos");
        
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
    public ModelAndView buscLibros(ModelMap model, Principal principal){
        
        String u = principal.getName();
        Usuario usuario = usuario_db.getUsuario(u);
        List<Gustos> gustosUsuario = gustos_db.getGustos(usuario);
        List<String> gustosLista = new LinkedList<>();
        for(Gustos g :gustosUsuario){
            gustosLista.add(g.getVarGusto());
        }
            
        if(!gustosLista.contains("Libros"))
            return new ModelAndView("redirect:/sesion/buscGustos");
        
        
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
    public ModelAndView buscDeportes(ModelMap model, Principal principal){
        
        String u = principal.getName();
        Usuario usuario = usuario_db.getUsuario(u);
        List<Gustos> gustosUsuario = gustos_db.getGustos(usuario);
        List<String> gustosLista = new LinkedList<>();
        for(Gustos g :gustosUsuario){
            gustosLista.add(g.getVarGusto());
        }
            
        if(!gustosLista.contains("Deportes"))
            return new ModelAndView("redirect:/sesion/buscGustos");
        
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
    public ModelAndView buscCine(ModelMap model, Principal principal){
        
        String u = principal.getName();
        Usuario usuario = usuario_db.getUsuario(u);
        List<Gustos> gustosUsuario = gustos_db.getGustos(usuario);
        List<String> gustosLista = new LinkedList<>();
        for(Gustos g :gustosUsuario){
            gustosLista.add(g.getVarGusto());
        }
            
        if(!gustosLista.contains("Peliculas/Series"))
            return new ModelAndView("redirect:/sesion/buscGustos");
        
        List<Gustos> gustos = gustos_db.getGustosPorNombre("Peliculas/Series");
        List<Usuario> users;
        users = new LinkedList<>();
        for(Gustos g: gustos){
            users.add(g.getVarNombre_Usuario());
        }
          
        model.addAttribute("usuarios", users);
        
        return new ModelAndView("resultadobusqueda",model);
    
    }
    /*
    * Qué tan compatible es u1 con respecto a u2, no es una relación conmutativa
    */
    public double compatibilidad(Usuario u1, Usuario u2){
        List<Gustos> gustosUsuario1 = gustos_db.getGustos(u1);
        List<String> gustosLista1 = new LinkedList<>();
        for(Gustos g :gustosUsuario1){
            gustosLista1.add(g.getVarGusto());
        }
        
        List<Gustos> gustosUsuario2 = gustos_db.getGustos(u2);
        List<String> gustosLista2 = new LinkedList<>();
        for(Gustos g :gustosUsuario2){
            gustosLista2.add(g.getVarGusto());
        }
        
        double ret = 0.0;
        double gustosComunes = 0;
        for (String s:gustosLista1){
            if(gustosLista2.contains(s))
                gustosComunes++;
        }
        ret = ((double)gustosComunes) / gustosLista1.size();
        return ret;
    }
}
