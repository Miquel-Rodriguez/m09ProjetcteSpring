package com.example.projectespringbootsecurity.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Secta {
    int id;
    @Id
    String nom;
    String rector;
    String localitzacio;
    int numIntegrants;


}
