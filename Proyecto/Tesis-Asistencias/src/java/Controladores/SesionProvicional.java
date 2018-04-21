/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.HashMap;

/**
 *
 * @author Yasmin
 */
public class SesionProvicional {
    public HashMap<String, String> usuarios;

    public SesionProvicional() {
        usuarios = new HashMap<>();
        
        usuarios.put("Monica","1234");
        usuarios.put("Yasmin","1234");
    }
    
    public HashMap<String, String> getUsuarios() {
        return usuarios;
    }
}
