import java.util.*;
public class App {
    public static void main (String args[]){
        Room cam=new Room("Cambridge","Premiem Room",4,200.000);
         Room man=new Room("Manchester","Duplex Room",2,150.00);
          Room LA=new Room("LA","Suite",2,350.00);
           Room of=new Room("Oxford","Suite",5,500.00);
          Collection<Room> rooms=List.of(cam,man,LA,of);
          Iterator<Room> iterator=rooms.iterator();
          while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
          }
          for (Room room : rooms) {
            System.out.println(room.getName());
          }
        }    
         
}

