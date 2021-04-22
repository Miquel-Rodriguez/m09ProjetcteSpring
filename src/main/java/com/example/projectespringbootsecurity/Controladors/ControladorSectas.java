package com.example.projectespringbootsecurity.Controladors;


import com.example.projectespringbootsecurity.model.entitats.Secta;
import com.example.projectespringbootsecurity.model.entitats.Usuari;
import com.example.projectespringbootsecurity.model.serveis.ServeiSectas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorSectas {
    @Autowired
    private ServeiSectas servei;

    @GetMapping("/sectes/list")
    public String llistar(Model m){
        m.addAttribute("llistaSectes",servei.llista());
        return "llistat";
    }

    @GetMapping("/sectes/new")
    public String afegirSecta(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
       m.addAttribute("sectaForm",new Secta());
        return "afegir";
    }

    @PostMapping("sectes/new/submit")
    public String afegirSubmit(@ModelAttribute("sectaForm") Secta sec){
      servei.afegir(sec);
      return "redirect:/sectes/list";
    }



//    @PostMapping( "/sectes/edit/submit")
//    public String subs (@ModelAttribute("sectaForm") Secta sec){
//        servei.substituirSecta(sec);
//        return "redirect:/sectes/list";
//    }


    @GetMapping("/sectes/eliminar")
    public String Exercici1m(@RequestParam("nom") String n){
        servei.eliminarPerid(n);
        return "redirect:/sectes/list";
    }

//    @GetMapping("/ordenar/nom")
//    public String ordenarNom(){
//        servei.ordenarPerNom();
//        return "redirect:/sectes/list";
//    }



    @RequestMapping( value ="/sectes/{secta}", method = RequestMethod.POST)
    public String updateSecta(@PathVariable("secta") Secta secta, Model m){
        System.out.println("he arribat");
        m.addAttribute("Secta",secta);

        return "/afegir";
    }

//    @PostMapping("/updateSecta")
//    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
//    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
//    public String updateAnimalpost(@ModelAttribute("Secta") Secta sec){
//        servei.substituirSecta(sec);
//        return "redirect:/";
//
//    }

}
