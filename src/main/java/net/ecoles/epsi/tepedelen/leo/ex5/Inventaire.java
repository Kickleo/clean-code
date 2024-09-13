package net.ecoles.epsi.tepedelen.leo.ex5;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {

    private List<Caisse> caisses;

    public Inventaire() {
        caisses = new ArrayList<>();
        caisses.add(new Caisse("Petits objets"));
        caisses.add(new Caisse("Moyens objets"));
        caisses.add(new Caisse("Grands objets"));
    }

    public void addItem(Item item) {

        //TODO Faites évoluer ce code (idée: c'est le caisse qui doit "savoir" si elle peut accepter un objet ou non)
        if (item.getPoids() < 5) {
            caisses.get(0).getItems().add(item);
        }
        if (item.getPoids() >= 5 && item.getPoids() <= 20) {
            caisses.get(1).getItems().add(item);
        }
        if (item.getPoids() >= 20) {
            caisses.get(2).getItems().add(item);
        }
    }

    public int taille() {

        //TODO faites évoluer ce code.
        return caisses.get(0).getItems().size() + caisses.get(1).getItems().size() + caisses.get(2).getItems().size();
    }
}
