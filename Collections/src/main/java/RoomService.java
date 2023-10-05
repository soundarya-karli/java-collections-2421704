
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
//import java.util.Iterator;



public class RoomService {
   private Collection<Room> roomInventory;

	public RoomService() {
		
	// 2. Initialize Collection and assign it to the Room Inventory
    this.roomInventory=new ArrayList<>();
	}

	public void applyDiscount(final double discount) {
		
		//Reduces the rate of each room by the provided discount
		/*Iterator<Room> it=this.roomInventory.iterator();
		while(it.hasNext()){
			Room r=it.next();
			r.setRate(r.getRate()-discount);
		}*/
		
		roomInventory.stream().forEach(r->r.setRate(r.getRate()-(discount*r.getRate())));
	}

	public Collection<Room> getRoomsByCapacity(final int requiredCapacity) {
		
		//Returns a new collection of rooms that meet or exceed the provided capacity
		
		return roomInventory.stream().
		filter(r->r.getCapacity()>=requiredCapacity).
		collect(Collectors.toList());
		
	}

	public Collection<Room> getRoomByRateAndType(final double rate, final String type){
	
		//Returns a new collection of rooms with a rate below the provided rate and that match the provided type
		
		return roomInventory.stream()
							.filter(r->r.getType().equals(type) && r.getRate()<=rate)
							.collect(Collectors.toList());
		
	}
    public boolean hasRoom(Room room) {
		
		// 1. Returns a boolean that indicates if the Room Inventory contains a Room.
			
			return this.roomInventory.contains(room);
		}
	public Room[] asArray() {
		
			// 2. Returns all Rooms as an Array of Rooms in the **order** they were Added.
			return this.roomInventory.toArray(new Room[0]);
			}
	public Collection<Room> getByType(String type){

				/*
				   3. Return a new Collection of Rooms where Room#type matches the provided String.
					  The original Room Inventory collection MUST NOT BE MODIFIED.
				*/
					
		return roomInventory.stream().filter(r->r.getType().equals(type)).collect(Collectors.toList());
	}

	public Collection<Room> getInventory(){
		
	// 3. Return the Room Inventory
		
		return new HashSet<>(this.roomInventory);
	}
	
		
	
	public void createRoom(String name, String type, int capacity, double rate) {
	
	// 4. Add a new Room to the Room Inventory using the provided parameters
    Room r=new Room(name,type,capacity,rate);
    this.roomInventory.add(r);

	}

	public void createRooms(Room[] rooms) {
	
	// 5. Add the Rooms provided in the Array to the Room Inventory
    this.roomInventory.addAll(Arrays.asList(rooms));

	}
	
	public void removeRoom(Room room) {
		
	// 6. Remove the provided Room from the Room Inventory
    this.roomInventory.remove(room);

	}
}
