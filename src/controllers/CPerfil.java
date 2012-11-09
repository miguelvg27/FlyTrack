/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Parametro;
import beans.Sesion;
import beans.seguridad.Accion;
import beans.seguridad.Perfil;
import beans.seguridad.Usuario;
import java.util.List;
import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author joao
 */
public class CPerfil {
    
    public List<Perfil> Buscar(){
        
        SessionFactory sf = Sesion.getSessionFactory();
        Session s = sf.openSession();
        
        try {
            Transaction tx = s.beginTransaction();
            Query q = s.getNamedQuery("Perfil");
            return (List<Perfil>)q.list();           
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            s.close();
        }
        
        return null;
        
    }
         
    public List<Accion> BuscarAcciones (){
        
        SessionFactory sf = Sesion.getSessionFactory();
        Session s = sf.openSession();
        List<Accion> ListaAccion;
        
        try {
            Transaction tx = s.beginTransaction();
            Query q = s.getNamedQuery("ArbolAccion");
            ListaAccion= q.list();
                      
           return ListaAccion;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
                }
        finally {
            s.close();
        }
        return null;
    }
         
    public void agregarPerfil(String nombre, String descripcion, Parametro estado){
        
        SessionFactory sf = Sesion.getSessionFactory();
        Session s = sf.openSession();

        try {
            Transaction tx = s.beginTransaction();
            Query q;

            Perfil CPerfil = new Perfil();

            CPerfil.setNombre(nombre);
            CPerfil.setDescripcion(descripcion);
            CPerfil.setEstado(estado);

            int i = (Integer)s.save(CPerfil);
            tx.commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
                }
        finally {
            s.close();
        }
        
    }   
     
    public void modificarPerfil(Integer idPerfil,String nombre, String descripcion, Parametro estado){
        
        SessionFactory sf = Sesion.getSessionFactory();
        Session s = sf.openSession( );
        
        try {
            Transaction tx = s.beginTransaction();
            Query q;
            
            Perfil CPerfil = new Perfil();
            CPerfil.setIdPerfil(idPerfil);
            CPerfil.setNombre(nombre);
            CPerfil.setDescripcion(descripcion);
            CPerfil.setEstado(estado);
            
            
            s.update(CPerfil);
            tx.commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
                }
        finally {
            s.close();
        }
        
    }   
         
    public static Perfil BuscarXid(int id){
    
        SessionFactory sf = Sesion.getSessionFactory();
        Session s = sf.openSession();
        
        try {
            Transaction tx = s.beginTransaction();
            Query q = s.getNamedQuery("PerfilxId").setMaxResults(1);
            q.setParameter("idperfil", id);
            return (Perfil)q.uniqueResult();
            }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            s.close();
        }
        
        return null;
    }
                
    public static String validar(Integer idperfil, String nombre, String descripcion, Parametro estado) {
        SessionFactory sf = Sesion.getSessionFactory();
        Session s = sf.openSession();
        String error_message = "";
//        Perfil p;
        try {

            if (nombre.isEmpty()|| descripcion.isEmpty()|| estado==null ) {
                error_message = error_message + CValidator.buscarError("ERROR_FT001") + "\n";
            }
            
            if(!nombre.isEmpty()){
                
//                Query q = s.getNamedQuery("PerfilXNombre");
                Query q = s.getNamedQuery("PerfilXNombre").setMaxResults(1);
                q.setParameter("nombre", nombre);
//                List<Perfil> tipos = q.list();
                Perfil perfilEncontrado = (Perfil)q.uniqueResult();

                if (perfilEncontrado != null) {
                    error_message = error_message + CValidator.buscarError("ERROR_FT005") + "\n";                    
                }

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            s.close();
        }

        return error_message;
    }
        
         
}
