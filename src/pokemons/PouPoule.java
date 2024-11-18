package pokemons;

public class PouPoule extends PokemonEau{
	protected int bonusVie = 10;
	
	public PouPoule() {
		super("PouPoule");
		this.initNiveau(5);
	}

	protected PouPoule(String nom) {
		super(nom);
		this.initNiveau(5);
	}
	
	@Override
	protected void perdreVie(int dommages) {
		if(bonusVie > 0) {
			bonusVie -= dommages;
		} else {
			super.perdreVie(dommages);
		}
	}
	

}
