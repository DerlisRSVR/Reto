/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto.Inventario.Repository;

import com.reto.Inventario.Entities.Usuario;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steev
 */
@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {	
    public List<Usuario> getByestadoUsu(Integer estadoUsu);
}
