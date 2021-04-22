package com.example.projectespringbootsecurity.Controladors;

import com.example.projectespringbootsecurity.model.entitats.Secta;
import com.example.projectespringbootsecurity.model.entitats.Usuari;
import com.example.projectespringbootsecurity.model.serveis.ServeiSectas;
import com.example.projectespringbootsecurity.model.serveis.ServeiUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLogin {

    @Autowired
    private ServeiUsuaris servei;

    @GetMapping("/secret")
    public String secret() {
        return "secret";
    }

    @GetMapping("/topsecret")
    public String topsecret() {
        return "topsecret";
    }

    @GetMapping("/hola")
    public String hola() {
        return "hola";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("pero si por aquí");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @GetMapping("/user/new")
    public String afegirUsuari(Model m) {
        m.addAttribute("userForm", new Usuari());
        System.out.println("he llegado aquí");
        return "register";
    }

    @PostMapping("/user/new/submit")
    public String registerUserAccount(@ModelAttribute("userForm") Usuari user) {
        String s = servei.passwordEncoder().encode(user.getPassword());
        user.setPassword(s);
        servei.afegirUsuari(user);
        System.out.println("i tambien por queyfgfvdbgsfaewvdfgsewewr llegado aquí");
        return "redirect:/";
    }
}