package net.ecoles.epsi.tepedelen.leo.ex2;

public class CompteCourant extends CompteBancaire{


    /**
     * decouvert : un découvert est autorisé seulement pour les comptes courants
     */
    private double decouvert;

    /**
     * @param solde
     * @param decouvert
     */
    public CompteCourant(double solde, double decouvert) throws IllegalArgumentException {
        super(solde);
        if (solde < decouvert){
            throw new IllegalArgumentException("Solde inférieur au découvert minimum");
        }
        if (decouvert > 0){
            throw new IllegalArgumentException("Le découvert autorisé ne peut pas être positif");
        }
        this.decouvert = decouvert;
    }

    /**
     * Retire un montant au solde
     *
     * @param montant
     */
    @Override
    public void debiterMontant(double montant) throws IllegalArgumentException {
        if (this.getSolde() - montant < this.decouvert){
            throw new IllegalArgumentException("Le motant à débiter ne peut pas faire dépasser le découvert");
        }
        super.debiterMontant(montant);
    }


    /**
     * Getter for decouvert
     *
     * @return the decouvert
     */
    public double getDecouvert() {
        return decouvert;
    }

    /**
     * Setter
     *
     * @param decouvert the decouvert to set
     */
    public void setDecouvert(double decouvert) throws IllegalArgumentException {
        if (decouvert > 0){
            throw new IllegalArgumentException("Le découvert autorisé ne peut pas être positif");
        }
        this.decouvert = decouvert;
    }

    /**
     * Setter
     *
     * @param solde the solde to set
     */
    @Override
    public void setSolde(double solde) throws IllegalArgumentException {
        if (solde < decouvert){
            throw new IllegalArgumentException("Solde inférieur au découvert minimum");
        }
        super.setSolde(solde);
    }

}
