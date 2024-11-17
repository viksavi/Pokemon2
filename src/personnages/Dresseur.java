package personnages;
import java.util.Random;

import equipement.SacADos;
import pokemons.Pokemon;

public class Dresseur {
	private String nom;
	private int argent;
	private SacADos sacADos;
	private Equipe equipe;
	public static int nbDresseurs = 0;
	public static int[] nbParEquipe = new int[3];
	
	public Dresseur(String nom) {
		this.nom = nom;
		this.choixEquipe();
		nbDresseurs++;
	}
	
	private void choixEquipe() {
		Random random = new Random();
		this.equipe = Equipe.values()[random.nextInt(3)];
		switch(equipe) {
			case SAGESSE -> Dresseur.nbParEquipe[0]++;
			case BRAVOURE -> Dresseur.nbParEquipe[1]++;
			case INTUITION -> Dresseur.nbParEquipe[2]++;
		}
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbPokemons() {
		return sacADos.getNbPokemons();
	}
	
	public void capturerPokemons() {
		sacADos.capturerPokemons();
	}
	
	public boolean peutCombatre() {
		return sacADos.peutCombatre() && this.argent > 0;
	}
	
	public Pokemon getNextPokemon() {
		return sacADos.getNextPokemon();
	}
	
	public void prendreArgent(Dresseur adversaire) {
		adversaire.argent -= 10;
		this.argent += 10;
	}
	
	public void combattre(Dresseur d) {
		sacADos.combatre(d);
	}
	
	public void pokeCenter() {
		sacADos.pokeCenter();
	}
	
	@Override
	public String toString() {
		StringBuilder texte = new StringBuilder();
		texte.append("Je m'appelle " + this.nom + "\n");
		texte.append("\tj'ai" + this.getNbPokemons() + " Pokemons !" + "\n");
		texte.append("\tj'appartiens à l'équipe " + "\n");
		texte.append("\tje possède " + this.argent + "\n");
		return texte.toString();
	}
	
	private String prefixe() {
		return "[Dresseur " + this.nom + "]";
	}
	
	public void log(String msg) {
		System.out.println(this.prefixe() + " : " + msg);
	}
}


