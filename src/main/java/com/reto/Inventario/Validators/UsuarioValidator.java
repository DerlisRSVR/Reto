
package com.reto.Inventario.Validators;

import com.reto.Inventario.DTO.UsuarioRequest;
import com.reto.Inventario.Exceptions.ApiUnprocessable;
import org.springframework.stereotype.Service;
//Interface de Validar para ocultar los métodos del implement
@Service
public interface UsuarioValidator {
    void validator(UsuarioRequest request) throws ApiUnprocessable ;
}
