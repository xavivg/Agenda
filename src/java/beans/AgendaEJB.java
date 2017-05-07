/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Usuario;
import javax.ejb.Stateless;
import entities.*;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import servlets.Contacto;
/**
 *
 * @author xaviv
 */
@Stateless
public class AgendaEJB {
    
@PersistenceUnit
    EntityManagerFactory emf;
   public Usuario existeUsuario(String nombre, String password){
        EntityManager em = emf.createEntityManager();
        Usuario encontrado = em.find(Usuario.class, nombre);
        if(encontrado.getPassword().equals(password)){
            return encontrado;
        }
        em.close();
        return null;
   }
   public boolean insertarContacto(Contactos c) {
            EntityManager em = emf.createEntityManager();
            Contactos contacto = em.find(Contactos.class, c.getId());
            if(contacto == null){
            em.persist(c);
            em.flush();  
            em.close();
            return true;
            }
        return false;
    }
    public Contactos existeContacto(int id, String nick){
        EntityManager em = emf.createEntityManager();
        Contactos encontrado = em.find(Contactos.class, id);
        if(encontrado.getUsuarioNick().getNick().equals(nick)){
            return encontrado;
        }
        em.close();
        return null;
   }
    public boolean deleteContacto(int id, String nick){
        EntityManager em = emf.createEntityManager();
        Contactos encontrado = em.find(Contactos.class, id);
        if(encontrado.getUsuarioNick().getNick().equals(nick)){
           em.remove(encontrado);
           em.close();
           return true;
        }
        return false;
   }
    public boolean updateContacto(Contactos c) {
        EntityManager em = emf.createEntityManager();
        Contactos contacto = em.find(Contactos.class, c.getId());
         if(contacto != null){
            contacto.setNombre(c.getNombre());
            contacto.setApellidos(c.getApellidos());
            contacto.setMail(c.getMail());
            contacto.setTfijo(c.getTfijo());
            contacto.setTmovil(c.getTmovil());
            contacto.setDireccion(c.getDireccion());
            contacto.setUsuarioNick(c.getUsuarioNick());
            em.persist(contacto);
            em.close();
            return true;
        }
        return false;
    }
}
