
package com.reto.Inventario.Validators;

import com.reto.Inventario.DTO.UsuarioRequest;
import com.reto.Inventario.Exceptions.ApiUnprocessable;
import org.springframework.stereotype.Component;


@Component
public class UsuarioValidatorImpl implements UsuarioValidator{
//Función para Validar los campos de la inserción
    @Override
    public void validator(UsuarioRequest request) throws ApiUnprocessable {
        //Este if valida que los campos no estén vacíos
        if (request.getNombres()==null || request.getNombres().isEmpty() ||
                request.getApellidos()==null || request.getApellidos().isEmpty() ||
                request.getCedula()==null || request.getCedula().isEmpty() ||
                request.getMail()==null || request.getMail().isEmpty()
                ) {
            message("Todos los datos son obligatorios");
        }
              //Valida que la cédula sea correcta con el método validar cédula que está al final del este archivo 
        if (validarCedula(request.getCedula())==false) {
              message("La cédula debe tener 10 números");
        }
        //Valida que sólo tenga Carácteres y una Mayúscula en el nombre
         if (validarCaracteres(request.getNombres())==false) {
              message("Los nombres tienen que tener al menos una letra mayúscula y no deben contener caracteres especiales o números ");
        }
         //Valida que sólo tenga Carácteres y una Mayúscula en el apellido
          if (validarCaracteres(request.getApellidos())==false) {
              message("Los apellidos tienen que tener al menos una letra mayúscula y no deben contener caracteres especiales o números ");
        }
          //Valida que el correo sea valido
          if (validarMail(request.getMail())==false) {
              message("El correo electrónico no es valido");
        }
        
    }
    
    //Métodos para las validaciones usando Expresiones Regulares
    public static boolean validarCedula(String cedula){
    return cedula.matches("^[0-9]{10}$");
    }
    
     public static boolean validarCaracteres(String cadena){
    return cadena.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$");
    }
     
       public static boolean validarMail(String cadena){
    return cadena.matches("^(.+)@(.+)$");
    }

    
    private void message(String message) throws ApiUnprocessable{
    throw new ApiUnprocessable(message);
    }
    
}
