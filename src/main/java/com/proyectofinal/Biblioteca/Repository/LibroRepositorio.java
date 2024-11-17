package com.proyectofinal.Biblioteca.Repository;

import com.proyectofinal.Biblioteca.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
}
