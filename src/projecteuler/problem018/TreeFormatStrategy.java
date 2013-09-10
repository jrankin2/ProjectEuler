package projecteuler.problem018;

import java.util.ArrayList;
import java.util.List;
import net.datbear.fileservice.FormatStrategy;

/**
 * @author Joe
 */
public class TreeFormatStrategy implements FormatStrategy<String, int[]>{

    @Override
    public List<String> encode(List<int[]> decodedLines) {
        List<String> encodedLines = new ArrayList<String>();
        StringBuilder sb;
        for(int[] dLine : decodedLines){
            sb = new StringBuilder();
            for(int i = 0; i < dLine.length; i++){
                if(i != 0){
                    sb.append(" ");
                }
                sb.append(dLine[i]);
            }
            encodedLines.add(sb.toString());
        }
        return encodedLines;
    }

    @Override
    public List<int[]> decode(List<String> encodedLines) {
        List<int[]> decodedLines = new ArrayList<int[]>();
        String[] eLineSplit;
        int[] dLine;
        for(String eLine : encodedLines){
            eLineSplit = eLine.split(" ");
            dLine = new int[eLineSplit.length];
            for(int i = 0; i < eLineSplit.length; i++){
                dLine[i] = Integer.valueOf(eLineSplit[i]);
                //System.out.println(dLine[i]);
            }
            decodedLines.add(dLine);
        }
        return decodedLines;
    }



}
