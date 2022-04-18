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
            arr[i] = random.nextInt(1000+1000)-1000;
        }

        Arrays.sort(arr);

        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++)
        {
//System.out.println("Iteration #" + (i+1) + ": ");
            int aIndex = random.nextInt(arr.length);
            int Key = arr[aIndex];
            int linInd = linearSearch(arr,Key);
            if (linInd == -1)
            {
                System.out.println("Element not found");
            }
            else
            {
                System.out.println("Used linear search to find " + Key + " at index: "
                        + linInd);
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime-startTime);

        for (int i = 0; i < 10; i++)
        {
//System.out.println("Iteration #" + (i+1) + ": ");
            int aIndex = random.nextInt(arr.length);
            int Key = arr[aIndex];
            int linInd = linearSearch(arr,Key);
            if (linInd == -1)
            {
                System.out.println("Element not found");
            }
            else
            {
                System.out.println("Used linear search to find " + Key + " at index: "
                        + linInd);
            }
        }

        endTime = System.currentTimeMillis();
        duration = (endTime-startTime);
        binTime = duration;

        System.out.println("Linear time is: ");
        long newtime = linTime/1000000; //conversion of to milliseconds
        newtime = newtime/100; // average, by 100 for the 100 iterations
        System.out.println(newtime + "milliseconds");
        System.out.println("Binary time is: ");
        long newtime2 = binTime/1000000; //conversion of to milliseconds
        newtime2 = newtime2/100; // average, by 100 for the 100 iterations
        System.out.println(newtime2 + "milliseconds");
//System.out.println(binTime);




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
