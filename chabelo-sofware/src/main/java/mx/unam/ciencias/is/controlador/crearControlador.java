/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mx.unam.ciencias.is.modelo.UsuarioDAO;
import mx.unam.ciencias.is.mapeobd.Usuario;
import mx.unam.ciencias.is.modelo.GustosDAO;
import mx.unam.ciencias.is.mapeobd.Gustos;
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
    
    
    @RequestMapping(value="/crearUsuario", method = RequestMethod.GET)
    public String registraUsuario(HttpServletRequest request){
        String name = request.getParameter("nombre");
        String lastnameP = request.getParameter("apellidoP");
        String lastnameM = request.getParameter("apellidoM");
        String user = request.getParameter("username");
        String mail = request.getParameter("email");
        String contrasena = request.getParameter("password");
        String contrasenaConf = request.getParameter("passworConf");
        Usuario u = Usuario_db.getUsuario(user);
        if(u==null){
            u = new Usuario();
            u.setVarNombre_Usuario(user);
            u.setVarNombre(name);
            u.setVarAPaterno(lastnameP);
            u.setVarAMaterno(lastnameM);
            u.setVarE_Mail(mail);
            u.setVarPassword(contrasena);
            u.setVarRol("ROLE_ADMIN");
            Usuario_db.guardar(u);
            
        }
        return "redirect:/defGustos";
    }
    @RequestMapping(value="/registraGustos" , method = RequestMethod.POST)
    public String registraGustos(HttpServletRequest request){
        String musique = request.getParameter("choice1");
        String cinema = request.getParameter("choice2");
        String games = request.getParameter("choice3");
        String livres = request.getParameter("choice4");
        String Sports = request.getParameter("choice5");
        System.out.println(musique);
        Gustos u = new Gustos();
        u.setVarGusto(games);
       
        return "redirect:/perfilDeUsuario";
        
        
    }
    
}
