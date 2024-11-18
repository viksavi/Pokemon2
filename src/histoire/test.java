package histoire;

import personnages.Dresseur;
import pokemons.Pokemon0;
import pokemons.PokemonEau;
import pokemons.PokemonFeu;

public class test {

	public static void main(String[] args) {
		System.out.println("\nTEST POKEMON0 \n");
		testPokemon0();
		
		System.out.println("\nTEST POKEMON TYPES \n");
		testPokemonTypes();
		
		System.out.println("\nTEST DRESSEUR \n");
		testDresseur();

	}
	
	private static void testPokemon0() {
		System.out.println("Test Pokemon0 \n");
		Pokemon0 p1 = new Pokemon0("Rhinolove");
		Pokemon0 p2 = new Pokemon0("Chovsourir");
		p1.log(p1.toString());
		p2.log(p2.toString());
		p1.attaquer(p2);
		p2.log(p2.toString());
	}
	
	private static void testPokemonTypes() {
		PokemonEau eau = new PokemonEau("PokéEau");
		PokemonFeu feu = new PokemonFeu("PokéFeu");
		eau.log(eau.toString());
		feu.log(feu.toString());
		eau.attaquer(feu);
		feu.attaquer(eau);
		eau.log(eau.toString());
		feu.log(feu.toString());
	}
	
	private static void testDresseur() {
		Dresseur dresseur1 = new Dresseur("Red");
		Dresseur dresseur2 = new Dresseur("Blue");
		dresseur1.log(dresseur1.toString());
		dresseur1.capturerPokemons();
		dresseur2.log(dresseur2.toString());
		dresseur2.capturerPokemons();
		dresseur1.combattre(dresseur2);
	}

}
