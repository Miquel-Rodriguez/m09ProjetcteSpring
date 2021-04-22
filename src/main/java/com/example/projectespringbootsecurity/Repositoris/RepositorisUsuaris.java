package com.example.projectespringbootsecurity.Repositoris;

import com.example.projectespringbootsecurity.model.entitats.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositorisUsuaris extends CrudRepository<Usuari, String> {
}
