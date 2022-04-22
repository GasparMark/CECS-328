public class Lab2 {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        char continu = 'y';

        while (continu ! = 'n')
        {
            System.out.println("Enter a positive number that you want the sqrt of:");
            int userVal = sc.nextInt();
            double ans = Math.ceil(Math.sqrt((double)userInt));
            System.out.println("The answer should be: " + ans);

            System.out.println("Enter e if you dont want to continue: ");
            continu = nr.nextLine().charAt(0);
        }

    }
}
