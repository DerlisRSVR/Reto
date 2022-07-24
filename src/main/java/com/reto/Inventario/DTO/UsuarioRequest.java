
package com.reto.Inventario.DTO;

import java.io.Serializable;
import lombok.Data;

@Data
public class UsuarioRequest implements Serializable{

    private String nombres;
    private String apellidos;
    private String cedula;
    private String mail;
}
