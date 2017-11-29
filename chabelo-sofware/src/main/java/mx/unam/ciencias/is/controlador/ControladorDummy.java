/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;
import java.security.Principal;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.unam.ciencias.is.modelo.ChatearDAO;
import mx.unam.ciencias.is.modelo.MensajeDAO;
import mx.unam.ciencias.is.modelo.UsuarioDAO;
import mx.unam.ciencias.is.mapeobd.Gustos;
import mx.unam.ciencias.is.mapeobd.Usuario;
import mx.unam.ciencias.is.mapeobd.Chatear;
import mx.unam.ciencias.is.mapeobd.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author ahernandez
 */
@Controller
public class ControladorDummy {
    @Autowired
    MensajeDAO mensajes_db;
    @Autowired
    UsuarioDAO usuario_db;
    @Autowired
    ChatearDAO chatear_db;
    
    @RequestMapping(value="/sesion/chatindividual", method = RequestMethod.GET)
    public ModelAndView ver(HttpServletRequest request, ModelMap model, Principal principal){
        String nom_usuario = request.getParameter("u");
        model.addAttribute("nom",nom_usuario);
        return new ModelAndView("chatIndividual",model);
    }
    
    @RequestMapping(value = "/sesion/respuestaChat", method = RequestMethod.GET, produces="text/plain")
    @ResponseBody
    public String dameMensaje(HttpServletRequest request,Principal principal) {
        String from = principal.getName();
        String to = request.getParameter("nom");
        String index = request.getParameter("index");
        Usuario remitente = usuario_db.getUsuario(from);
        Usuario destinatario = usuario_db.getUsuario(to);
        String flag = "1";
        
        Chatear chat = chatear_db.getChat(remitente,destinatario);
        Chatear reverseChat = chatear_db.getChat(destinatario,remitente);
        Mensaje msg = mensajes_db.getMensaje(Integer.parseInt(index), chat, reverseChat);
        
        if(msg == null) return "";
        
        if(msg.getChat_id().getVarNombre_UsuarioD().getVarNombre_Usuario().equals(to))
            flag = "0";
        return msg.getVarMensaje()+flag;
    }
    
    
    
    
    @RequestMapping(value = "/sesion/mandarMsg", method = RequestMethod.GET, produces="text/plain")
    @ResponseBody
    public String test(HttpServletRequest request,Principal principal) {
        String msg = request.getParameter("mensaje");
        String from = principal.getName();
        String to = request.getParameter("nom");
        
        Usuario remitente = usuario_db.getUsuario(from);
        Usuario destinatario = usuario_db.getUsuario(to);
        
        Chatear chat = chatear_db.getChat(remitente,destinatario);
        
        if(chat == null){
            chat = new Chatear();
            chat.setVarNombre_UsuarioD(destinatario);
            chat.setVarNombre_UsuarioR(remitente);
            chatear_db.guardar(chat);
        }
        
        Mensaje m = new Mensaje();
        m.setChat_id(chat);
        m.setVarMensaje(msg);
        mensajes_db.guardar(m);
        return "";
    }
    
    @RequestMapping(value = "/sesion/respuestaChatRecibidos", method = RequestMethod.GET, produces="text/plain")
    @ResponseBody
    public String dameMensajeRecibido(HttpServletRequest request,Principal principal) {
        String from = principal.getName();
        String to = request.getParameter("nom");
        String index = request.getParameter("index");
        Usuario remitente = usuario_db.getUsuario(from);
        Usuario destinatario = usuario_db.getUsuario(to);
        if (remitente.getVarNombre_Usuario().equals(destinatario.getVarNombre_Usuario()))
            return "";
        String flag = "1";
        
        Chatear chat = chatear_db.getChat(destinatario,remitente);
        Mensaje msg = mensajes_db.getMensaje(Integer.parseInt(index), chat, null);
        
        if(msg == null) return "";
        
        return msg.getVarMensaje()+flag;
    }
        @RequestMapping(value="/sesion/chatGeneral", method = RequestMethod.GET)
    public ModelAndView chatgral(HttpServletRequest request, ModelMap model,Principal principal){
        List<Chatear> chats = chatear_db.getChats(); //lsita de TODOS los chats
        List<Chatear> ch = new ArrayList<Chatear>();
        String nu = principal.getName();
        
        for(Chatear c : chats)
            if(c.getVarNombre_UsuarioD().getVarNombre_Usuario().equals(nu))
                ch.add(c); //En ch solo van las que son destinadas al usuario en sesion
                
          
        model.addAttribute("chats", ch);
        
        return new ModelAndView("chatGeneral",model);
    }
    
    
    
}
