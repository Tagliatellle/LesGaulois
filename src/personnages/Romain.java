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
		int forceDebut = force;
		force -= forceCoup;
		assert forceEstToujoursPositive();
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert (forceDebut>force);
	}
	
	private boolean forceEstToujoursPositive() {
		return force>0;
	}
	
	
	public static void main(String[] args) {
		Romain bus = new Romain("Bus", 6);
		bus.prendreParole();
		bus.parler("hassoul");
		bus.recevoirCoup(8);
	}
}
