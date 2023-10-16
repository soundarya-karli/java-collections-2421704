package IOStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferReader {
    public static void main(String args[]) throws IOException{
    FileReader fr=null;
    BufferedReader br=null;
    int count=0;

    fr=new FileReader("/workspaces/java-collections-2421704/Collections/src/main/java/testSample.txt");
    br=new BufferedReader(fr);
    String line;
    while((line=br.readLine())!=null){
        StringTokenizer s=new StringTokenizer(line);
        while(s.hasMoreTokens()){
            System.out.println(s.nextToken());
            count++;
        }
    }
    System.out.println("\nCount="+count);
    }
}
