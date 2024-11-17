package com.proyectofinal.Biblioteca.Service;

import com.proyectofinal.Biblioteca.Model.Libro;
import com.proyectofinal.Biblioteca.Repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepositorio libroRepositorio;

    public Libro crearLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepositorio.findAll();
    }

    public Optional<Libro> obtenerLibroPorId(Integer id) {
        return libroRepositorio.findById(id);
    }

    public Libro actualizarLibro(Integer id, Libro libroActualizado) {
        return libroRepositorio.findById(id)
                .map(libro -> {
                    libro.setTitulo(libroActualizado.getTitulo());
                    libro.setAutor(libroActualizado.getAutor());
                    libro.setAñoPublicacion(libroActualizado.getAñoPublicacion());
                    return libroRepositorio.save(libro);
                }).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    public void eliminarLibro(Integer id) {
        libroRepositorio.deleteById(id);
    }
}
