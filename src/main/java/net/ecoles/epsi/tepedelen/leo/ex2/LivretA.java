package net.ecoles.epsi.tepedelen.leo.ex2;

public class LivretA extends CompteBancaire {

    private static final int SOLDE_MINIMUM = 0;

    /**
     * tauxRemuneration : taux de rémunération dans le cas d'un livret A
     */
    private double tauxRemuneration;

    /**
     * Ce constructeur est utilisé pour créer un compte de type Livret A
     *
     * @param solde            représente le solde du compte
     * @param tauxRemuneration représente le taux de rémunération du livret A
     */
    public LivretA(double solde, double tauxRemuneration) throws IllegalArgumentException {
        super(solde);
        if (solde < 0){
            throw new IllegalArgumentException("Le solde d'un livret A doit être nul ou positif");
        }
        if (tauxRemuneration <= 0){
            throw new IllegalArgumentException("Le taux de rémunération d'un livret A doit être positif");
        }
        this.tauxRemuneration = tauxRemuneration;
    }

    /**
     * Retire un montant au solde
     *
     * @param montant
     */
    @Override
    public void debiterMontant(double montant) throws IllegalArgumentException {
        if (this.getSolde() - montant < SOLDE_MINIMUM){
            throw new IllegalArgumentException("Le motant à débiter ne peut pas faire dépasser le solde minimum : " + SOLDE_MINIMUM);
        }
        super.debiterMontant(montant);
    }

    /**
     * Applique la rémunération annuelle au solde
     */
    public void appliquerRemuAnnuelle() {
        try {
            this.setSolde(this.getSolde() + this.getSolde() * tauxRemuneration / 100);
        } catch (IllegalArgumentException iaex){
            System.out.println("Erreur appliquerRemuAnnuelle (possible que si le solde minimum est négatif) : " + iaex.getMessage());
        }
    }

    /**
     * Getter for tauxRemuneration
     *
     * @return the tauxRemuneration
     */
    public double getTauxRemuneration() {
        return tauxRemuneration;
    }

    /**
     * Setter
     *
     * @param tauxRemuneration the tauxRemuneration to set
     */
    public void setTauxRemuneration(double tauxRemuneration) {
        this.tauxRemuneration = tauxRemuneration;
    }

    /**
     * Setter
     *
     * @param solde the solde to set
     */
    @Override
    public void setSolde(double solde) throws IllegalArgumentException {
        if (solde < SOLDE_MINIMUM){
            throw new IllegalArgumentException("Solde inférieur au solde minimum : " + SOLDE_MINIMUM);
        }
        super.setSolde(solde);
    }


}
