import java.util.*;
public class App {
    /**
     * @param args
     */
    public static void main (String args[]){
        List<Integer> nums=Arrays.asList(50,100,80,500,200,150,20,800);
        NavigableSet<Integer> numset=new TreeSet<>(nums);
        numset.subSet(100,500).stream()
              .forEach(System.out::println);





       /* Room cam=new Room("Cambridge","Premiem Room",4,200.000);
         Room man=new Room("Manchester","Duplex Room",2,150.00);
          Room LA=new Room("LA","Suite",2,350.00);
           Room of=new Room("Oxford","Suite",5,500.00);
           Room ofDuplicate=new Room("Oxford","Suite",5,500.00);
          // Set<Room> other=Set.of(LA,cam);
           //other.add(man);
           Set<Room> set=new LinkedHashSet<>();
           set.add(cam);
           set.add(of);
           set.add(man);
           set.add(of);
           set.add(ofDuplicate);
           set.add(LA);

           Set<Room> more=Set.copyOf(set);
           more.stream()
            .map(r->r.getName())
            .forEach(System.out::println);

          /*Collection<Room> rooms=new ArrayList<>(Arrays.asList(cam,man,LA,of));
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

