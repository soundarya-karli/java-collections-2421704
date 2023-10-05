import java.util.*;

import javax.sql.rowset.Predicate;
public class App {
    /**
     * @param args
     */
    public static void main (String args[]){
        Room cam=new Room("Cambridge","Premiem Room",4,200.000);
         Room man=new Room("Manchester","Duplex Room",2,150.00);
          Room LA=new Room("LA","Suite",2,350.00);
           Room of=new Room("Oxford","Suite",5,500.00);
          Collection<Room> rooms=new ArrayList<>(Arrays.asList(cam,man,LA,of));
          LA.setPetFriendly(true);
          cam.setPetFriendly(true);
          rooms.stream()
              .filter(Room::isPetFriendly).forEach(r->System.out.println(r.getName()));
              double rate=rooms.stream().mapToDouble(Room::getRate).sum();
              System.out.println(rate);
          /*Iterator<Room> it=rooms.iterator();
          while(it.hasNext()){
            if(it.next().isPetFriendly()){
                it.remove();
            }
                   
          }
          rooms.stream().forEach(r->System.out.println(r.getName()));
         */
        }    
         
}

