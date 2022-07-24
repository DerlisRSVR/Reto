package com.reto.Inventario.Utils;

import org.modelmapper.ModelMapper;

//Clase para usar ModelMapper y transformar entidades 
public class Mhelpers {
    public static ModelMapper modelMapper(){
    return new ModelMapper();
   }
}
