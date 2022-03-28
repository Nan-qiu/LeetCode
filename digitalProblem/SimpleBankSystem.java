package leetcode.digitalProblem;

public class SimpleBankSystem {
    static class Bank {

        long[] customer;
        int size;

        public Bank(long[] balance){
            customer = balance.clone();
            size = balance.length;
        }

        public boolean transfer(int account1,int account2,long money){
            if (account1 > size || account2 > size) return false;
            if (customer[account1 - 1] < money) return false;
            else{
                customer[account1 - 1] -= money;
                customer[account2 - 1] += money;
                return true;
            }
        }

        public boolean deposit(int account,long money){
            if (account > size) return false;
            customer[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account,long money){
            if (account > size) return false;
            if (customer[account-1]<money) return false;
            customer[account - 1] -= money;
            return true;
        }
    }
}
