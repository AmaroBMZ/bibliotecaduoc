package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/api/v1/libros80.89")

public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.readAll();
    }
    

    @PostMapping
    public Libro agregaLibro(@RequestBody Libro libro) {
        //TODO: process POST request
        libroService.save(libro);
        return libro;
    }
    

    @GetMapping("{id}")
    public Libro buscaLibro(@PathVariable int id) {
        return libroService.readId(id);
    }
    

    @GetMapping("seed")
    public String getSeed() {
        libroService.datosFake();
        return "Datos Cargados";
    }
    

    @GetMapping("isbn/{isbn}")
    public Libro getIsbn(@RequestParam String isbn) {
        return libroService.readIsbn(isbn);
    }
    

    @PutMapping("{id}")
    public Libro putLibro(@PathVariable int id, @RequestBody Libro libro) {
        
        return libroService.updateLibro(id, libro);
    }

    @DeleteMapping("eliminar/{id}")
    public String deleteLibro(@PathVariable int id){
        libroService.deleteLibro(id);
        return "libro eliminado";
    }


    @GetMapping("mayores/{year}")
    public List<Libro> getlibroMayores(@PathVariable int year) {
        return libroService.getMayores(year);
    }
    
}
