package com.practise;

import java.util.Scanner;

public class Transactions {


    public static void main(String[] args) {

        //     int[][] graph = {{0,100,0,0},{0,0,200,0},{50,0,0,150},{250,300,0,0}};

        //   int[][] graph = {{0,1000,2000},{0,0,5000},{0,0,0}};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total users");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter total transactions");
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println("Enter user1");
            int p1 = sc.nextInt();
            System.out.println("Enter user2");
            int p2 = sc.nextInt();
            System.out.println("Enter amount");
            int amount = sc.nextInt();
            graph[p1 - 1][p2 - 1] = graph[p1 - 1][p2 - 1] + amount;
        }


        DebtSettlement.calculateCD(graph, n);

    }
}
