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
    
    @RequestMapping(value="/actualizarUsuario", method = RequestMethod.GET)
    public String actualizaUsuario(HttpServletRequest request){
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
        Gustos
        
        if(name!=null){
            u.setVarNombre(name);            
        }
        if(user!=null){
            u.setVarNombre_Usuario(user);
        }
        if(lastnameP!=null){
            u.setVarAPaterno(lastnameP);
        }
        if(lastnameM!=null){
            u.setVarAMaterno(lastnameM);
        }
        if(mail!=null){
            u.setVarE_Mail(mail);
        }
        if(lastnameM!=null){
            u.setVarPassword(password);
        }
      /*  if(musique!=null && musique.equals("on") && !Gustos_db. ){
            Gustos g1 = new Gustos();
            g1.setVarNombre_Usuario(us);
            g1.setVarGusto("Musica");
            Gustos_db.guardar(g1);        
        }*/
        Usuario_db.actualizar(u);
    return "redirect:/actualizacion";
}
}