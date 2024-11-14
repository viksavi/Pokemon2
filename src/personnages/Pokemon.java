package personnages;
import java.util.Random;

public class Pokemon {
	private String nom;
	private int niveau;
	private int hp;
	private int atk;
	
	private static java.util.Random random = new Random();
	
	public Pokemon(String nom) {
		this.nom = nom;
		this.niveau = random.nextInt(1, 11);
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
	
	public boolean isK0() {
		return (hp == 0);
	}
	
	public void soigner() {
		this.hp = 2 * niveau;
	}
	
	public void attaquer(Pokemon p) {
		if(p.hp - this.atk < 0) {
			p.hp = 0;
		} else {
			p.hp -= this.atk;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder texte = new StringBuilder();
		texte.append("Je m'appelle " + this.nom + " !\n");
		texte.append("\tje suis de niveau " + this.niveau + "\n");
		texte.append("\tj'ai " + this.hp + " points de vie\n");
		texte.append("\tmon attaque de base est de " + this.atk);
		return texte.toString();
	}
	
	public void log(String msg) {
		System.out.println("[Pokemon " + this.nom + "] : " + msg);
	}
}
