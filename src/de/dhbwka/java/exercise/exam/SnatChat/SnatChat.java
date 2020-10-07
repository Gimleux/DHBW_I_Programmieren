package de.dhbwka.java.exercise.exam.SnatChat;
public class SnatChat {
	
	public static void main(String[] args) {
		SnatChatRoom room = new SnatChatRoom("GansGeheim");
		
		room.register( new SnatChatWindow(room, new Account("Bob") ) );
		room.register( new SnatChatWindow(room, new Account("Alice") ) );
	}
	
}
