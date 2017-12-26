package org.rutuja.javabrains.messenger.service;
import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.rutuja.javabrains.messenger.database.DatabaseClass;
import org.rutuja.javabrains.messenger.model.Message;

public class MessageService {
	
	private static HashMap<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hello World!", "Rutuja"));
		messages.put(2L, new Message(2, "Hello jersey!", "Viraj"));
	}
	
	
	public ArrayList<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	
	public ArrayList<Message> getAllMessagesForYear(int year){
		ArrayList<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message:messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;		
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		 return messages.remove(id);
	}

}
