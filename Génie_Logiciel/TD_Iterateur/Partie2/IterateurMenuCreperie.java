package version2;

import java.util.List;


public class IterateurMenuCreperie implements Iterateur<Plat> {
		private List <Plat> plats;
		int position = 0;
		
		public IterateurMenuCreperie(List<Plat> plats) {
			this.plats = plats;
		}
		
		
		
	    public boolean encore() {
	        return position < plats.size();
	    }


	    public Plat suivant() {
	        if (!encore()) {
	            throw new IllegalStateException("Plus d'éléments dans le menu.");
	        }
	        return plats.get(position++);
	    }	
	    
	    //Bermad  l'hernitre
	    
}
