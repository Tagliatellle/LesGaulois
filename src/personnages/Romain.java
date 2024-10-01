package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert forceEstToujoursPositive();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceEstToujoursPositive();
		int forceDebut = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forceADiminue(forceDebut);
	}
	
	private boolean forceEstToujoursPositive() {
		return force>0;
	}
	
	private boolean forceADiminue(int forceDepart) {
		return forceDepart>force;
	}
	
	public static void main(String[] args) {
		Romain bus = new Romain("Bus", 6);
		bus.prendreParole();
		bus.parler("hassoul");
		bus.recevoirCoup(8);
	}
}
