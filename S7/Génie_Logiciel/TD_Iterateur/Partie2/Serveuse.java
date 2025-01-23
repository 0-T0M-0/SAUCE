package version2;

import java.util.Iterator;


public class Serveuse {

	private MenuCreperie menuCreperie;
	private MenuCafeteria menuCafeteria;
	
	public Serveuse(MenuCreperie menuCreperie, MenuCafeteria menuCafeteria) {
		this.menuCreperie = menuCreperie;
		this.menuCafeteria = menuCafeteria;
	}
	
	public void afficherMenu() {
		Iterateur<Plat> iterateurCreperie = menuCreperie.creerIterateur();
		IterateurMenuCafeteria iterateurCafet = menuCafeteria.creerIterateur();
		
		System.out.println("-- Menu Creperie --");
		afficherMenu(iterateurCreperie);
		
		System.out.println("-- Menu Cafeteria --");
		afficherMenu(iterateurCafet);
		
	}
	
	public void afficherMenu(Iterateur<Plat> iterator) {
		while (iterator.encore()) {
			Plat plat = iterator.suivant();
			System.out.print(plat.getNom() + " -- ");
			System.out.print(plat.getPrix() + "� -- ");
			System.out.println(plat.getDescription());
		}
	}
}
