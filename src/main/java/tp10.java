public class tp10 {

    // Fonction qui calcule la somme des éléments d'un tableau
    public static int somme(int[] nombres) {
        int total = 0;
        for (int n : nombres) {
            total += n;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] valeurs = {1, 2, 3, 4, 5};
        System.out.println("La somme est : " + somme(valeurs));
    }
}
