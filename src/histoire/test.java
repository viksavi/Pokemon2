package histoire;

import personnages.Pokemon0;

public class test {

	public static void main(String[] args) {
		System.out.println("Test Pokemon0 \n");
		Pokemon0 p1 = new Pokemon0("Rhinolove");
		Pokemon0 p2 = new Pokemon0("Chovsourir");
		p1.log(p1.toString());
		p2.log(p2.toString());
		p1.attaquer(p2);
		p2.log(p2.toString());

	}

}
