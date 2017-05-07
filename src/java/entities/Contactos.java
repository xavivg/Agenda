/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usu26
 */
@Entity
@Table(name = "contactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c"),
    @NamedQuery(name = "Contactos.findById", query = "SELECT c FROM Contactos c WHERE c.id = :id"),
    @NamedQuery(name = "Contactos.findByNombre", query = "SELECT c FROM Contactos c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contactos.findByApellidos", query = "SELECT c FROM Contactos c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Contactos.findByMail", query = "SELECT c FROM Contactos c WHERE c.mail = :mail"),
    @NamedQuery(name = "Contactos.findByTfijo", query = "SELECT c FROM Contactos c WHERE c.tfijo = :tfijo"),
    @NamedQuery(name = "Contactos.findByTmovil", query = "SELECT c FROM Contactos c WHERE c.tmovil = :tmovil"),
    @NamedQuery(name = "Contactos.findByDireccion", query = "SELECT c FROM Contactos c WHERE c.direccion = :direccion")})
public class Contactos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 100)
    @Column(name = "mail")
    private String mail;
    @Size(max = 100)
    @Column(name = "tfijo")
    private String tfijo;
    @Size(max = 100)
    @Column(name = "tmovil")
    private String tmovil;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "usuario_nick", referencedColumnName = "nick")
    @ManyToOne
    private Usuario usuarioNick;

    public Contactos() {
    }

    public Contactos(Integer id) {
        this.id = id;
    }

    public Contactos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Contactos(Integer id, String nombre, String apellidos, String mail, String tfijo, String tmovil, String direccion, Usuario usuarioNick) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.tfijo = tfijo;
        this.tmovil = tmovil;
        this.direccion = direccion;
        this.usuarioNick = usuarioNick;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTfijo() {
        return tfijo;
    }

    public void setTfijo(String tfijo) {
        this.tfijo = tfijo;
    }

    public String getTmovil() {
        return tmovil;
    }

    public void setTmovil(String tmovil) {
        this.tmovil = tmovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getUsuarioNick() {
        return usuarioNick;
    }

    public void setUsuarioNick(Usuario usuarioNick) {
        this.usuarioNick = usuarioNick;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contactos[ id=" + id + " ]";
    }
    
}
