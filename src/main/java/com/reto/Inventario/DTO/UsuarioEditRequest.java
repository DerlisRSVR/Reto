package com.reto.Inventario.DTO;

import com.reto.Inventario.Entities.Vacuna;
import java.util.Date;
import lombok.Data;

@Data
public class UsuarioEditRequest {

    private String nombres;
    private String apellidos;
    private String cedula;
    private String mail;
    private Date fechaNacimiento;
    private String direccion;
    private String teléfono;
    private Integer estadoVacunacion;
    private Vacuna tipoVacuna;
    private Date fechaVacunacion;
    private Integer numDosis;

}
