import java.util.Scanner;
public class Ngg{
        static int a=0;
        static int score=0;
        static String b;
        static Scanner sc = new Scanner(System.in); 
    
        public static void game()
        {
             

            int n = 1+(int)(100 * Math.random()); // Generate the numbers
            int t = 7; // Number of trials

            int i, guess;
            

            System.out.println();
            System.out.println("                       WELCOME  TO  GAME  7                           ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("A number is chosen between 1 to 100. Guess the number within 7 trials.");

            // Iterate over Trials
            for (i = 1; i <= t; i++) {

                System.out.println("Guess the number:");

                // Take input for guessing
                guess = sc.nextInt();

                // If the number is guessed
                if (n == guess) {
                    System.out.println("Congratulations! You guessed the number.");
                    a=i;
                    break;
                }
                else if (n > guess && i != t ) {
                    System.out.println("The number is greater than " + guess);
                }
                else if (n < guess && i != t ) {
                    System.out.println("The number is less than " + guess);
                }
                
         }

            if (i > t) {
                System.out.println("You have exhausted your "+ t + " trials.");
                System.out.println("The number was " + n);
            }  
        }
        public static void results(){
                 if(a!=0){
                        System.out.println("You took "+ a + " trials to guess the number");
                        System.out.println("Your score is:");
                        switch(a){
                                case 1:System.out.println("COngragulations you scored 100 points!!");
                                break;
                                case 2:System.out.println("COngragulations you scored 80 points!!");
                                break;
                                case 3:System.out.println("COngragulations you scored 60 points!!");
                                break;
                                case 4:System.out.println("COngragulations you scored 40 points!!");
                                break;
                                case 5:System.out.println("COngragulations you scored 30 points!!");
                                break;
                                case 6:System.out.println("COngragulations you scored 20 points!!");
                                break;
                                case 7:System.out.println("COngragulations you scored 10 points!!");
                                break;
                        }
                }
                else{
                System.out.println("You do not get any points"); 
                   }
                
        }
        

        public static void main(String[] args)
        {
           do{
            game();  // Function Call for game
            results(); //Function call for score
            System.out.println("Want to continue?(Y/N)");
            b=sc.next();
           }while(b.equalsIgnoreCase("y"));
            
        }
    }
    