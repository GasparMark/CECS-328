import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {

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
            System.out.println("The answer based on function is: " + upperBound);


            System.out.println("Enter n if you dont want to continue: ");
            continu = nr.nextLine().charAt(0);
        }

    }

    /**
     * Print statement for user and returns their response
     * @return decision based on int value
     */
    public static int printMenu() //gives options for users
    {
        System.out.println("1 for prompt 1, 2 for prompt 2, 3 to quit");
        Scanner val = new Scanner(System.in);
        int userDes = val.nextInt();
        return userDes;
    }

    /**
     * Find the upperbound of their squareroot of the value (meaning decimals are rounded up)
     * @param val - the value that the user wants the sqrt value of
     * @return upperbound value or exact value if a perfect sqrt
     */
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

        /*
        lowerbound - lower limit that it can possibly be
        upperbound - upper limit that it can possibly be, intialized as val
        mid - val used to determine if it is closer to upperbound or lowerbound
        As you calculate more, you can shrink the range until you find the answer
         */
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

        while (lowerBound <= upperBound)
        {
            mid = (lowerBound + upperBound)/2;
            if (mid * mid < val)
            {
                lowerBound = mid;
            }
            else if (mid * mid > val)
            {
                if((mid-1)*(mid-1) < val)
                {
                    return mid;
                }
                upperBound = mid;
            }

            if (mid * mid == val)
            {
                return mid;
            }
            if (upperBound*upperBound>val && (upperBound-1)*(upperBound-1)<val)
            {
                return upperBound;
            }
        }

        return upperBound;
    }
}
