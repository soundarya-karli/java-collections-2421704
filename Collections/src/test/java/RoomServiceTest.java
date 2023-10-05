import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomServiceTest {

	RoomService service;
	Room[] rooms;

	@BeforeEach
	void setUp() throws Exception {

		
		Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room manchester = new Room("Manchester", "Suite", 5, 250.00);
		Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room oxford = new Room("Oxford", "Suite", 5, 225.0);
		Room victoria = new Room("Victoria", "Suite", 5, 225.00);
		Room westminister = new Room("Westminister", "Premiere Room", 4, 200.00);

		this.rooms = new Room[] { cambridge, manchester, piccadilly, oxford, victoria, westminister };
		this.service = new RoomService();
		this.service.createRooms(rooms);
	}

	@Test
	void testApplyDiscount() {

		this.service.applyDiscount(.10);
		assertEquals(157.5, rooms[0].getRate());
		assertEquals(225, rooms[1].getRate());
		assertEquals(112.5, rooms[2].getRate());
		assertEquals(202.5, rooms[3].getRate());
		assertEquals(202.5, rooms[4].getRate());
		assertEquals(180, rooms[5].getRate());
	}

	@Test
	void testGetRoomsByCapacity() {

		Collection<Room> roomsWithCapacity = this.service.getRoomsByCapacity(4);

		assertTrue(roomsWithCapacity.containsAll(Arrays.asList(rooms[0], rooms[1], rooms[3], rooms[4], rooms[5])));
	}
	
	@Test
	void testgetRoomByRateAndType() {
		Collection<Room> roomsWithRateAndType = this.service.getRoomByRateAndType(190.00, "Premiere Room");
		assertTrue(roomsWithRateAndType.contains(rooms[0]));
		assertFalse(roomsWithRateAndType.contains(rooms[1]));
		assertFalse(roomsWithRateAndType.contains(rooms[2]));
		assertFalse(roomsWithRateAndType.contains(rooms[3]));
		assertFalse(roomsWithRateAndType.contains(rooms[4]));
		assertFalse(roomsWithRateAndType.contains(rooms[5]));
	}
}

	/*@BeforeEach
	void setUp() throws Exception {

		this.service = new RoomService();

		this.service.createRoom("Piccadilly", "Guest Room", 3, 125.00);
		this.service.createRoom("Cambridge", "Premiere Room", 3, 175.00);
		this.service.createRoom("Victoria", "Suite", 5, 225.00);
		this.service.createRoom("Westminister", "Premiere Room", 4, 200.00);

	}
	@Test
	void testHasRoom() {

		assertFalse(this.service.hasRoom(this.manchester));
		assertTrue(this.service.hasRoom(this.cambridge));
	}
	@Test
	void testAsArray() {
		
		Room[] rooms = this.service.asArray();

		assertEquals(4, rooms.length);
		assertEquals(this.piccadilly, rooms[0]);
		assertEquals(this.cambridge, rooms[1]);
		assertEquals(this.victoria, rooms[2]);
		assertEquals(this.westminister, rooms[3]);

	}
	@Test
	void testGetByType() {
		
		Collection<Room> guestRooms = this.service.getByType("Premiere Room");

		assertEquals(2, guestRooms.size());
		assertTrue(guestRooms.stream()
				.allMatch(r -> r.getType().equals("Premiere Room")));
		assertEquals(4, this.service.getInventory().size());

	}

	/*@Test
	void testCreateRoom() {

		this.service.createRoom("Westminister", "Premiere Room", 4, 200.00);

		assertEquals(4, this.service.getInventory().size());
	}

	@Test
	void testCreateRooms() {
		Room[] newRooms = { this.westminister, this.oxford, this.manchester };

		this.service.createRooms(newRooms);

		assertEquals(6, this.service.getInventory().size());
	}

	@Test
	void testRemoveRoom() {

		this.service.removeRoom(new Room("Victoria", "Suite", 5, 225.00));

		assertEquals(2, this.service.getInventory().size());
		assertFalse(this.service.getInventory().contains(victoria));
	}

	@Test
	void testGetInventory() {
		assertNotNull(this.service.getInventory());
	}*/ 

//}