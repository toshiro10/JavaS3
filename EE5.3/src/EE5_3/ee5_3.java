package EE5_3;
import com.github.js_dev88.dice.PairOfDice;
import com.github.js_dev88.stat.StatCalc;

public class ee5_3 {

	/**
	 * This program performs the following type of experiment:  Given a desired 
	 * total roll, such as 7, roll a pair of dice until the given total comes up, 
	 * and count how many rolls are necessary.  Now do that over and over, and
	 * find the average number of rolls.  The number of times the experiment is 
	 * repeated is given by the constant, NUMBER_OF_EXPERIMENTS.  The average is
	 * computed and printed out for each possible roll = 2, 3, ..., 12. 
	 */
	   /**
	    * The number of times that the experiment "roll for a given total"
	    * is to be repeated.  The program performs this many experiments, and
	    * prints the average of the result, for each possible roll value, 
	    */
	   public static final int NUMBER_OF_EXPERIMENTS = 10000;

	   public static void main(String[] args) {
	       double [] average;  // The average number of rolls to get a given total.
	       System.out.println("Total On Dice     Average Number of Rolls	Standard Deviation	Max");
	       System.out.println("-------------     -----------------------    ------------------       -------");
	       for ( int dice = 2;  dice <= 12;  dice++ ) {
	          average = getAverageRollCount( dice );
	          System.out.printf("%10d%22.4f%22.4f%22.0f\n", dice, average[0],average[1], average[2]);
	             // Use 10 spaces to output dice, and use 22 spaces to output
	             // average, with 4 digits after the decimal.
	       }
	   } 
	   
	   /**
	    * Find the average number of times a pair of dice must be rolled to get
	    * a given total.  The experiment of rolling for the given total is
	    * repeated NUMBER_OF_EXPERIMENTS times and the average number of rolls
	    * over all the experiments is computed.
	    * Precondition:  The given total must be be between 2 and 12, inclusive.
	    * @param roll the total that we want to get on the dice
	    * @return the average number of rolls that it takes to get the specified
	    *    total
	    */
	   public static double[] getAverageRollCount( int roll ) {
		   double tableauEntier[] = new double[3];

		   StatCalc calcul = new StatCalc();
		  
		   
	       int rollCountThisExperiment;  // Number of rolls in one experiment.
           // Total number of rolls in all the experiments.
	       //double averageRollCount;  // Average number of rolls per experiment.
	       for ( int i = 0;  i < NUMBER_OF_EXPERIMENTS;  i++ ) {
	          rollCountThisExperiment = rollFor( roll );
	          calcul.enter(rollCountThisExperiment);
	       }
	       tableauEntier[0] = calcul.getMean();
	       tableauEntier[1] = calcul.getStandardDeviation();
	       tableauEntier[2] = calcul.getMax();
	       return tableauEntier;
	   }
	   
	   /**
	    * Simulates rolling a pair of dice until a given total comes up.
	    * Precondition:  The desired total is between 2 and 12, inclusive.
	    * @param N the total that we want to get on the dice
	    * @return the number of times the dice are rolled before the
	    *    desired total occurs
	    * @throws IllegalArgumentException if the parameter, N, is not a number
	    *    that could possibly come up on a pair of dice
	    */
	   public static int rollFor( int N ) {
	       if ( N < 2 || N > 12 )
	          throw new IllegalArgumentException("Impossible total for a pair of dice.");
	       PairOfDice pair = new PairOfDice(); // Call a new object pair
	       int die1, die2;
	       int roll;        // Total showing on dice.
	       int rollCt;      // Number of rolls made.
	       rollCt = 0;
	       do {
	    	  pair.roll();
	          die1 = pair.getDie1();
	          die2 = pair.getDie2();
	          roll = die1 + die2;
	          rollCt++;
	       } while ( roll != N );
	       return rollCt;
	   }	   

}
