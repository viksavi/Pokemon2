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
			while(this.dresseur.peutCombatre()) {
				if(!adversaire.peutCombatre()) {
					System.out.println(adversaire.getNextPokemon() + "est K0!");
					System.out.println("Hé hé! Je t'ai battu!");
					break;
				}
				this.getNextPokemon().attaquer(adversaire.getNextPokemon());
				adversaire.getNextPokemon().attaquer(this.getNextPokemon());
			} 
			System.out.println(this.dresseur.getNextPokemon() + "est K0!");
			System.out.println("Hé hé! Je t'ai battu!");
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
