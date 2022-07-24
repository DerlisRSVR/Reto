package com.reto.Inventario.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vacuna")
public class Vacuna {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codigoVacuna;
     private String nombreVacuna;

    public Integer getCodigoVacuna() {
        return codigoVacuna;
    }

    public void setCodigoVacuna(Integer codigoVacuna) {
        this.codigoVacuna = codigoVacuna;
    }

    

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }
     
     
}
