package projecteuler.problem018;

import java.util.ArrayList;
import java.util.List;
import net.datbear.fileservice.FileReaderStrategy;
import net.datbear.fileservice.FileService;
import net.datbear.fileservice.FileWriterStrategy;
import net.datbear.fileservice.FormatStrategy;
import net.datbear.fileservice.impl.TextFileReader;
import net.datbear.fileservice.impl.TextFileWriter;

/**
 * @author Joe
 * 
 * Some of the methods in this class are public solely so that they can be used 
 * by other problems (Problem 67).
 * 
 * Problem Description:
 * By starting at the top of the triangle below and moving to adjacent numbers 
 * on the row below, the maximum total from top to bottom is 23.
 * 
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 */
public class Main {

    public static void main(String[] args) {
        int[][] tree;
        List<int[]> treeList = new ArrayList<int[]>();
        String path = "src/projecteuler/problem018/tree.txt";
        FileReaderStrategy<String> tfr = new TextFileReader(path);
        FileWriterStrategy<String> tfw = new TextFileWriter(path, false);

        FormatStrategy<String, int[]> tfs = new TreeFormatStrategy();
        FileService<String, int[]> fs = new FileService<String, int[]>(tfr, tfw, tfs, tfs);
        try {
            treeList = fs.readFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        tree = listToArray(treeList);
        System.out.println("The answer to problem 18: " + maxPathSum(tree));

    }

    public static int[][] listToArray(List<int[]> list) {
        System.out.println(list);
        int[][] array = new int[list.size()][list.get(list.size() - 1).length];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Calculate the maximum path sum from top to bottom of the tree.
     *
     * @param tree the tree
     * @return maximum path sum from top to bottom
     */
    public static int maxPathSum(int[][] tree) {
        int[][] maxTree = new int[tree.length][tree[tree.length - 1].length];

        for (int i = 0; i < tree.length; i++) {//row
            for (int j = 0; j < tree[i].length; j++) {//column
                maxTree[i][j] = maxPath(i, j, maxTree, tree);
                //System.out.printf("Max to path %d,%d = %d\n", i, j, maxTree[i][j]);
            }
        }

        int max = 0;
        int current;
        for (int i = 0; i < maxTree[maxTree.length - 1].length; i++) {
            current = maxTree[maxTree.length - 1][i];
            if (current > max) {
                max = current;
            }
        }

        return max;
    }

    /**
     * Calculate the maximum path sum from the top of the tree to
     * i,j(row,column)
     *
     * @param i row
     * @param j colum
     * @param maxTree tree containing max path sums
     * @param tree tree containing original values
     * @return max path sum to i,j (row,column) in the tree
     */
    public static int maxPath(int i, int j, int[][] maxTree, int[][] tree) {
        int max = tree[i][j];
        if (i > 0) {
            if (j > 0) {
                max += Math.max(maxTree[i - 1][j - 1], maxTree[i - 1][j]);
            } else {
                max += maxTree[i - 1][j];
            }
        }
        return max;
    }
}