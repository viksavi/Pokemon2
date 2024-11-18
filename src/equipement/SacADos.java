package equipement;

import java.util.ArrayList;
import java.util.Random;

import personnages.Dresseur;
import pokemons.Pokemon;

public class SacADos {
	
	private Pokeball ball;
	private Dresseur dresseur;
	private ArrayList<Pokemon> pokemons = new ArrayList<>();
	
	public SacADos(Dresseur dresseur) {
		this.dresseur = dresseur;
		this.ball = new Pokeball(dresseur);
	}
	
	public int getNbPokemons() {
		return this.pokemons.size();
	}
	
	public void capturerPokemons() {
		Random random = new Random();
		int nbPokemons = random.nextInt(1, 6);
		for(int i = 0; i < nbPokemons; i++) {
			Pokemon pokemon = ball.capturerPokemons(i);
			pokemons.add(pokemon);
			this.dresseur.log("Capture du pokémon : " + pokemon.toString());
		}
	}
	
	public boolean peutCombatre() {
		for(Pokemon pokemon : pokemons) {
			if(!pokemon.isK0())
				return true;
		}
		return false;
	}
	
	public void combatre(Dresseur adversaire) {
		if(!this.dresseur.peutCombatre()) {
			this.dresseur.log("Je ne peux pas combattre, pas de pokémons:(");
		} else if(!adversaire.peutCombatre()) {
			adversaire.log("Je ne peux pas combattre, pas de pokémons:(");
		} else {
			System.out.println("COMBAT !\n\n");
			this.dresseur.log(adversaire.getNom() + " je te défie en duel!");
			while(this.dresseur.peutCombatre()) {
				if(!adversaire.peutCombatre()) {
					this.dresseur.log(adversaire.getNextPokemon().getNom() + " est K0!");
					System.out.println("Hé hé! Je t'ai battu!");
					return;
				}
				Pokemon pokemon1 = this.dresseur.getNextPokemon();
				Pokemon pokemon2 = adversaire.getNextPokemon();
				while(!pokemon1.isK0() && !pokemon2.isK0()) {
					pokemon2.attaquer(pokemon1);
					pokemon1.attaquer(pokemon2);
				}
			} 
			adversaire.log(this.getNextPokemon().getNom() + " est K0!");
			adversaire.log("Hé hé! Je t'ai battu!");
		}
	}
	
	public Pokemon getNextPokemon() {
		for(Pokemon pokemon : pokemons) {
			if(!pokemon.isK0())
				return pokemon;
		}
		return pokemons.get(0);
	}
	
	public void pokeCenter() {
		pokemons.forEach(Pokemon::soigner);
	}
	
}
