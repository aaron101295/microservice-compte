package fr.dauphine;


import fr.dauphine.Compte;
import fr.dauphine.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;


@RestController
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/all")
    public List<Compte> retrouveTousLesComptes() {

        List<Compte> compte = compteRepository.findAll();
        return compte;
    }

    @GetMapping("/byId/{id}")
    public Compte retrouveParId(@PathVariable long id) {
        Compte compte = compteRepository.findById(id);
        return compte;

    }


    @DeleteMapping("/supprimer/{id}")
    public void supprimerCompte(@PathVariable long id) {
        compteRepository.deleteById(id);
    }

    @PostMapping("/creer")
    public ResponseEntity<Object> creerCompte(@RequestBody Compte compte) {
        Compte compteCree = compteRepository.save(compte);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(compteCree.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/MAJCompte/{id}")
    public ResponseEntity<Object> majCompte(@RequestBody Compte compte, @PathVariable long id) {

        Compte compte1 = compteRepository.findById(id);



        compte.setId(id);

        compteRepository.save(compte);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/retirer/{id}")
    public ResponseEntity<Object> retirerArgent(@PathVariable long id,
                                                @RequestParam(value = "montant", required = false) Double montant){
        Compte compte = compteRepository.findById(id);

        compte.setSolde(compte.getSolde() - montant);

        compteRepository.save(compte);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/deposer/{id}")
    public ResponseEntity<Object> deposerArgent(@PathVariable long id,
                                                @RequestParam(value = "montant", required = false) Double montant){
        Compte compte = compteRepository.findById(id);

        compte.setSolde(compte.getSolde() + montant);

        compteRepository.save(compte);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/virement/{id1}/{id2}")
    public ResponseEntity<Object> faireUnVirement (@PathVariable long id1,
                                                   @PathVariable long id2,
                                                @RequestParam(value = "montant", required = false) Double montant){

        Compte compte1 = compteRepository.findById(id1);
        Compte compte2 = compteRepository.findById(id2);
        compte1.setSolde(compte1.getSolde() - montant);
        compte2.setSolde(compte2.getSolde() + montant);


        compteRepository.save(compte1);
        compteRepository.save(compte2);

        return ResponseEntity.noContent().build();
    }




}

