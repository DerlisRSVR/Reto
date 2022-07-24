/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto.Inventario.Repository;

import com.reto.Inventario.Entities.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *Interface de VacunaRepo para usar los métodos de JpaRepository con la entidad Vacuna
 * @author steev
 */
@Repository
public interface VacunaRepo extends JpaRepository<Vacuna, Integer> {
    
}
