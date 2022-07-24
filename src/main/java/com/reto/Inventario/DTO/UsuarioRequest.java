
package com.reto.Inventario.DTO;

import java.io.Serializable;
import lombok.Data;
//Clase variada de la entidad usuario para insertar un usuario por parte del Administrador
@Data
public class UsuarioRequest implements Serializable{

    private String nombres;
    private String apellidos;
    private String cedula;
    private String mail;
}
