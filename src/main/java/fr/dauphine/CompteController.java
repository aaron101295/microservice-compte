package fr.dauphine;


import fr.dauphine.Compte;
import fr.dauphine.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


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
        Optional<Compte> compte = compteRepository.findById(id);
        return compte.get();

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

        Optional<Compte> compteOptional = compteRepository.findById(id);

        if (!compteOptional.isPresent())
            return ResponseEntity.notFound().build();

        compte.setId(id);

        compteRepository.save(compte);

        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value="/view",method = {RequestMethod.GET})
    public ModelAndView getAccountForDemo() {

        ModelAndView mav = new ModelAndView("compte/afficherCompte");

        List<Compte> compte =  this.compteRepository.findAll();
        mav.addObject("compte", compte);

        System.out.println(compte.toString());
        return mav;
    }

    }

