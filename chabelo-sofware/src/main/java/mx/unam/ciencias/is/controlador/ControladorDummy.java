/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author ahernandez
 */
@Controller
public class ControladorDummy {
    
    @RequestMapping(value="/perfilDeUsuario", method = RequestMethod.GET)
    public String perfilDeUsuario(){
        return "perfilDeUsuario";   
    }
    
    @RequestMapping(value="/consultaDeUnPerfil", method = RequestMethod.GET)
    public String consultaDeUnPerfil(){
        return "consultaDeUnPerfil";   
    }
    
     @RequestMapping(value="/actualizacion", method = RequestMethod.GET)
    public String actualizacion(){
        return "actualizacion";   
    }
    
     @RequestMapping(value="/resultadobusqueda", method = RequestMethod.GET)
    public String resultadobusqueda(){
        return "resultadobusqueda";   
    }
    
    @RequestMapping(value="/eliminacion", method = RequestMethod.GET)
    public String eliminacion(){
        return "eliminacion";   
    }
    
    @RequestMapping(value="/chatindividual", method = RequestMethod.GET)
    public String chat(){
        return "chatIndividual";   
    }
    
    @RequestMapping(value = "/respuestaChat", method = RequestMethod.GET, produces="text/plain")
    @ResponseBody
    public String test() {
        return "Mensaje emergente prros del mal";
    }
}
