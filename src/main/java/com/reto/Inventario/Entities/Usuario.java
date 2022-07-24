

package com.reto.Inventario.Entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codigo;
    private String nombres;
    private String Apellidos;
    @Column(unique=true,length=10)
    private String cedula;
    private String mail;
    private String pass;
    
    @Column(nullable = true)
    private Date fechaNacimiento;
    @Column(nullable = true)
    private String direccion;
    @Column(nullable = true)
    private String teléfono;
    @Column(nullable = true)
    private Integer estadoVacunacion;
    

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="VacunaFK")
    private Vacuna tipoVacuna;
    @Column(nullable = true)
    private Date fechaVacunacion;
    @Column(nullable = true)
    private Integer numDosis;
    
    private Integer estadoUsu=1;
    private Integer tipoUsu=2;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public Integer getEstadoVacunacion() {
        return estadoVacunacion;
    }

    public void setEstadoVacunacion(Integer estadoVacunacion) {
        this.estadoVacunacion = estadoVacunacion;
    }

    public Vacuna getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(Vacuna tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public Date getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(Date fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public Integer getNumDosis() {
        return numDosis;
    }

    public void setNumDosis(Integer numDosis) {
        this.numDosis = numDosis;
    }

    public Integer getEstadoUsu() {
        return estadoUsu;
    }

    public void setEstadoUsu(Integer estadoUsu) {
        this.estadoUsu = estadoUsu;
    }

    public Integer getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(Integer tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

    
    
    @PrePersist
    public void prePersist(){
        String clave=cedula+"RETO";
    this.pass=clave;
    }
    
}
