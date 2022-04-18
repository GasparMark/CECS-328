import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Lab1 {

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

        Random random = new Random();
        for(int i=0; i<userInt;i++)
        {
            a[i] = random.nextInt(1000+1000)-1000;
        }

        Arrays.sort(arr);




    }

    public static int linearSearch(int[] a, int key)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == key)
            {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] a, int key)
    {
        int lowerBound = 0; //lower bound
        int lastVal = a.length-1; //upper bound
        int middleVal = (lowerBound + (lastVal-1))/2;
        while (lowerBound <= lastVal)
        {
            middleVal = lowerBound + (lastVal-1) / 2;
            if (key == a[middleVal])
            {
                return middleVal;
            }
            if (key > a[middleVal])
            {
                lowerBound = middleVal + 1;
            }
            else
            {
                lastVal = middleVal - 1;
            }
        }
        return -1;
    }


}
