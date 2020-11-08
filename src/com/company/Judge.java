package com.company;

/**
 * This class determines if there is a judge or not
 */
public class Judge {

    /**
     * If there is a judge, it returns the number assigned to the judge
     * If there isn't a judge, it returns -1
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        int[] trusts = new int[N+1];    // Amount they trust
        int[] trusted = new int[N+1];   // Amount who trusts them

        for (int i=0; i<trust.length; i++) {
            int a = trust[i][0];    // a
            int b = trust[i][1];    // b

            trusts[a]--;            // they trust others, so not judge
            trusted[b]++;           // they are trusted, so possible
        }

        int numJudges = 0;
        int judgeIndex = -1;

        for (int j=1; j < N+1; j++) {
            if (trusted[j] == N-1 && trusts[j] == 0) {      // trusted by all but itself and trusts no one
                judgeIndex = j;
                numJudges++;
            }
            if (numJudges > 1) {
                return -1;
            }
        }

        return judgeIndex;

    }

    /**
     * Calls findJudge and prints out the results for the different test cases
     * @param args
     */
    public static void main(String[] args) {
        Judge judge = new Judge();

        int[][] ex1 = { {1,2}};
        int[][] ex2 = { {1,3}, {2,3} };
        int[][] ex3 = { {1,3}, {2,3}, {3,1} };
        int[][] ex4 = { {1,2}, {2,3} };
        int[][] ex5 = { {1,3}, {1,4}, {2,3}, {2,4}, {4,3} };
        int[][] ex6 = { {1, 1}};
        int[][] ex7 = { };


        System.out.println(judge.findJudge(2, ex1));
        System.out.println(judge.findJudge(3, ex2));
        System.out.println(judge.findJudge(3, ex3));
        System.out.println(judge.findJudge(3, ex4));
        System.out.println(judge.findJudge(4, ex5));
        System.out.println(judge.findJudge(1, ex6));
        System.out.println(judge.findJudge(1, ex7));
        System.out.println(judge.findJudge(2, ex7));
    }
}
