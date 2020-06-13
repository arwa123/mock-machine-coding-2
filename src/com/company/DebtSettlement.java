package com.practise;

public class DebtSettlement {

    public static void calculateCD(int[][] graph, int n) {

        int netAmount[] = new int[4];

        for(int i=0; i<n;i++){

            for(int j=0; j<n;j++){

                netAmount[i] += graph[i][j] - graph[j][i];
            }
            System.out.println(netAmount[i]);
        }

        findMinTransactions(netAmount);
    }

    private static void findMinTransactions(int[] netAmount) {

            int maxCredit = findMax(netAmount);
            int maxDebit = findMin(netAmount);


            if(maxCredit ==0 && maxDebit == 0) {
                System.out.println("All settled");
                return;
            }
            int balance = Math.min(netAmount[maxCredit], -(netAmount[maxDebit]));
            netAmount[maxCredit] = netAmount[maxCredit]- balance;
            netAmount[maxDebit] = netAmount[maxDebit] + balance;

            System.out.println("Transaction between P"+(maxCredit+1)+" with amount -"+balance+" and P"+(maxDebit+1)+" with amount +"+balance);

        findMinTransactions(netAmount);

    }



    private static int findMax(int[] netAmount) {
        int max  = 0;
        for(int i=0; i<netAmount.length;i++){
            if(netAmount[i]>netAmount[max])
                max = i;
        }
        return max;
    }

    private static int findMin(int[] netAmount) {

        int min  = 0;
        for(int i=0; i<netAmount.length;i++){
            if(netAmount[i] < netAmount[min])
                min = i;
        }
        return min;
    }
}
