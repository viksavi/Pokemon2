package pokemons;

public class PoulePoulpe extends PouPoule{
	
	public PoulePoulpe(PouPoule p) {
		super();
		this.initNiveau(p.getNiveau() + 1);
	}

	protected PoulePoulpe(String nom) {
		super(nom);
		this.initNiveau(super.getNiveau() + 1);
	}
}
