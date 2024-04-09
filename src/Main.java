import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int a, b, n, k, length;
        String s;
        int[] numbers;
        double startTime, endTime, duration;
        String incorrectInput = """
                IncorrectInput""";
        System.out.println("""
                Enter 0 if you want to quit the program 
                Programs:
                1.Min value of the array
                2.Average value of the array
                3.Prime check
                4.Factorial
                5.Fibonacci
                6.a^n
                7.Reverse
                8.Check for consisting digits in string
                9.Binomial coefficient 
                10.GCD
                """);
        while (true) {
            try {
                System.out.println("Enter the problem you want to solve (1-10):");
                int task = sc.nextInt();
                if (task == 0) {
                    break;
                }
                switch (task) {
                    case 1:
                        System.out.println("enter length of the array");
                        length = sc.nextInt();
                        System.out.println("enter sequence");
                        numbers = new int[length];
                        for (int i = 0; i < length; i++) {
                            numbers[i] = sc.nextInt();

                        }
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        int minimum = minimumValue(numbers);
                        System.out.println("The minimum value in the given array is:" + minimum);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 2:
                        System.out.println("enter length of the array");
                        length = sc.nextInt();
                        System.out.println("enter sequence");
                        numbers = new int[length];
                        for (int i = 0; i < length; i++) {
                            numbers[i] = sc.nextInt();

                        }
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        double average = averageOfArray(numbers);
                        System.out.println("The average of the iven array is"+average);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 3:
                        System.out.println("enter the number:");
                        n = sc.nextInt();
                        if (isPrime(n)) {
                            System.out.println(n + "is prime.");
                        } else {
                            System.out.println(n + "is composite.");
                        }
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;

                    case 4:
                        System.out.println("enter the number");
                        n = sc.nextInt();
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        int factorial = factorialOfNumbers(n);
                        System.out.println("The factorial of the given number is" + factorial);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 5:
                        System.out.println("enter the number");
                        n = sc.nextInt();
                        int fibo = fibonacci(n);
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        System.out.println("The n-th element in Fibonacci sequence" + fibo);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 6:
                        System.out.println("enter the number");
                        a = sc.nextInt();
                        System.out.println("enter the degree");
                        n = sc.nextInt();
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        int degree = degreeOfA(a, n);
                        System.out.println("The a^n" + degree);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 7:
                        System.out.println("enter length of the array,and sequence");
                        length=sc.nextInt();
                        numbers=new int[length];
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] = sc.nextInt();

                        }
                        reverseOfArray(numbers,length);
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 8:
                        System.out.println("enter the string");
                        s = sc.nextLine();
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        if (isDigit(s)) {
                            System.out.println("String is all consist of digits.");
                        } else {
                            System.out.println("String is not all consist of digits.");
                        }
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 9:
                        System.out.println("enter the n,k to evaluate Binomial coefficients:");
                        n = sc.nextInt();
                        k = sc.nextInt();
                        int binomial = binomialCoefficient(n, k);
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        System.out.println("Binomial coefficient for the given numbers" + binomial);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 10:
                        System.out.println("enter a and b");
                        a = sc.nextInt();
                        b = sc.nextInt();
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        int gcd = greatestCommonDivisor(a, b);
                        System.out.println("GCD of 2 numbers" + gcd);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    default:
                        System.out.println(incorrectInput);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(incorrectInput);
                sc.nextLine();
            }
        }
    }

    /**
     * This method finds the minimum element in a given array using the "for" loop.
     * Time complexity: O(n), where n is the length of the array.
     * The for loop goes through all the elements of the array and calculates the result.
     * @param arr
     * @return
     */
    static int minimumValue(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    /**
     * This method calculates the average value of the elements of a given array
     * Time complexity: O(n), where n is the length of the array.
     * The For loop iterates over all elements of the array, resulting in
     * In linear time complexity.
     * @param n The given number of elements in array.
     * @param arr The given array of integer numbers of size n.
     * @return The average of numbers of array.
     */
    static double averageOfArray(int[] arr){
        int summa=0;
        for (int i = 0; i < arr.length; i++) {
            summa+=i;
        }
        return ((double)summa/arr.length);
}
    /**
     * This function determines whether the given number is prime or composite.
     * It employs a for loop.
     * Time complexity: O(sqrt(n)), where n is the given number.
     * The for loop iterates through numbers from 2 to sqrt(n),
     * resulting in a square root time complexity.
     *
     * @param n The given number n, for which the function checks if
     * it is prime.
     * @return true if the given number is prime, or false if the given
     * number is composite.
     */
    static boolean isPrime(int n){
        if (n==0||n==1||n<0){
            System.out.println("no");
        }
        boolean prime=true;
        for (int i = 2; i <n ; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }}
            return prime;


    }
    /**
     * This function computes the factorial of a specified number.
     * It employs a recursive technique.
     * Time complexity: O(n), where n is the given number.
     * The recursive algorithm traverses through all numbers from n
     * to 1, leading to linear time complexity.
     *
     * @param n The number for which the factorial is computed.
     * @return The factorial value of the specified number.
     */
    static int factorialOfNumbers(int n){
        if (n==0||n==1){
            return 1;
        }
        return n*factorialOfNumbers(n-1);
    }

    /**
     * This function computes the n-th element in the Fibonacci sequence.
     * It utilizes a recursive strategy.
     * Time complexity: O(2^n), where n is the given number.
     * The recursive algorithm invokes itself for each non-base case,
     * leading to exponential time complexity.
     *
     * @param n The index of the number in the Fibonacci sequence
     * to be determined.
     * @return The n-th element in the Fibonacci sequence.
     */
    static int fibonacci(int n){
        if (n==0){
            return 0;
        }
        else if (n==1){
            return 1;
        }
        else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    /**
     * This function computes the result of raising a number to a power.
     * It employs a recursive approach.
     * Time complexity: O(n), where n is the exponent.
     * The recursive algorithm involves multiplying the base 'a' by itself
     * 'n' times, leading to linear time complexity.
     *
     * @param a The base number.
     * @param n The exponent.
     * @return The value of 'a' raised to the power of 'n'.
     */
    static int degreeOfA(int a,int n) {
        if (n == 1) {
            return a;
        }
        return a * degreeOfA(a, n - 1);
    }

    /**
     * This function reverses a provided array.
     * It utilizes a recursive approach.
     * Time complexity: O(n), where n is the length of the array.
     * The recursive algorithm swaps the elements at the beginning
     * and end of the array, and then recursively calls itself on
     * the remaining portion of the array. This results in linear time complexity.
     *
     * @param n The number of elements in the array.
     * @param arr The array of integer numbers to be reversed.
     * @return The given array in reversed order.
     */
    static void reverseOfArray(int[] arr,int n){
        if (n == 0) {
            System.out.println();
            return;
        }
        System.out.print(arr[n - 1] + " ");
        reverseOfArray(arr, n - 1);
    }

    /**
     * This function verifies whether a given string consists solely of digits.
     * It employs a recursive technique.
     * Time complexity: O(n), where n is the length of the string.
     * The recursive algorithm examines whether the first character is a digit,
     * and then recursively calls itself for the remaining characters in the string.
     * This leads to linear time complexity.
     *
     * @param s The string to be examined.
     * @return true if the given string contains only numeric characters,
     * or false otherwise.
     */
    static boolean isDigit(String s) {
        if (s.isEmpty()) return true;
        int c = s.charAt(0);
        if (48 > c || 57 < c) return false;
        return isDigit(s.substring(1));
    }
    /**
     * This function calculates the binomial coefficient C(n, k).
     * It utilizes a recursive approach based on the identity
     * C(n, k) = C(n - 1, k - 1) + C(n - 1, k).
     * Time complexity: O(2^n), where n is the first parameter.
     * This arises because each call to this function results in two
     * recursive calls unless it reaches the base case.
     * The recursive algorithm computes the binomial coefficient
     * by decomposing it into two smaller coefficients, leading
     * to exponential time complexity.
     *
     * @param n The first parameter of the binomial coefficient to be calculated.
     * @param k The second parameter of the binomial coefficient to be calculated.
     * @return The binomial coefficient of numbers n and k.
     */
    static int binomialCoefficient(int n,int k){
        if(k==0 || k==n) return 1;
        return binomialCoefficient(n-1,k-1)+binomialCoefficient(n-1,k);
    }

    /**
     * This function computes the greatest common divisor (GCD) of two numbers.
     * It employs a recursive strategy.
     * Time complexity: O(log(min(a,b))), where 'a' and 'b'
     * are the input numbers. With each recursive call, the
     * problem size decreases geometrically.
     *
     * @param a The first number for GCD calculation.
     * @param b The second number for GCD calculation.
     * @return The greatest common divisor (GCD) of 'a' and 'b'.
     */
    static int greatestCommonDivisor(int a,int b){
        if(a == 0) return b;
        if(b == 0) return a;
        return greatestCommonDivisor(b, a % b);
    }
}













