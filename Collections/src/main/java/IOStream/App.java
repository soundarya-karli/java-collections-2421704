package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String args[]){
        FileInputStream fs=null;
        try {
            fs=new FileInputStream("/workspaces/java-collections-2421704/Collections/src/main/java/testSample.txt");
            System.out.println("File opened!");
            int i;
            while((i=fs.read())!=-1){
                System.out.print((char)i);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}    
}
    
}

