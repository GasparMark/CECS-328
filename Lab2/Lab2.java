import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {

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

        int[] a = new int[]{0,1,3,6,8,9};
        int m = 10;
        int a1 = findIndexOutOfOrder(a,m);
        System.out.println("Output for a1: " + a1);
        //Output: 2

        int[] b = new int[]{2,5,7,11};
        int m2 =15;
        int b2 = findIndexOutOfOrder(b,m2);
        System.out.println("Output for b2: " + b2);
        //output: 0

        int[] c = new int[]{0,1,2,3,4};
        int m3 = 8;
        int c1 = findIndexOutOfOrder(c,m3);
        System.out.println("Output for c1: " + c1);
        //output: 5

        int[] d = new int[]{12};
        int m4 = 13;
        int d1 = findIndexOutOfOrder(d,m4);
        System.out.println("Output for d1: " + d1);
        //output: 0

    }

    /**
     * PROMPT 1 ANSWER FUNCTION
     * Find the upperbound of their squareroot of the value (meaning decimals are rounded up)
     * Time complexity - O (log n)
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

    /**
     * PROMPT 2 ANSWER FUNCTION
     * Find the index where the value and the index don't match up
     * Time Complexity - O(log n)
     * @param arr - array of int that are used a reference
     * @param max - max value of every number in arr has to be smaller and match index
     * @return index where the value doesn't correspond correctly
     */
    public static int findIndexOutOfOrder(int [] arr, int max)
    {
        int upperBound = arr.length-1;
        int midBound;
        int lowerBound = 0;
        int currentMax = 0;

        while (lowerBound <= upperBound)
        {
            midBound = (lowerBound + upperBound)/2;
            if (midBound == upperBound && upperBound == lowerBound)
            {
                if(midBound < max && arr[0] == 0)
                {
                    return midBound + 1;
                }
                return midBound;
            }

            /*
             when they don't equal eachother there is a discrepancy and the index and the value doesn't match up
             meanign that one the left side of the halfway point is wrong
             */
            if (arr[midBound] != midBound)
            {
                if (midBound > currentMax)
                {
                    currentMax = midBound;
                }
                upperBound = midBound - 1;
            }
            else if(arr[midBound] == midBound)
            {
                lowerBound = midBound + 1;
            }
        }
        return currentMax;
    }
}
