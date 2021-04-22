package com.example.projectespringbootsecurity.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuari {
    @Id
    private String username;
    private String password;
    private String rol;

    public Usuari(String username, String password) {
        this.username = username;
        this.password = password;
        rol = "user";
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
