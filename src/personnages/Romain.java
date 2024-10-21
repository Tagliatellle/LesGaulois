package personnages;

public class Romain {
	public static final int NB_EQUIPEMENTS=2;
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement[NB_EQUIPEMENTS];
	private int nbEquipements = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert forceEstToujoursPositive();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		int forceDebut = force;
		force -= forceCoup;
		assert forceEstToujoursPositive();
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		assert (forceDebut>force);
	}
	
	private boolean forceEstToujoursPositive() {
		return force>0;
	}
	
    public void sEquiper(Equipement equipement) {
        switch (nbEquipements) {
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            case 0:
                ajouterEquipement(equipement);
                break;
            default:
                System.out.println("Erreur : nombre d'équipements invalide.");
        }
    }
    
    private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipements] = equipement;
        nbEquipements++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }
	
	public static void main(String[] args) {
		Romain bus = new Romain("Bus", 6);
		bus.prendreParole();
		bus.parler("hassoul");
		bus.recevoirCoup(8);
		bus.sEquiper(Equipement.CASQUE);  
        bus.sEquiper(Equipement.CASQUE); 
        bus.sEquiper(Equipement.BOUCLIER); 
        bus.sEquiper(Equipement.CASQUE);
	}
}
