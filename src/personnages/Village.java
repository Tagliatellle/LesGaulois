package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMax];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef + "vivent les légendaires gaulois :");
		int i =0;
		while (i<nbVillageois) {
			System.out.println("- "+ trouverHabitant(i).getNom());
			i++;
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		
	

//		Gaulois gaulois = village.trouverHabitant(30); 
//		on a créé un tableau de 30 éléments donc de 0 à 29 
//		et on essaie d'accéder à un 31ème éléments "30"
		
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		il n'y a qu'un gaulois asterix situé à la première place (indice 0 et pas 1)
//		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}

}
