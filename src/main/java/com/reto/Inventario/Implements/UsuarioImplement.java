package com.reto.Inventario.Implements;

import com.reto.Inventario.DTO.UsuarioDTO;
import com.reto.Inventario.DTO.UsuarioEditRequest;
import com.reto.Inventario.DTO.UsuarioRequest;
import com.reto.Inventario.Entities.Usuario;
import com.reto.Inventario.Entities.Vacuna;
import com.reto.Inventario.Repository.UsuarioRepo;
import com.reto.Inventario.Repository.VacunaRepo;
import com.reto.Inventario.Services.UsuarioService;
import com.reto.Inventario.Utils.Mhelpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioImplement implements UsuarioService {

    //Instancia de UsuarioRepo
    @Autowired
    private UsuarioRepo usurepo;
    //Instancia de VacunaRepo
    @Autowired
    private VacunaRepo vacunarepo;

    //Método para mostrar Usuarios
    @Override
    public List<UsuarioDTO> findAll() {
        //Declara lista del tipo UsuarioDTO
        List<UsuarioDTO> usuDTO = new ArrayList<>();
        //Obtención del objeto de tipo Usuario con estadoUsu 1, que se refiere a los usuarios activos para realizar el borrado lógico
        Iterable<Usuario> usu = usurepo.getByestadoUsu(1);
        //Transformación del Objeto de tipo Usuario a UsuarioDTO
        for (Usuario vacuna1 : usu) {
            UsuarioDTO usuarioDTO = Mhelpers.modelMapper().map(vacuna1, UsuarioDTO.class);
            usuDTO.add(usuarioDTO);
        }
        //retorna una lista del Tipo UsuarioDTO
        return usuDTO;
    }
        //Método Insertar

    @Override
    public void insertar(UsuarioRequest usu) {
        //Transformación del Usuario tipo UsuarioRequest a Usuario
        Usuario user = Mhelpers.modelMapper().map(usu, Usuario.class);
        //Inserción de los datos
        this.usurepo.save(user);
    }

        //Método editar
    @Override
    public void editar(UsuarioEditRequest usu, int codigo) {
        //Obtención del objeto Vacuna de acuerdo al Id 
        Optional<Vacuna> vacuna = this.vacunarepo.findById(usu.getTipoVacuna());
        //Guardar del tipo Optional<Vacuna> a Vacuna
        Vacuna vac = vacuna.get();
        //Obtención del Usuario a editar
        Optional<Usuario> users = this.usurepo.findById(codigo);
         //Guardar del tipo Optional<Usuario> a usuario
        Usuario user = users.get();
//Asignar los nuevos valores al Objeto Usuario
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
        user.setTipoVacuna(vac);
//El método save también edita cuando se manda el código de la entidad
        this.usurepo.save(user);
    }
//Método Eliminar
    @Override
    public void eliminar(int codigo) {
     //Obtención del Usuario a eliminar lógicamente 
        Optional<Usuario> users = this.usurepo.findById(codigo);

        Usuario user = users.get();
        //Asigna a estadoUsu un 0 para que no aparezca en el listar pero en l abase de datos no se eliminará
        user.setEstadoUsu(0);

        this.usurepo.save(user);
    }
//Método para convertir del tipo Usuario a UsuarioDTO usnado la librería ModelMapper
    private UsuarioDTO convertToUsuarioDTO(final Usuario usuario) {
        return Mhelpers.modelMapper().map(usuario, UsuarioDTO.class);
    }
}
