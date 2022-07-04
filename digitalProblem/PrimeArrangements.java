package leetcode.digitalProblem;

public class PrimeArrangements {
    public static void main(String[] args){
        PrimeArrangements primeArrangements = new PrimeArrangements();
        System.out.println(primeArrangements.numPrimeArrangements(100));
    }

    public int numPrimeArrangements(int n){

        int primes = 0;
        for(int i = 1; i <= n; i++){
            if (isPrime(i)) primes++;
        }
        n -= primes;
        long res = 1;
        while (primes > 0) {
            res *= primes;
            res%=(1e9)+7;
            primes--;
        }

        while (n > 0) {
            res *= n;
            res%=(1e9)+7;
            n--;
        }

        return (int) res;
    }

    public boolean isPrime(int num){
        //1不是质数
        if (num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}
