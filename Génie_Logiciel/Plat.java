package version4;

public class Plat {
	
	private String nom;
	private String description;
	private boolean vegetarien;
	private double prix;
	
	public Plat(String nom, String description, boolean vegetarien, double prix) {
		this.nom  = nom;
		this.description = description;
		this.vegetarien = vegetarien;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}

	public boolean isVegetarien() {
		return vegetarien;
	}

	public double getPrix() {
		return prix;
	}
	
}
