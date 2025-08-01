package com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.repositories;

import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.entities.BasicLibrary;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<BasicLibrary, Integer> {


}
