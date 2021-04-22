package com.example.projectespringbootsecurity.model.serveis;

import com.example.projectespringbootsecurity.model.entitats.Secta;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
@Service
public class ServeiSectas {
    private List<Secta> repositori = new ArrayList<>();
    public void afegir(Secta s) {
        repositori.add(s);
    }
    public List<Secta> llistat() {
        return repositori;
    }

    @PostConstruct
    public void init() {
        repositori.addAll(
                Arrays.asList(
                        new Secta(1,"Aure Sonaure", "Kedrick Bull", "Himàlaia", 453),
                        new Secta(2,"Black Rose", "Syli Conbout", "??????", 249),
                        new Secta(3,"AudSpe", "Carlos Roze", "Barcelona", 57)
                )
        );
    }

    public void eliminarPerid(int id){
        repositori.removeIf(sec -> sec.getId() == id);
    }

    public void substituirSecta(Secta newSecta){
        for(int i=0;i<repositori.size();i++){
            if(repositori.get(i).getId()==newSecta.getId()){
                repositori.add(i,newSecta);
            }
        }
    }

    public List<Secta> ordenarPerNom(){
        repositori.sort(Comparator.comparing(Secta::getNom));
        return repositori;
    }

    public List<Secta> ordenarPerId(){
        repositori.sort(Comparator.comparing(Secta::getId));
        return repositori;
    }

    public Secta consultaPerId(int id){
        for (Secta sec: repositori ) {
            if(sec.getId() == id){
                return sec;
            }
        }
        return null;
    }
}
