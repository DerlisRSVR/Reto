
package com.reto.Inventario.Validators;

import com.reto.Inventario.DTO.UsuarioRequest;
import com.reto.Inventario.Exceptions.ApiUnprocessable;
import org.springframework.stereotype.Component;


@Component
public class UsuarioValidatorImpl implements UsuarioValidator{

    @Override
    public void validator(UsuarioRequest request) throws ApiUnprocessable {
        if (request.getNombres()==null || request.getNombres().isEmpty() ||
                request.getApellidos()==null || request.getApellidos().isEmpty() ||
                request.getCedula()==null || request.getCedula().isEmpty() ||
                request.getMail()==null || request.getMail().isEmpty()
                ) {
            message("Todos los datos son obligatorios");
        }
              
        if (validarCedula(request.getCedula())==false) {
              message("La cédula debe tener 10 números");
        }
         if (validarCaracteres(request.getNombres())==false) {
              message("Los nombres tienen que tener al menos una letra mayúscula y no deben contener caracteres especiales o números ");
        }
          if (validarCaracteres(request.getApellidos())==false) {
              message("Los apellidos tienen que tener al menos una letra mayúscula y no deben contener caracteres especiales o números ");
        }
          if (validarMail(request.getMail())==false) {
              message("El correo electrónico no es valido");
        }
        
    }
    
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
