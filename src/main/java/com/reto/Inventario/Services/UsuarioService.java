
package com.reto.Inventario.Services;

import com.reto.Inventario.DTO.UsuarioDTO;
import com.reto.Inventario.DTO.UsuarioEditRequest;
import com.reto.Inventario.DTO.UsuarioRequest;
import com.reto.Inventario.Entities.Usuario;
import com.reto.Inventario.Repository.UsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Interface para delimitar la llegada directa a UsuarioImplements
@Service
public interface UsuarioService {
    List<UsuarioDTO> findAll();
    
    void insertar(UsuarioRequest usu);
    
    void editar(UsuarioEditRequest usu,int codigo);
    
      void eliminar(int codigo);
    
    
}
