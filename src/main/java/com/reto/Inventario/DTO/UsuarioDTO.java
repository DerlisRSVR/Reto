package com.reto.Inventario.DTO;


import lombok.Data;

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
