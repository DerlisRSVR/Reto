
package com.reto.Inventario.Validators;

import com.reto.Inventario.DTO.UsuarioRequest;
import com.reto.Inventario.Exceptions.ApiUnprocessable;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioValidator {
    void validator(UsuarioRequest request) throws ApiUnprocessable ;
}
