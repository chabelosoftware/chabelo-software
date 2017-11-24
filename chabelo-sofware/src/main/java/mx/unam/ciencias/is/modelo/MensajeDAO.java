/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;
import mx.unam.ciencias.is.mapeobd.Mensaje;
import java.util.List;
import mx.unam.ciencias.is.mapeobd.Chatear;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author luka
 */
public class MensajeDAO {
    
    /*Sesion para conectarnos a la base de datos*/
    private SessionFactory sessionFactory;
    
    /**
     * Inicialisamos la sesion a la base de datos.
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * Guarda un MEnsaje a la base de datos 
     * @param mensaje el mensaje a guardar.
     */
    public void guardar(Mensaje mensaje) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el mensaje
            session.persist(mensaje);
           
            tx.commit();
        }
        catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx!=null){ 
                tx.rollback();
            }
            e.printStackTrace(); 
        }
        finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
    
    /**
     * Elimina el usuario de la base de datos
     * @parammensaje el mensaje a eliminar
     */
    public void eliminar(Mensaje mensaje) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //eliminamos el mensaje
            session.delete(mensaje);
           
            tx.commit();
        }
        catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx!=null){ 
                tx.rollback();
            }
            e.printStackTrace(); 
        }
        finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
    
    /**
     * Actualiza el usuario en la base de datos
     * @param mensaje con los nuevos valores 
     */
    public void actualizar(Mensaje mensaje) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //actualizar el mensaje
            session.update(mensaje);
           
            tx.commit();
        }
        catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx!=null){ 
                tx.rollback();
            }
            e.printStackTrace(); 
        }
        finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
    
    /**
     * Regresa la lista de todos los mensajes en la base de datos
     * @return la lista que contiene a todos los mensajes de la base de datos
     */
    public List<Mensaje> getMensajes(){
        List<Mensaje> result= null;
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            String hql= "FROM Mensaje";
            Query query =session.createQuery(hql);
            result=(List<Mensaje>)query.list();
            tx.commit();
        }catch (Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();      
        }finally{
            session.close();
        }
        return result;
    }
    
    /**
     * Regresa el mensaje con el id dado
     * @param id del mensaje 
     * @return el mensaje con ese id
     */
    public Mensaje getMensaje(int id) {
        Mensaje result = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = "FROM Mensaje WHERE mensaje_id = :id";                  
            Query query = s.createQuery(hql);
            query.setParameter("id",id);
            result = (Mensaje)query.uniqueResult();
            tx.commit();
        }catch(Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            s.close();
        }
        
        return result;
    }
    
    /**
     * Regresa el index-ésimo mensaje que ha llegado, entre los usuarios involucrados en los chats dados 
     * @param index indice del mensaje con respecto a su tiempo de envio, de mayor a menor
     * @param chat chat asociado a los mensajes
     * @param reverseChat el chat inverso asociado a los mensajes, es decir, con el remitente y el destinatario intercambiados
     * @return el mensaje con las caracteristicas dadas
     */
    public Mensaje getMensaje(int index, Chatear chat, Chatear reverseChat) {
        Mensaje result = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = "FROM Mensaje WHERE chat_id = :c OR chat_id = :r ORDER BY mensaje_id DESC";                  
            Query query = s.createQuery(hql);
            query.setParameter("c",chat);
            query.setParameter("r",reverseChat);
            query.setFirstResult(index);
            query.setMaxResults(1);
            result = (Mensaje)query.uniqueResult();
            tx.commit();
        }catch(Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            s.close();
        }
        
        return result;
    }
}
