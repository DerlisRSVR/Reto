package com.reto.Inventario.Implements;

import com.reto.Inventario.DTO.UsuarioDTO;
import com.reto.Inventario.DTO.UsuarioEditRequest;
import com.reto.Inventario.DTO.UsuarioRequest;
import com.reto.Inventario.Entities.Usuario;
import com.reto.Inventario.Repository.UsuarioRepo;
import com.reto.Inventario.Services.UsuarioService;
import com.reto.Inventario.Utils.Mhelpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioImplement implements UsuarioService {

    @Autowired
    private UsuarioRepo usurepo;

    @Override
    public List<UsuarioDTO> findAll() {
        List<UsuarioDTO> usuDTO = new ArrayList<>();

        Iterable<Usuario> usu = usurepo.getByestadoUsu(1);
        for (Usuario vacuna1 : usu) {
            UsuarioDTO usuarioDTO = Mhelpers.modelMapper().map(vacuna1, UsuarioDTO.class);
            usuDTO.add(usuarioDTO);
        }
        return usuDTO;
    }

    @Override
    public void insertar(UsuarioRequest usu) {
      Usuario user=Mhelpers.modelMapper().map(usu, Usuario.class);
      this.usurepo.save(user);
    }
    
      @Override
    public void editar(UsuarioEditRequest usu,int codigo) {
      Optional<Usuario> users=this.usurepo.findById(codigo);
      Usuario user=users.get();
      user.setNombres(usu.getNombres());
      user.setApellidos(usu.getApellidos());
      user.setCedula(usu.getCedula());
      user.setDireccion(usu.getDireccion());
      user.setEstadoVacunacion(usu.getEstadoVacunacion());
      user.setFechaNacimiento(usu.getFechaNacimiento());
      user.setFechaVacunacion(usu.getFechaVacunacion());
      user.setMail(usu.getMail());
      user.setNumDosis(usu.getNumDosis());
      user.setTeléfono(usu.getTeléfono());
      user.setTipoVacuna(usu.getTipoVacuna());
      
      
      this.usurepo.save(user);
    }
    
    @Override
    public void eliminar(int codigo) {
     Optional<Usuario> users=this.usurepo.findById(codigo);
    
       Usuario user=users.get();
      user.setEstadoUsu(0);
      
        this.usurepo.save(user);
    }
    

    private UsuarioDTO convertToUsuarioDTO(final Usuario usuario) {
        return Mhelpers.modelMapper().map(usuario, UsuarioDTO.class);
    }
}
