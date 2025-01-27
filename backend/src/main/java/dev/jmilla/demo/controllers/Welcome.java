package dev.jmilla.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Welcome {
	
    @GetMapping("/")
    public String saludador(Model model) {
    	// Clave y valor
    	model.addAttribute("nombreUsuario", "usuario desconocido");
    	model.addAttribute("mostrarLista", false); // No mostrar lista en la ruta "/"
        model.addAttribute("content", "landing");
        return "layout";
    }
    
    @GetMapping("/{miNombre}")
    public String saludador(@PathVariable String miNombre, Model model) {
    	// Clave y valor
    	model.addAttribute("nombreUsuario", miNombre);
    	model.addAttribute("mostrarLista", false); // No mostrar lista en la ruta "/"
        model.addAttribute("content", "landing");
        return "layout";
    }
    
    @GetMapping("/listar")
    public String listador(Model model) { 
        // Crear una lista de palabras
        List<String> palabras = List.of("Provide", "Legal", "Excusation", "And", "Sign", "Everything");
        
        // Pasar la lista al modelo
        model.addAttribute("palabras", palabras);
        model.addAttribute("nombreUsuario", "usuario desconocido");
        model.addAttribute("mostrarLista", true); // Mostrar lista en la ruta "/listar"
        model.addAttribute("content", "landing");
        return "layout";
    }

}
