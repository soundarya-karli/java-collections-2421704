package Collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
public class App {
    public static void main (String args[]){
        Room cam=new Room("Cambridge","Premiem Room",4,200.000);
         Room man=new Room("Manchester","Duplex Room",2,150.00);
          Room LA=new Room("LA","Suite",2,350.00);
           Room of=new Room("Oxford","Suite",5,500.00);
          Collection<Room> rooms=List.of(cam,man,LA,of);
         double res=getRevenue(rooms);
        System.out.println(res);

         Contract con=new Implementation();
         printTerms(con);

         Collection<String> c=new ArrayList<>();
         c.add("Music");
         c.add("Dance");
         c.add("Reading");
         c.add("Music");
         System.out.println(c);
    }
    public static double getRevenue(Collection<Room> r){
        return r.stream()
                .mapToDouble(ro -> ro.getRate())
                .sum();
    }
    private static void printTerms(Contract con){
        con.term1();
        con.term2();
        con.extendedTerm();
    }
}
