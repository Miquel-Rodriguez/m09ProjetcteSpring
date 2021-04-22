package com.example.projectespringbootsecurity.model.serveis;

import com.example.projectespringbootsecurity.Repositoris.RepositorisUsuaris;
import com.example.projectespringbootsecurity.model.entitats.Secta;
import com.example.projectespringbootsecurity.model.entitats.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiUsuaris {
    @Autowired
    private RepositorisUsuaris repositori;

    public Usuari consultaPerId(String username){
        return repositori.findById(username).orElse(null);

    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostConstruct
    public void init() {
        repositori.save(new Usuari("user1", passwordEncoder().encode("1"), "admin"));
        repositori.save(new Usuari("user2", passwordEncoder().encode("2"), "user"));
        repositori.save(new Usuari("user3", passwordEncoder().encode("3"), "user"));

    }


    public void afegirUsuari(Usuari user){
            repositori.save(user);
    }
}

