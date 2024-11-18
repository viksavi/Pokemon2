package pokemons;
import java.util.Random;

public abstract class Pokemon {
	private String nom;
	private int niveau;
	private int hp;
	private int atk;
	private static int niveauMax = 10;
	private TypePokemon type;
	
	private static java.util.Random random = new Random();
	
	public Pokemon(String nom, TypePokemon type) {
		this.nom = nom;
		this.initNiveau(random.nextInt(1, niveauMax + 1));
		this.type = type;
	}
	
	protected void initNiveau(int niveau) {
		this.niveau = niveau;
		this.hp = 2 * niveau;
		this.atk = (niveau / 2) + 1;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNiveau() {
		return this.niveau;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public TypePokemon getType() {
		return this.type;
	}
	
	public boolean isK0() {
		return (hp == 0);
	}
	
	public void soigner() {
		this.hp = 2 * niveau;
	}
	
	protected void perdreVie(int dommages) {
		if(hp - dommages < 0) {
			hp = 0;
		} else {
			hp -= dommages;
		}
	}
	
	public abstract void attaquer(Pokemon p);
	
	@Override
	public String toString() {
		StringBuilder texte = new StringBuilder();
		texte.append("Je m'appelle " + this.nom + " !\n");
		texte.append("\tje suis de niveau " + this.niveau + "\n");
		texte.append("\tj'ai " + this.hp + " points de vie\n");
		texte.append("\tmon attaque de base est de " + this.atk + "\n");
		texte.append("\tje suis de type " + this.getType().toString());
		return texte.toString();
	}
	
	private String prefixe() {
		return "[Pokemon " + this.nom + "]";
	}
	
	public void log(String msg) {
		System.out.println(this.prefixe() + " : " + msg);
	}
	
	public abstract void subir(Pokemon p);
}
