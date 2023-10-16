package IOStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class App {
    public static void main(String args[]){
        FileInputStream fs=null;
        FileOutputStream fos=null;
        try {
            fs=new FileInputStream("/workspaces/java-collections-2421704/Collections/src/main/java/testSample.txt");
            fos=new FileOutputStream("/workspaces/java-collections-2421704/Collections/src/main/java/testCopy.txt");
            System.out.println("File opened!");
            int i;
            while((i=fs.read())!=-1){
                System.out.print((char)i);
                fos.write(i);
            }
           
        } catch (FileNotFoundException e) {
         
            e.printStackTrace();
        }
     catch (IOException e) {

    e.printStackTrace();
}
finally{ 
    try {
        fs.close();
        fos.close();
    } catch (IOException e) {

        e.printStackTrace();
    }
}
System.out.println("File closed");    
}
    
}

