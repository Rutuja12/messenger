package org.rutuja.javabrains.messenger.database;

import java.util.HashMap;

import org.rutuja.javabrains.messenger.model.Message;
import org.rutuja.javabrains.messenger.model.Profile;

public class DatabaseClass {
	
	private static HashMap<Long, Message> messages = new HashMap<>();
	private static HashMap<String, Profile> profiles = new HashMap<>();
	
	
	public static HashMap<Long, Message> getMessages(){
		return messages;
	}
	
	public static HashMap<String, Profile> getProfiles(){
		return profiles;
		
	}
}
