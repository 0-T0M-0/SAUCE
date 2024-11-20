package version1;

public class Serveuse {

	private MenuCreperie menuCreperie;
	private MenuCafeteria menuCafeteria;
	
	public Serveuse(MenuCreperie menuCreperie, MenuCafeteria menuCafeteria) {
		this.menuCreperie = menuCreperie;
		this.menuCafeteria = menuCafeteria;
	}
	
	public void afficherMenu() {
		System.out.println("-- Menu Creperie --");
		
        for (int i = 0; i < menuCreperie.getPlats().size(); i++) {
            System.out.println(menuCreperie.getPlats().get(i).getNom()+ menuCreperie.getPlats().get(i).getDescription()+ menuCreperie.getPlats().get(i).isVegetarien() +menuCreperie.getPlats().get(i).getPrix()); // Affiche le i-ème plat
        }
		System.out.println("-- Menu Cafeteria --");
		for (int i = 0; menuCafeteria.getPlats()[i]!=null; i++) {
    		System.out.println(menuCafeteria.getPlats()[i].getNom() + menuCafeteria.getPlats()[i].getDescription()+ menuCafeteria.getPlats()[i].isVegetarien() +menuCafeteria.getPlats()[i].getPrix());
        }
		
		menuCafeteria.getPlats();
	}
	
}
