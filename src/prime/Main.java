package prime;

import java.util.Scanner;

public class Main {

    static class MyNumber {

        private int number;

        MyNumber(int number) {

            this.number = number;
        }

        int getNumber() {

            return number;
        }

        public void setNumber(int num) {
            if (num < 2) {
                throw new IllegalArgumentException();
            }
            this.number = num;
        }

        boolean[] isPrime(int num) {

            boolean[] primes = new boolean[num];

            for (int i = 0; i < primes.length; i++) {
                primes[i] = true;
            }

            for (int i = 2; i < Math.sqrt(num); i++) {
                if (primes[i]) {
                    for (int j = (i * i); j < num; j = j + i) {
                        primes[j] = false;
                    }
                }
            }
            return primes;
        }

        static int numberOfPrimes(boolean[] primes) {
            System.out.println("\nThe number of prime numbers are: ");

            int count = 0;
            for (int i = 2; i < primes.length; i++) {
                if (primes[i]) {
                    count++;
                }
            }
            return count;
        }

        static void primeNumbers(int num, boolean[] primes) {
            System.out.println("\nThe list of prime numbers up to " + num + " are: ");

            for (int i = 2; i < primes.length; i++) {
                if (primes[i]) {
                    System.out.println(i);
                }
            }
        }

        static void scanAndPrintPrimes() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            MyNumber theNumber = new MyNumber(num);
            boolean[] primes = theNumber.isPrime(num);

            int occurrences = MyNumber.numberOfPrimes(primes);
            System.out.println(occurrences);

            MyNumber.primeNumbers(num, primes);
        }
    }

    public static void main(String[] args) {
        MyNumber.scanAndPrintPrimes();
    }
}
