/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;
import mx.unam.ciencias.is.mapeobd.Chatear;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author luka
 */
public class ChatearDAO {
    
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
     * Guarda un Gusto a la base de datos 
     * @param chat el chat a guardar.
     */
    public void guardar(Chatear chat) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el chat
            session.persist(chat);
           
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
     * Elimina el chat de la base de datos
     * @parammensaje el chat a eliminar
     */
    public void eliminar(Chatear chat) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //eliminamos el chat
            session.delete(chat);
           
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
     * Actualiza el chat en la base de datos
     * @param chat con los nuevos valores 
     */
    public void actualizar(Chatear chat) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //actualizar el gusto
            session.update(chat);
           
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
     * Regresa la lista de todos los chats en la base de datos
     * @return la lista que contiene a todos los chats de la base de datos
     */
    public List<Chatear> getChats(){
        List<Chatear> result= null;
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            String hql= "FROM Chatear";
            Query query =session.createQuery(hql);
            result=(List<Chatear>)query.list();
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
     * Regresa el chat con el id dado
     * @param id del chat 
     * @return el chat con ese id
     */
    public Chatear getChat(int id) {
        Chatear result = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = "FROM Chatear WHERE chat_id = :id";                  
            Query query = s.createQuery(hql);
            query.setParameter("id",id);
            result = (Chatear)query.uniqueResult();
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
