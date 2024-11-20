package version2;


public class IterateurMenuCafeteria implements Iterateur<Plat> {
	Plat[] plats;
	int position = 0;
	
	public IterateurMenuCafeteria(Plat[] plats) {
		this.plats = plats;
	}
	
	
    public boolean encore() {
        return plats[position+1]!=null;
    }


    public Plat suivant() {
        if (!encore()) {
            throw new IllegalStateException("Plus d'éléments dans le menu.");
        }
        return plats[position++];
    }	
	
}
