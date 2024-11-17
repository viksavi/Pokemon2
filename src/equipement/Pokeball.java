package equipement;

import personnages.Dresseur;
import pokemons.Pokemon;
import pokemons.PokemonEau;
import pokemons.PokemonFeu;
import pokemons.PokemonPlante;
import pokemons.TypePokemon;

import java.util.Random;

public class Pokeball {
	private Dresseur dresseur;
	
	public Pokeball(Dresseur dresseur) {
		this.dresseur = dresseur;
	}
	
	public Pokemon capturerPokemons(int i) {
		Random random = new Random();
		String nomPokemon = dresseur.getNom() + ":" + "Pokemon" + i;
		return switch(TypePokemon.values()[random.nextInt(3)]) {
			case EAU -> new PokemonEau(nomPokemon);
			case FEU -> new PokemonFeu(nomPokemon);
			case PLANTE -> new PokemonPlante(nomPokemon);
			default -> null;
		};
	}
}
