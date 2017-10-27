/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gaboptm
 */
@Controller
public class IniciarSesion {
    
    @RequestMapping(value="/")
    public String inicio(HttpServletRequest request){
        if(request.isUserInRole("ROLE_Usuario"))
           return "redirect:/sesion/inicioU";
        return "inicio";
    }
    
    @RequestMapping(value="/sesion/inicioU", method = RequestMethod.GET)
    public ModelAndView inicioU(HttpServletRequest request,ModelMap model ,Principal principal){
        
        String u = principal.getName();
        model.addAttribute("username", u);
        return new ModelAndView("perfilDeUsuario",model);
    }
}
