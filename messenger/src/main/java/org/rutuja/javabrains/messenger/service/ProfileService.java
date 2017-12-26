package org.rutuja.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.rutuja.javabrains.messenger.database.DatabaseClass;
import org.rutuja.javabrains.messenger.model.Message;
import org.rutuja.javabrains.messenger.model.Profile;

public class ProfileService {

private static HashMap<String, Profile> profiles = DatabaseClass.getProfiles();

public ProfileService(){
	profiles.put("Rutuja", new Profile(1L, "Rutuja", "Rutuja", "Kadam"));
	profiles.put("Viraj", new Profile(2L, "Viraj", "Viraj", "Nimbalkar"));
}
	
	
	public ArrayList<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;		
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
			return profile;
	}
	
	public Profile removeProfile(String profileName){
		 return profiles.remove(profileName);
	}

}
