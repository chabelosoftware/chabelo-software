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
import mx.unam.ciencias.is.modelo.GustosDAO;
import mx.unam.ciencias.is.mapeobd.Gustos;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author dewer
 */
@Controller
public class crearControlador {
    
    @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosDAO Gustos_db;
    
    /**
     * Guarda un nuevo usuario 
     * @param request los atributos del usuario.
     * @return 
     */
    
    
    @RequestMapping(value="/crearUsuario", method = RequestMethod.POST)
    public ModelAndView registraUsuario(HttpServletRequest request,ModelMap model){
        String name = request.getParameter("nombre");
        String lastnameP = request.getParameter("apellidoP");
        String lastnameM = request.getParameter("apellidoM");
        String user = request.getParameter("username");
        String mail = request.getParameter("email");
        String contrasena = request.getParameter("password");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(contrasena);
        String contrasenaConf = request.getParameter("passworConf");
        Usuario u = Usuario_db.getUsuario(user);
        if(u==null && contrasena.equals(contrasenaConf)){
            u = new Usuario();
            u.setVarNombre_Usuario(user);
            u.setVarNombre(name);
            u.setVarAPaterno(lastnameP);
            u.setVarAMaterno(lastnameM);
            u.setVarE_Mail(mail);
            u.setVarPassword(hashedPassword);
            u.setVarRol("ROLE_ADMIN");
            Usuario_db.guardar(u);
           
            model.addAttribute("username", user);
            return new ModelAndView("defGustos",model);
        }        
        return new ModelAndView("inicio",model);
    }
    
    @RequestMapping(value="/registraGustos" , method = RequestMethod.POST)
    public String registraGustos(HttpServletRequest request){
        String user = request.getParameter("username");
        Usuario us = Usuario_db.getUsuario(user);
        
        String musique = request.getParameter("choise1");
        String cinema = request.getParameter("choise2");
        String games = request.getParameter("choise3");
        String livres = request.getParameter("choise4");
        String Sports = request.getParameter("choise5");
        
        System.out.println("--------------------------------"+request.getParameter("choice1"));
        if(musique != null && musique.equals("on")){
            Gustos g1 = new Gustos();
            g1.setVarNombre_Usuario(us);
            g1.setVarGusto("Musica");
            Gustos_db.guardar(g1);        
        }
        if(cinema != null && cinema.equals("on")){
            Gustos g2 = new Gustos();
            g2.setVarNombre_Usuario(us);
            g2.setVarGusto("Peliculas/Series");
            Gustos_db.guardar(g2);        
        }
        if(games != null && games.equals("on")){
            Gustos g3 = new Gustos();
            g3.setVarNombre_Usuario(us);
            g3.setVarGusto("Juegos");
            Gustos_db.guardar(g3);        
        }
        if(livres != null && livres.equals("on")){
            Gustos g4 = new Gustos();
            g4.setVarNombre_Usuario(us);
            g4.setVarGusto("Libros");
            Gustos_db.guardar(g4);        
        }
        if(Sports != null && Sports.equals("on")){
            Gustos g5 = new Gustos();
            g5.setVarNombre_Usuario(us);
            g5.setVarGusto("Deportes");
            Gustos_db.guardar(g5);        
        }
       
        return "redirect:/";
        
        
    }
    
}
