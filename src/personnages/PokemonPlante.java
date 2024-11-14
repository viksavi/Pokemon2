package personnages;

public class PokemonPlante extends Pokemon{

	public PokemonPlante(String nom) {
		super(nom, TypePokemon.PLANTE);
	}

	@Override
	public void attaquer(Pokemon p) {
		p.subir(this);
	}

	@Override
	public void subir(Pokemon p) {
		int degats;
		switch(p.getType()) {
			case EAU:
				degats = this.getAtk() * 2;
				this.log("J'attaque " + p.getNom() + " : " + this.getType().toString() + " vs " + this.getType().toString());
				this.log("C'est très efficace!");
				break;
			case FEU, PLANTE:
				degats = this.getAtk() * 1/2;
				this.log("J'attaque " + p.getNom() + " : " + this.getType().toString() + " vs " + this.getType().toString());
				this.log("C'est peu efficace...");
				break;
			default:
				degats = this.getAtk() * 1;
				break;
		}
	
		if(p.getHp() - degats < 0) {
			p.hp = 0;
		} else {
			p.hp -= degats;
		}
		
	}

}
