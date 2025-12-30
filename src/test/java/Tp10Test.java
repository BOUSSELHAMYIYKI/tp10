import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Tp10Test {

    @Test
    void testSommeTableauNormal() {
        int[] valeurs = {1, 2, 3, 4, 5};
        assertEquals(15, tp10.somme(valeurs), "La somme devrait être 15");
    }

    @Test
    void testSommeTableauVide() {
        int[] valeurs = {};
        assertEquals(0, tp10.somme(valeurs), "La somme d'un tableau vide devrait être 0");
    }

    @Test
    void testSommeAvecNegatifs() {
        int[] valeurs = {-5, 5, -10};
        assertEquals(-10, tp10.somme(valeurs), "La somme devrait être -10");
    }

    @Test
    void testSommeUnSeulElement() {
        int[] valeurs = {42};
        assertEquals(42, tp10.somme(valeurs), "La somme devrait être 42");
    }
}
