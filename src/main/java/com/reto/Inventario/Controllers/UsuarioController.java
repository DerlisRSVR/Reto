
package com.reto.Inventario.Controllers;

import com.reto.Inventario.DTO.UsuarioDTO;
import com.reto.Inventario.DTO.UsuarioEditRequest;
import com.reto.Inventario.DTO.UsuarioRequest;
import com.reto.Inventario.Entities.Usuario;
import com.reto.Inventario.Exceptions.ApiUnprocessable;
import com.reto.Inventario.Services.UsuarioService;
import com.reto.Inventario.Validators.UsuarioValidatorImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService  ususervice;
    
    @Autowired
    private UsuarioValidatorImpl usuValidator;
    
    @GetMapping
    public List<UsuarioDTO> listar(){
    return ususervice.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Object> insertar (@RequestBody UsuarioRequest usu) throws ApiUnprocessable{
        
        this.usuValidator.validator(usu);
      this.ususervice.insertar(usu);
      return ResponseEntity.ok(Boolean.TRUE);
    }
    
     @PutMapping
    public ResponseEntity<Object> editar (@RequestBody UsuarioEditRequest usu,@RequestParam  int codigo) {
        
       this.ususervice.editar(usu, codigo);
      return ResponseEntity.ok(Boolean.TRUE);
    }
    
     @PutMapping(value = "/Eliminar")
    public ResponseEntity<Object> eliminar (@RequestParam  int codigo) {
        
       this.ususervice.eliminar(codigo);
      return ResponseEntity.ok(Boolean.TRUE);
    }
}
