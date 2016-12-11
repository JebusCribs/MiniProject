/**
 * Music Quiz Jamie Scott 150366140
 **/
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class Quiz
{
	public static void main(String[] p)
	{
		int[] playerscores = askQ();
		totalScore(playerscores); //main method calling the procedure
		System.exit(0);
	}

	public static int[] askQ()
	{	// method askQ which asks user question and compares answer
		 int n = 0;          // will hold number of times to repeat
       
       // Get an an int from the user to loop that many times
       //
    	System.out.println("How many of you are there to participate in this quiz? ");
    	n = inputInt("Give me a number:");
		String input = "";
		int score;
		int totalscore = 0;
		int[] playerscores = new int[n];
		Player[] playerArr = new Player[n];

		qAndA[] qAndAarr = new qAndA[3];
		qAndAarr[0] = new qAndA();
		setQuestion(qAndAarr[0], "Strange Days is the second studio album by which American rock band?");
		setAnswer(qAndAarr[0], "The Doors");

		qAndAarr[1] = new qAndA();
		setQuestion(qAndAarr[1], "Who wrote the song Rebel Rebel?");
		setAnswer(qAndAarr[1], "David Bowie");

		qAndAarr[2] = new qAndA();
		setQuestion(qAndAarr[2], "Which Rolling Stones guitarist died in a swimming pool in 1969?");
		setAnswer(qAndAarr[2], "Brian Jones");

		for(int i = 0; i < n; i++)
		{
			playerArr[i] = new Player();

			String name = JOptionPane.showInputDialog("What is your name, the chosen one?");
			setName(playerArr[i], name);

			score = 0;
			for(int j = 0; j < qAndAarr.length; j++) {
				System.out.println(getQuestion(qAndAarr[j]));
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextLine();

				if(input.equals(getAnswer(qAndAarr[j])))
				{
					System.out.println(correct());
					score+=dice();		
				}
				else
				{
					System.out.println(incorrect());
				}
			}

			System.out.println("You got " + score + " points in total");
			setScore(playerArr[i], score);
			playerscores[i] = score;
		}
		sortScores(playerArr);
		return playerscores;
	}

	public static void totalScore(int[] playerscores) {
		int tscore = 0;

		for(int i = 0; i < playerscores.length; i++) {
			tscore += playerscores[i];
		}

		System.out.println("Your team total score is " + tscore);
	}

	public static void sortScores(Player[] arr) {
		boolean sorted=false;

        while (!sorted)
        {
	       // array potentially sorted 
            sorted = true;
            
	       //traverse array to end switching ill-ordered pairs
	       for (int i=0; i < arr.length-1; i++)
	       {
                if (getScore(arr[i]) > getScore(arr [i+1]))
                {
		          // swap them
		          Player tmp = arr[i+1];
		          arr[i+1] = arr[i];
		          arr[i] = tmp;
		          // array wasn't sorted
		          sorted = false;
		        }
	       }
	    }

	    for(int j = 0; j < arr.length; j++) {
	    	System.out.println("Player " + getName(arr[j]) + ": " + getScore(arr[j]));
	    }
	}

	public static String incorrect(){ //method to print if correct
		String wrongAnswer = "That is incorrect!";
		return wrongAnswer;
	}
	public static String correct(){ //method to print if incorrect
		String rightAnswer = "That is correct!";
		return rightAnswer;
	}
	public static qAndA setQuestion(qAndA r, String s){ //setter method
		r.question = s;
		return r;
	}
	public static qAndA setAnswer(qAndA r, String s){
		r.answer = s;
		return r;
	}
	public static String getQuestion(qAndA r){ //getter methods
		return r.question;
	}
	public static String getAnswer(qAndA r){
		return r.answer;
	}
 	public static Player setScore(Player p, int score){
 		p.score = score;
 		return p;
 	}
	public static int getScore(Player p){
		return p.score;
	}

	public static Player setName(Player p, String name) {
		p.name = name;
		return p;
	}

	public static String getName(Player p) {
		return p.name;
	}

 	public static int inputInt (String message)
  	{
       Scanner scanner = new Scanner(System.in);
       int answer;

       System.out.println(message);
       answer = Integer.parseInt(scanner.nextLine());
   
       return answer;
  	} // END inputInt

	private static int dice()
    	{
		Random dice= new Random();
		int dicethrow = dice.nextInt(6) + 1;
		if(dicethrow == 6)
		{
		    return 6;
		}

		else
		{
		    return 3;
		}
	}//END Dice 


}//END Class Quiz
