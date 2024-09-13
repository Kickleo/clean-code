package net.ecoles.epsi.tepedelen.leo.ex5;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {

    private List<Caisse> caisses;

    public Inventaire() {
        caisses = new ArrayList<>();
        caisses.add(new Caisse("Petits objets", 0, 5));
        caisses.add(new Caisse("Moyens objets", 5, 20));
        caisses.add(new Caisse("Grands objets", 20, Integer.MAX_VALUE));
    }

    public void addItem(Item item) {

        for (Caisse caisse : caisses) {
            if (caisse.peutAccepter(item)) {
                caisse.ajouterItem(item);
                return;
            }
        }
    }

    public int taille() {

        int total = 0;
        for (Caisse caisse : caisses) {
            total += caisse.getItems().size();
        }
        return total;
    }
}
