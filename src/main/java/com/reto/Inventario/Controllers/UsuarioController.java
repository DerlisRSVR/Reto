
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
    //Instancio la interface de Usuario para obtener los métodos
    @Autowired
    private UsuarioService  ususervice;
    
    //Instancio la clase Validator para verificar las restricciones de los datos
    @Autowired
    private UsuarioValidatorImpl usuValidator;
    
    //Declaro el método http Get para mostrar los usuarios. Se usa UsuarioDTO para ocultar datos innecesarios
    @GetMapping
    public List<UsuarioDTO> listar(){
    return ususervice.findAll();
    }
    //Declaro método http Post para el método insertar 
    @PostMapping  //Método Insertar con Usuario de tipo UsuarioRequest para obtener sólo los métodos necesarios
    public ResponseEntity<Object> insertar (@RequestBody UsuarioRequest usu) throws ApiUnprocessable{
        //Se verifica que el usuario esté correcto por las validaciones
        this.usuValidator.validator(usu);
        //Se llama al método insertar y se le pasa el objeto Usuario en caso de que pase las Validaciones
      this.ususervice.insertar(usu);
      
      return ResponseEntity.ok(Boolean.TRUE);
    }
    //Se declara el método http para editar
     @PutMapping //Método editar obtiene código y usuario
    public ResponseEntity<Object> editar (@RequestBody UsuarioEditRequest usu,@RequestParam  int codigo) {
        //Se llama al método editar
       this.ususervice.editar(usu, codigo);
      return ResponseEntity.ok(Boolean.TRUE);
    }
    
     @PutMapping(value = "/Eliminar") //Método Post para eliminado lógico, se obtiene código 
    public ResponseEntity<Object> eliminar (@RequestParam  int codigo) {
        //Se llama al método eliminar
       this.ususervice.eliminar(codigo);
      return ResponseEntity.ok(Boolean.TRUE);
    }
}
