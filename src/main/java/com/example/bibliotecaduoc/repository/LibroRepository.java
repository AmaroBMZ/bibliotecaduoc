package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.Arrays;
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

        public void cargarLibrosFake() {
        listaLibros = new ArrayList<>(Arrays.asList(
        new Libro(1, "978-84-450-0066-3", "El Señor de los Anillos", "Minotauro", 1954, "J.R.R. Tolkien"),
        new Libro(2, "978-84-9759-220-8", "Cien años de soledad", "Sudamericana", 1967, "Gabriel García Márquez"),
        new Libro(3, "978-04-515-2493-5", "1984", "Secker & Warburg", 1949, "George Orwell"),
        new Libro(4, "978-84-206-3913-0", "El Aleph", "Alianza Editorial", 1949, "Jorge Luis Borges"),
        new Libro(5, "978-84-339-2044-7", "Seda", "Anagrama", 1996, "Alessandro Baricco"),
        new Libro(6, "978-01-404-4913-6", "Crimen y castigo", "The Russian Messenger", 1866, "Fiódor Dostoyevski"),
        new Libro(7, "978-84-233-4271-6", "La sombra del viento", "Planeta", 2001, "Carlos Ruiz Zafón"),
        new Libro(8, "978-06-182-6030-0", "El Hobbit", "George Allen & Unwin", 1937, "J.R.R. Tolkien"),
        new Libro(9, "978-84-990-8247-9", "Rayuela", "Editorial Sudamericana", 1963, "Julio Cortázar"),
        new Libro(10, "978-84-376-0494-7", "Don Quijote de la Mancha", "Francisco de Robles", 1605, "Miguel de Cervantes")
    ));
    }

        public Libro modificarLibro(int id,Libro libro) {
            Libro libroDestino=buscarId(id);
            if (libroDestino!=null){
                libroDestino.setAutor(libro.getAutor());
            libroDestino.setEditorial(libro.getEditorial());
            libroDestino.setFechaPublicacion(libro.getFechaPublicacion());
            libroDestino.setIsbn(libro.getIsbn());
            libroDestino.setTitulo(libro.getTitulo());
            return libroDestino;
            }
            return null;
        }


    public boolean eliminarLibro(int id){
        listaLibros.removeIf(b->b.getId()==id);
        return true;
    }

    public List<Libro> getMayores(int year) {
        List<Libro> mayores=new ArrayList<>();
        for (Libro libro : mayores) {
            if (libro.getFechaPublicacion()>=year){
                mayores.add(libro);
            }
        }
        return mayores;
    }

}

