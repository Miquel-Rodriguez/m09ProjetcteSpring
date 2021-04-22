package com.example.projectespringbootsecurity.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secta {

    int id;
    String nom;
    String rector;
    String localitzacio;
    int numIntegrants;


}
