
public class E43 {
	public static int nbSimulatedRolling(int numToFind) throws Exception{
		/* Throw an exceprtion if the number to fin
		 * is not between 2 and 12 both included*/
		if  (numToFind>12 || numToFind<2){
			IllegalArgumentException e = new IllegalArgumentException();
			throw e;
		}
		int nbTimes =0; //Nombre de lancés
		int dice1=0, dice2=0; // valeur de chaque dé
		/* 
		 * Faire un lancé de dés tant qu'on a pas obtenu la valeur à trouver
		 */
		while(dice1+dice2 !=numToFind){ 
			dice1 = 1 + (int)(Math.random() * 5); // attribut une valeur entre 1 et 6 au dé 
			dice2 = 1 + (int)(Math.random() * 5);
			nbTimes++; 
		}
		return nbTimes; // retourne le nombre de lancés
	}
	public static void main(String[] args) throws Exception {
		int SnakeEye = nbSimulatedRolling(2);
		System.out.println("Number of times to get a Snake yes :" + SnakeEye);
	}
}
