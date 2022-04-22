import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {
        // write your code here

        int userDec = printMenu();
        int options [] = {1,2,3};
        System.out.println("User chose decision " + userDec);

        Scanner sc = new Scanner(System.in);
        Scanner nr = new Scanner(System.in);

        char continu = 'y';

        while (continu != 'n')
        {
            System.out.println("Enter a positive number that you want the sqrt of:");
            int userVal = sc.nextInt();
            double ans = Math.ceil(Math.sqrt((double)userVal));
            System.out.println("The answer should be: " + ans);

            int upperBound = findUpperBound(userVal);

            System.out.println("Enter n if you dont want to continue: ");
            continu = nr.nextLine().charAt(0);
        }

    }

    public static int printMenu()
    {
        System.out.println("1 for prompt 1, 2 for prompt 2, 3 to quit");
        Scanner val = new Scanner(System.in);
        int userDes = val.nextInt();
        return userDes;
    }

    public static int findUpperBound(int val)
    {
        if (val >= 1 && val <= 3)
        {
            if(val == 1)
            {
                return 1;
            }
            else if (val == 2)
            {
                return 2;
            }
            else
            {
                return 3;
            }
        }

        int lowerBound = 0;
        int upperBound = val;
        int mid;

        while (lowerBound == 0)
        {
            mid = (lowerBound + upperBound)/2;

            if (mid * mid == val)
            {
                return mid;
            }
            else if (mid * mid > val)
            {
                upperBound = mid;
            }
            else if (mid * mid < val)
            {
                lowerBound = mid;
            }
        }

        return upperBound;
    }
}
