package version2;

public class Plat {
	
	// Attributs
	private String nom;
	private String description;
	private boolean vegetarien;
	private double prix;
	
	
	// Méthodes
	// Constructeur
	public Plat(String nom, String description, boolean vegetarien, double prix) {
		super();
		this.nom = nom;
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
	public boolean estVegetarien() {
		return vegetarien;
	}
	public double getPrix() {
		return prix;
	}
}
