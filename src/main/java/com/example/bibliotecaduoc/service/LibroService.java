package com.example.bibliotecaduoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public Libro save(Libro lib){
        return libroRepository.guardar(lib); 
    }

    public List<Libro> readAll(){
        return libroRepository.obtenerLibros();
    }

    public Libro update(Libro lib){
        return libroRepository.actualizar(lib);
    }

    public void delete (int id){
        libroRepository.eliminar(id);
    }

    public Libro readId(int id){
        return libroRepository.buscarId(id);
    }

    public Libro readIsbn(String isbn){
        return libroRepository.buscarIsbn(isbn);
    }
}
