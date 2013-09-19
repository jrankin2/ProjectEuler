/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problem081;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.datbear.fileservice.FileReaderStrategy;
import net.datbear.fileservice.FileService;
import net.datbear.fileservice.FileWriterStrategy;
import net.datbear.fileservice.FormatStrategy;
import net.datbear.fileservice.impl.TextFileReader;
import net.datbear.fileservice.impl.TextFileWriter;
import static projecteuler.ProjectEulerUtil.listToArray;
import projecteuler.problem018.TreeFormatStrategy;

/**
 *
 * @author jrankin2
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = getMatrixFromFile("src/projecteuler/problem081/matrixExample.txt");
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        
        System.out.println(minPathSum(matrix));
        
    }
    
    private static int[][] getMatrixFromFile(String path){
        int[][] matrix;
        List<int[]> matrixList = new ArrayList<int[]>();
        
        FileReaderStrategy<String> tfr = new TextFileReader(path);
        FileWriterStrategy<String> tfw = new TextFileWriter(path, false);

        FormatStrategy<String, int[]> tfs = new TreeFormatStrategy();
        FileService<String, int[]> fs = new FileService<String, int[]>(tfr, tfw, tfs, tfs);

        try {
            matrixList = fs.readFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        matrix = listToArray(matrixList);
        
        return matrix;
    }

    public static int minPathSum(int[][] tree) {
        int[][] minMatrix = new int[tree.length][tree[tree.length - 1].length];

        for (int i = 0; i < tree.length; i++) {//row
            for (int j = 0; j < tree[i].length; j++) {//column
                minMatrix[i][j] = minSubPath(i, j, minMatrix, tree);
                //System.out.printf("Min to path %d,%d = %d\n", i, j, minMatrix[i][j]);
            }
        }

        int min = Integer.MAX_VALUE;
        int current;
        for (int i = 0; i < minMatrix[minMatrix.length - 1].length; i++) {
            current = minMatrix[minMatrix.length - 1][i];
            if (current < min) {
                min = current;
            }
        }

        return min;
    }

    /**
     * Calculate the maximum path sum from the top of the tree to
     * i,j(row,column)
     *
     * @param i row
     * @param j column
     * @param minMatrix tree containing max path sums
     * @param matrix tree containing original values
     * @return max path sum to i,j (row,column) in the tree
     */
    public static int minSubPath(int i, int j, int[][] minMatrix, int[][] matrix) {
        int min = matrix[i][j];
        
        min += Math.min(minMatrix[Math.max(i-1, 0)][j], minMatrix[i][Math.max(j-1, 0)]);
        System.out.println("i:"+i+",j:"+j+", min:"+min);
        /*
        if (i > 0) {
            if (j > 0) {
                
                //min += Math.min(minMatrix[i - 1][j - 1], minMatrix[i - 1][j]);
            } else {
                min += minMatrix[i - 1][j];
            }
        }
        */
        return min;
    }
}

//[i][j]
//[0][0]  [1][0]  [2][0]
//[0][1]  [1][1]  [2][1]