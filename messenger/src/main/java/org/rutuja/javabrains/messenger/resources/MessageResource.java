package org.rutuja.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.rutuja.javabrains.messenger.model.Message;
import org.rutuja.javabrains.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageservice = new MessageService();
	
	/**
	 * GET endpoint for getting all the messages
	 * @param year
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@QueryParam("year") int year){
		if(year>0){
			return messageservice.getAllMessagesForYear(year);
		}
		return messageservice.getAllMessages();
	}
	
	/**
	 * GET endpoint for getting message with specific id
	 * @param messageId
	 * @return
	 */
	@GET
	@Path("/{messageId}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Message geMessage(@PathParam("messageId") long messageId){
		return messageservice.getMessage(messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
	  return messageservice.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
	  return messageservice.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id){
	  messageservice.removeMessage(id);
	}
	
	
	
}
