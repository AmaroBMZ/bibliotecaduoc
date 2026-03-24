package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    public Libro buscarId(int id){
        for (Libro libro:listaLibros){
            if (libro.getId()==id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarIsbn(String isbn){
        for (Libro libro:listaLibros){
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        Libro libroBuscado=buscarId(lib.getId());
        if(libroBuscado!=null){
            libroBuscado.setIsbn(lib.getIsbn());
            libroBuscado.setAutor(lib.getAutor());
            libroBuscado.setEditorial(lib.getEditorial());
            libroBuscado.setFechaPublicacion(lib.getFechaPublicacion());
            libroBuscado.setTitulo(lib.getTitulo());
            return libroBuscado;
        }
        return null;
    }

    public void eliminar(int id){
        listaLibros.removeIf(lib->lib.getId()==id);
    }
}

