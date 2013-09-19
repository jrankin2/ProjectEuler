package projecteuler.problem067;

import projecteuler.problem018.*;
import java.util.ArrayList;
import java.util.List;
import net.datbear.fileservice.FileReaderStrategy;
import net.datbear.fileservice.FileService;
import net.datbear.fileservice.FileWriterStrategy;
import net.datbear.fileservice.FormatStrategy;
import net.datbear.fileservice.impl.TextFileReader;
import net.datbear.fileservice.impl.TextFileWriter;

import static projecteuler.ProjectEulerUtil.listToArray;

/**
 * @author Joe
 */
public class Main {

    public static void main(String[] args) {
        int[][] tree;
        List<int[]> treeList = new ArrayList<int[]>();
        String path = "src/projecteuler/problem067/tree.txt";
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
        System.out.println("The answer to problem 67: " + projecteuler.problem018.Main.maxPathSum(tree));

    }
}