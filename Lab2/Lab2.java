public class Lab2 {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hellooooo :) ..........");

        Scanner sc = new Scanner(System.in);
        long linTime = 0;
        long binTime = 0;

        System.out.println("Enter a positive number: ");

        int userInt = sc.nextInt();

        System.out.println("The value entered was " + userInt);

        while(userInt <= 0)
        {
            System.out.println("Enter a positive integer: ");
            userInt = sc.nextInt();
        }

        int arr [] = new int [userInt];
   
}