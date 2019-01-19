package fr.dauphine;


import org.springframework.data.jpa.repository.JpaRepository;

// Creation du JPA Repository basé sur Spring Data
public interface CompteRepository extends JpaRepository<Compte, Long> {
    Compte findByTypedecompte(String typedecompte);
    Compte findById(long id);
}