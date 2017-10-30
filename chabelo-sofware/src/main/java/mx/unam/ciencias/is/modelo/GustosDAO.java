/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;
import mx.unam.ciencias.is.mapeobd.Gustos;
import mx.unam.ciencias.is.mapeobd.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author luka
 */
public class GustosDAO {
    
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
     * @param gusto el gusto a guardar.
     */
    public void guardar(Gustos gusto) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el gusto
            session.persist(gusto);
           
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
     * Elimina el Gusto de la base de datos
     * @parammensaje el gusto a eliminar
     */
    public void eliminar(Gustos gusto) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //eliminamos el gusto
            session.delete(gusto);
           
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
     * Actualiza el Gusto en la base de datos
     * @param gusto con los nuevos valores 
     */
    public void actualizar(Gustos gusto) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //actualizar el gusto
            session.update(gusto);
           
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
     * Regresa la lista de todos los Gustos en la base de datos
     * @return la lista que contiene a todos los gustos de la base de datos
     */
    public List<Gustos> getGustos(){
        List<Gustos> result= null;
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            String hql= "FROM Gustos";
            Query query =session.createQuery(hql);
            result=(List<Gustos>)query.list();
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
     * Regresa los gustos con el numbre de usuario dado
     * @param us objeto usuario del usuario 
     * @return lista de gustos ligados al usuario dado
     */
    public List<Gustos> getGustos(Usuario us){
        List<Gustos> result= null;
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            String hql= "FROM Gustos WHERE varNombre_Usuario = :u";
            Query query =session.createQuery(hql);
            query.setParameter("u",us);
            result=(List<Gustos>)query.list();
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
     * Regresa el gusto con el id dado
     * @param id del gusto 
     * @return el gusto con ese id
     */
    public Gustos getGusto(int id) {
        Gustos result = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = "FROM Gustos WHERE gustos_id = :id";                  
            Query query = s.createQuery(hql);
            query.setParameter("id",id);
            result = (Gustos)query.uniqueResult();
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
