package com.reto.Inventario.DTO;


import lombok.Data;
//Clase variada de la entidad Usuario para mostrar sólo los datos necesarios excluyendo campos como la clave y estado del usuario
@Data
public class UsuarioDTO {
       private String codigo;
   private String nombres;
      private String apellidos;
         private String cedula;
    private String mail;
      private String estadoVacunacion;
      private String nombreVacuna;
       private String fechaVacunacion;
}
