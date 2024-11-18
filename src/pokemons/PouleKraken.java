package pokemons;

public class PouleKraken extends PoulePoulpe{

	public PouleKraken(PoulePoulpe p) {
		super(p);
		this.initNiveau(p.getNiveau() + 1);
	}

}
