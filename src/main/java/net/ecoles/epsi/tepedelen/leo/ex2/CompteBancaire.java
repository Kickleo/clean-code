package net.ecoles.epsi.tepedelen.leo.ex2;

/**
 * Représente un compte bancaire de type compte courante (type=CC) ou livret A (type=LA)
 */
public abstract class CompteBancaire {

    /**
     * solde : solde du compte
     */
    private double solde;

    /**
     * @param solde
     */
    public CompteBancaire(double solde) {
        super();
        this.solde = solde;
    }

    /**
     * Ajoute un montant au solde
     *
     * @param montant
     */
    public void ajouterMontant(double montant) {
        this.solde += montant;
    }


    public void debiterMontant(double montant) {
        this.solde = solde - montant;
    }


    /**
     * Getter for solde
     *
     * @return the solde
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Setter
     *
     * @param solde the solde to set
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

}