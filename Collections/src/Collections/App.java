package Collections;

import java.util.*;
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

         Collection<Room> c=new ArrayList<>();
        // c.add("Music");
        // c.add("Dance");
        // c.add("Reading");
        // c.add("Music");
         c.add(new Room("Harvard","Duplex",3,200.0));
        // Collection<String> fav=new HashSet<>(c);
         c.stream().forEach(i->System.out.println(i.getName()));
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
