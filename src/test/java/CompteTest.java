import fr.dauphine.Compte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.junit.Assert;
import org.junit.Test;

public class CompteTest {

    @Test
    public void table() {
        // setup
        Table t
                = ReflectTool.getClassAnnotation(Compte.class, Table.class);
        // assert
        Assert.assertEquals("compte_bancaire", t.name());
    }


    @Test
    public void iban() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Compte.class, "getIban", Column.class);
        // assert
        Assert.assertEquals("iban", c.name());
    }

    @Test
    public void typeDeCompte() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Compte.class, "getTypedecompte", Column.class);
        // assert
        Assert.assertEquals("typedecompte", c.name());
    }

    @Test
    public void frais() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Compte.class, "getFrais", Column.class);
        // assert
        Assert.assertEquals("frais", c.name());
    }

    @Test
    public void interet() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Compte.class, "getInteret", Column.class);
        // assert
        Assert.assertEquals("interet", c.name());
    }

    @Test
    public void solde() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Compte.class, "getSolde", Column.class);
        // assert
        Assert.assertEquals("solde", c.name());
    }
}