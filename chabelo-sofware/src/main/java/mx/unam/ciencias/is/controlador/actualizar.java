    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;
import java.util.LinkedList;
import java.util.List;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dewer
 */
@Controller
public class actualizar {
    
    @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosDAO Gustos_db;
    
    @RequestMapping(value="/actualizarP", method = RequestMethod.GET)
    public String confirmacion(HttpServletRequest request, Principal principal){
        
        return "actualizacion";
    }
    
    @RequestMapping(value="/actualizarUsuario", method = RequestMethod.POST)
    public String actualizaUsuario(HttpServletRequest request, Principal principal){
        String usuario = principal.getName();
        
        String name = request.getParameter("name");
        String user = request.getParameter("usuario");
        String lastnameP = request.getParameter("paterno");
        String lastnameM = request.getParameter("materno");
        String mail = request.getParameter("email");
        String password = request.getParameter("contrasena");
        String passwordConf = request.getParameter("confirmacion");
        Usuario u = Usuario_db.getUsuario(user);
        
        String musique = request.getParameter("choice1");
        String cinema = request.getParameter("choice5");
        String games = request.getParameter("choice3");
        String livres = request.getParameter("choice2");
        String Sports = request.getParameter("choice4");
        
        Usuario us = Usuario_db.getUsuario(usuario);
   
        if(name!=null){
            us.setVarNombre(name);
            Usuario_db.actualizar(us);            
        }
        if(user!=null){
            us.setVarNombre_Usuario(user);
            Usuario_db.actualizar(us);
        }
        if(lastnameP!=null){
            us.setVarAPaterno(lastnameP);
            Usuario_db.actualizar(us);
        }
        if(lastnameM!=null){
            us.setVarAMaterno(lastnameM);
            Usuario_db.actualizar(us);
        }
        if(mail!=null){
            us.setVarE_Mail(mail);
            Usuario_db.actualizar(us);
        }
        if(lastnameM!=null){
            us.setVarPassword(password);
            Usuario_db.actualizar(us);
        }
        
        List<Gustos> gustos = Gustos_db.getGustos(us);
        
        for(Gustos g: gustos){
            if(musique.equals("on") && !gustos.contains(g) && musique != null){
                Gustos g1 = new Gustos();
                g1.setVarNombre_Usuario(us);
                g1.setVarGusto("Musica");
                Gustos_db.actualizar(g1);

            }
            if(cinema.equals("on") && !gustos.contains(g) && cinema != null){
                Gustos g2 = new Gustos();
                g2.setVarNombre_Usuario(us);
                g2.setVarGusto("Peliculas/Series");
                Gustos_db.guardar(g2); 
            }
            if(games.equals("on") && !gustos.contains(g) && games != null){
                Gustos g3 = new Gustos();
                g3.setVarNombre_Usuario(us);
                g3.setVarGusto("Videojuegos");
                Gustos_db.guardar(g3); 

            }
            if(livres.equals("on") && !gustos.contains(g) && livres != null){
                Gustos g4 = new Gustos();
                g4.setVarNombre_Usuario(us);
                g4.setVarGusto("Libros");
                Gustos_db.actualizar(g4); 

            }
            if(Sports.equals("on") && !gustos.contains(g) && Sports != null){
                Gustos g5 = new Gustos();
                g5.setVarNombre_Usuario(us);
                g5.setVarGusto("Deportes");
                Gustos_db.guardar(g5); 

            }
            
        }
        
    return "redirect:/actualizacion";
}
}