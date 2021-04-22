package com.example.projectespringbootsecurity.model.serveis;

import com.example.projectespringbootsecurity.Repositoris.RepositoriSectes;
import com.example.projectespringbootsecurity.model.entitats.Secta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ServeiSectas {
    @Autowired
    private RepositoriSectes repositori;



    @PostConstruct
    public void init() {
        repositori.save(new Secta(1,"Aure Sonaure", "Kedrick Bull", "Himàlaia", 453));
        repositori.save(new Secta(2,"Black Rose", "Syli Conbout", "??????", 249));
        repositori.save(new Secta(3,"AudSpe", "Carlos Roze", "Barcelona", 57));
    }

    public void eliminarPerid(String nom){
        repositori.deleteById(nom);
    }

    public Iterable<Secta> llista(){
        return repositori.findAll();
    }

//    public void substituirSecta(Secta newSecta){
//        for(int i=0;i<repositori.size();i++){
//            if(repositori.get(i).getId()==newSecta.getId()){
//                repositori.add(i,newSecta);
//            }
//        }
//    }

//    public List<Secta> ordenarPerNom(){
//        repositori.sort(Comparator.comparing(Secta::getNom));
//        return repositori;
//    }
//
//    public List<Secta> ordenarPerId(){
//        repositori.sort(Comparator.comparing(Secta::getId));
//        return repositori;
//    }

    public Secta consultaPerId(String username){
        return repositori.findById(username).orElse(null);

    }

    public void afegir(Secta sec){
        repositori.save(sec);
    }
}
