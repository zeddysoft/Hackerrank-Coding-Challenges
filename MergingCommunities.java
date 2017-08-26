
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Azeez.Taiwo
 * @urlToQuestion https://www.hackerrank.com/challenges/merging-communities
 */
public class MergingCommunities {

    static int[] p;
    static int[] communitySize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] d = sc.nextLine().split(" ");
        int n = Integer.parseInt(d[0]);
        int q = Integer.parseInt(d[1]);

        p = new int[n + 1];
        communitySize = new int[n + 1];
        initP();

        for (int a = 0; a < q; ++a) {
            String[] data = sc.nextLine().split(" ");
            if (data[0].equals("Q")) {
                System.out.println(findCommunitySizeOf(Integer.parseInt(data[1])));
            } else {
                int i = Integer.parseInt(data[1]);
                int j = Integer.parseInt(data[2]);
                union(i, j);
            }
        }

    }

    private static void union(int i, int j) {
        int iRoot = root(i);
        int jRoot = root(j);

        if (iRoot != jRoot) {
            p[iRoot] = jRoot;
            int p = communitySize[jRoot];
            
            communitySize[jRoot] = communitySize[iRoot] +p;
        }

    }

    public static int root(int personId) {
        while (personId != p[personId]) {
            personId = p[personId];
            p[personId] = p[p[personId]];
        }
        return personId;
    }

    private static int findCommunitySizeOf(int personId) {
        
        return communitySize[root(personId)];
    }

    private static void initP() {
        for (int i = 1; i < p.length; ++i) {
            p[i] = i;
            communitySize[i] = 1;
        }
    }
}
