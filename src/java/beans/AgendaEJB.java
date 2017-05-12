/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Usuario;
import javax.ejb.Stateless;
import entities.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author xaviv
 */
@Stateless
public class AgendaEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

    public boolean existUserByObj(Usuario u) {
        emf.getCache().evictAll();
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.find(Usuario.class, u.getNick());
        em.close();
        return usuario != null;
    }

    public Usuario getUserByNick(String nick) {
        emf.getCache().evictAll();
        return (Usuario) emf.createEntityManager().
                createNamedQuery("Usuario.findByNick").
                setParameter("nick", nick).getSingleResult();
    }

    public Usuario existUserByName(String name, String password) {
        emf.getCache().evictAll();
        EntityManager em = emf.createEntityManager();
        Usuario found = em.find(Usuario.class, name);
        if (found.getPassword().equals(password)) {
            return found;
        }
        em.close();
        return null;
    }

    public boolean insertContact(Contactos c) {
        emf.getCache().evictAll();
        EntityManager em = emf.createEntityManager();
        Contactos contact = em.find(Contactos.class, c.getId());
        if (contact == null) {
            em.persist(c);
            em.flush();
            em.close();
            return true;
        }
        return false;
    }

    public Contactos existContactByIdNick(int id, String nick) {
        emf.getCache().evictAll();
        EntityManager em = emf.createEntityManager();
        Contactos found = em.find(Contactos.class, id);
        if (found.getUsuarioNick().getNick().equals(nick)) {
            return found;
        }
        em.close();
        return null;
    }

    public boolean deleteContact(int id, String nick) {
        emf.getCache().evictAll();
        EntityManager em = emf.createEntityManager();
        Contactos found = em.find(Contactos.class, id);
        if (found.getUsuarioNick().getNick().equals(nick)) {
            em.remove(found);
            em.close();
            return true;
        }
        return false;
    }

    public boolean updateContact(Contactos c) {
        emf.getCache().evictAll();
        EntityManager em = emf.createEntityManager();
        Contactos contact = em.find(Contactos.class, c.getId());
        if (contact != null) {
            contact.setNombre(c.getNombre());
            contact.setApellidos(c.getApellidos());
            contact.setMail(c.getMail());
            contact.setTfijo(c.getTfijo());
            contact.setTmovil(c.getTmovil());
            contact.setDireccion(c.getDireccion());
            contact.setUsuarioNick(c.getUsuarioNick());
            em.persist(contact);
            em.close();
            return true;
        }
        return false;
    }

    public Boolean createUser(String name, String password) {
        emf.getCache().evictAll();
        EntityManager em = emf.createEntityManager();
        Usuario user = new Usuario(name, password);
        if (!existUserByObj(user)) {
            em.persist(user);
            em.flush();
            em.close();
            return true;
        }
        return false;
    }
}
