package pokemons;

public class PokemonEau extends Pokemon{

	public PokemonEau(String nom) {
		super(nom, TypePokemon.EAU);
	}

	@Override
	public void attaquer(Pokemon p) {
		p.subir(this);
	}

	@Override
	public void subir(Pokemon p) {
		int degats;
		switch(p.getType()) {
			case FEU:
				degats = this.getAtk() * 2;
				this.log("J'attaque " + p.getNom() + " : " + this.getType().toString() + " vs " + this.getType().toString());
				p.log("C'est très efficace!");
				break;
			case EAU, PLANTE:
				degats = this.getAtk() * 1/2;
				this.log("J'attaque " + p.getNom() + " : " + this.getType().toString() + " vs " + this.getType().toString());
				p.log("C'est peu efficace...");
				break;
			default:
				degats = this.getAtk() * 1;
				break;
		}
		this.perdreVie(degats);
		
	}

}
