import fr.dauphine.Compte;
import fr.dauphine.CompteController;
import fr.dauphine.CompteRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


public class ControllerTest {

/*        @MockBean
        private CompteRepository compteRepository;

    @Before
    public void setUp() {
        Compte compte = new Compte("toto", "courant",1.0,"gratuit",2.0);
        System.out.println("1");
        Mockito.when(compteRepository.findByTypedecompte(compte.getTypedecompte()))
                .thenReturn(compte);
        System.out.println("2");
    }

        @Test
        public void whenValidName_thenEmployeeShouldBeFound() {
            String typeDeCompte = "courant";
            System.out.println("3");
            Compte found = compteRepository.findByTypedecompte(typeDeCompte);
            System.out.println("4");
            assertThat(found.getTypedecompte())
                    .isEqualTo(typeDeCompte);
            System.out.println("5");
        }*/
}
