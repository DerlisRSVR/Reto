/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto.Inventario.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author steev
 */

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception{
     public ApiUnauthorized(String message){
    super(message);
    }
}
