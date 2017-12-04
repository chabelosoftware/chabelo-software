    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
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
public class actualizar {
    
    @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosDAO Gustos_db;
    
    @RequestMapping(value="/sesion/actualizarP", method = RequestMethod.GET)
    public ModelAndView confirmacion(HttpServletRequest request, Principal principal,ModelMap model){
        String usuario = principal.getName();
        Usuario us = Usuario_db.getUsuario(usuario);
        List<Gustos> gustos = Gustos_db.getGustos(us);
        ArrayList<String> gustos2 = new ArrayList<String>();
        for(Gustos g: gustos){
           gustos2.add(g.getVarGusto());
        }
        model.addAttribute("nombre",us.getVarNombre());
        model.addAttribute("paterno", us.getVarAPaterno());
        model.addAttribute("materno", us.getVarAMaterno());
        model.addAttribute("correo",us.getVarE_Mail());
        model.addAttribute("usuario",us.getVarNombre_Usuario());
        
        if(gustos2.contains("Musica"))
            model.addAttribute("m", "1");
        else
            model.addAttribute("m", "0");
        
        if(gustos2.contains("Libros"))
            model.addAttribute("l", "1");
        else
            model.addAttribute("l", "0");
        
        if(gustos2.contains("Peliculas/Series"))
            model.addAttribute("p", "1");
        else
            model.addAttribute("p", "0");
        
        if(gustos2.contains("Juegos"))
            model.addAttribute("j", "1");
        else
            model.addAttribute("j", "0");
        
        if(gustos2.contains("Deportes"))
            model.addAttribute("d", "1");
        else
            model.addAttribute("d", "0");
            
        return new ModelAndView("actualizacion",model);
    }
    
    @RequestMapping(value="/sesion/actualizarUsuario", method = RequestMethod.POST)
    public String actualizaUsuario(HttpServletRequest request, Principal principal){
        String usuario = principal.getName();
        
        
        String name = request.getParameter("name");
        String user = request.getParameter("usuario");
        String lastnameP = request.getParameter("paterno");
        String lastnameM = request.getParameter("materno");
        String mail = request.getParameter("email");
        String password = request.getParameter("contrasena");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        String passwordConf = request.getParameter("confirmacion");
        Usuario u = Usuario_db.getUsuario(user);
        
        String musique = request.getParameter("choice1");
        String cinema = request.getParameter("choice5");
        String games = request.getParameter("choice3");
        String livres = request.getParameter("choice2");
        String Sports = request.getParameter("choice4");
        
        Usuario us = Usuario_db.getUsuario(usuario);
        
        if(password.equals(passwordConf)){
            if(name!=null){
                us.setVarNombre(name);            
            }
            if(user!=null){
                us.setVarNombre_Usuario(user);
            }
            if(lastnameP!=null){
                us.setVarAPaterno(lastnameP);
            }
            if(lastnameM!=null){
                us.setVarAMaterno(lastnameM);
            }
            if(mail!=null){
                us.setVarE_Mail(mail);
            }
            if(password!=null){
                us.setVarPassword(hashedPassword);
            }
        }else{
            return "redirect:/actualizarP";
        }
        
        Usuario_db.actualizar(us);
        
        List<Gustos> gustos_g = Gustos_db.getGustos(us);
        ArrayList<String> gustos = new ArrayList<String>();
        for(Gustos g: gustos_g){
           gustos.add(g.getVarGusto());
        }
        
        System.out.println("----------"+musique);
        System.out.println("----------"+livres);
        System.out.println("----------"+Sports);
        System.out.println("----------"+cinema);
        System.out.println("----------"+games);
        
        if(musique!=null && musique.equals("musica") && !gustos.contains("Musica")){
            Gustos g1 = new Gustos();
            g1.setVarNombre_Usuario(us);
            g1.setVarGusto("Musica");
            Gustos_db.guardar(g1);
        }
        if(cinema!=null && cinema.equals("peliculas") && !gustos.contains("Peliculas/Series")){
            Gustos g2 = new Gustos();
            g2.setVarNombre_Usuario(us);
            g2.setVarGusto("Peliculas/Series");
            Gustos_db.guardar(g2); 
        }
        if(games!=null && games.equals("juegos") && !gustos.contains("Juegos")){
            Gustos g3 = new Gustos();
            g3.setVarNombre_Usuario(us);
            g3.setVarGusto("Juegos");
            Gustos_db.guardar(g3);
        }
        if(livres!=null && livres.equals("libros") && !gustos.contains("Libros")){
            Gustos g4 = new Gustos();
            g4.setVarNombre_Usuario(us);
            g4.setVarGusto("Libros");
            Gustos_db.guardar(g4);
        }
        if(Sports!=null && Sports.equals("deportes") && !gustos.contains("Deportes")){
            Gustos g5 = new Gustos();
            g5.setVarNombre_Usuario(us);
            g5.setVarGusto("Deportes");
            Gustos_db.guardar(g5);
        }
        
        if(musique==null && gustos.contains("Musica")){
            for(Gustos g: gustos_g){
                if(g.getVarGusto().equals("Musica"))
                    Gustos_db.eliminar(g);
            }
        }
        if(cinema==null && gustos.contains("Peliculas/Series")){
            for(Gustos g: gustos_g){
                if(g.getVarGusto().equals("Peliculas/Series"))
                    Gustos_db.eliminar(g);
            }
        }
        if(games==null && gustos.contains("Juegos")){
            for(Gustos g: gustos_g){
                if(g.getVarGusto().equals("Juegos"))
                    Gustos_db.eliminar(g);
            }
        }
        if(livres==null && gustos.contains("Libros")){
            for(Gustos g: gustos_g){
                if(g.getVarGusto().equals("Libros"))
                    Gustos_db.eliminar(g);
            }
        }
        if(Sports==null && gustos.contains("Deportes")){
            for(Gustos g: gustos_g){
                if(g.getVarGusto().equals("Deportes"))
                    Gustos_db.eliminar(g);
            }
        }
        
    return "redirect:/sesion/inicioU";
}
}