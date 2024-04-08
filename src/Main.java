import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int a, b, n, k, length, num;
        String s;
        int[] numbers;
        double startTime, endTime, duration;
        String incorrectInput = """
                IncorrectInput""";
        System.out.println("""
                Enter 0 if you want to quit the program 
                Programs:
                1.Find the min value of the array
                2.Find the average value of the array
                3:Check if number is prime
                4.Find factorial of number n
                5.Find the n-th of the Fibonacci sequence
                6.a^n
                7.Reverse the sequence
                8.Check for consisting digits in string
                9.Binomial coefficient 
                10.GCD
                """);
        while (true) {
            try {
                System.out.println("Enter the number of the problem you want to solve (1-10):");
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
                        int average = averageOfArray(numbers);
                        System.out.println("The minimum value in the given array is:" + minimum);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 3:
                        System.out.println("enter the number:");
                        num = sc.nextInt();
                        if (isPrime(num)) {
                            System.out.println(num + "is prime.");
                        } else {
                            System.out.println(num + "is composite.");
                        }
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 4:
                        System.out.println("enter the number");
                        num = sc.nextInt();
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        int factorial = factorialOfNumbers(num);
                        System.out.println("The factorial of the given number is" + factorial);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 5:
                        System.out.println("enter the number");
                        num = sc.nextInt();
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        int fibo = fibonacci(num);
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
                        int reversed = reverseOfArray(numbers);
                        System.out.println("The reverse of given array is" + reversed);
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
                        System.out.println("Binomial coefficient for the given numbers" + binom);
                        System.out.println("Time taken for the task:" + duration + "milliseconds");
                        break;
                    case 10:
                        System.out.println("enter a and b");
                        a = sc.nextInt();
                        b = sc.nextInt();
                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000;
                        int gcd = gcdOfNumbers(a, b);
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
    static int minimumValue(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    static double averageOfArray(int[] arr){
        int summa=0;
        for (int i = 0; i < arr.length; i++) {
            summa+=i;
        }
        return ((double)summa/arr.length);
}

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
    static int factorialOfNumbers(int n){
        if (n==0||n==1){
            return 1;
        }
        return n*factorialOfNumbers(n-1);
    }






