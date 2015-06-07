package org.tutorial.messenger.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.tutorial.messenger.model.Message;
import org.tutorial.messenger.service.MessageService;

@Path("/messages")
public class MessengerResource {
	private MessageService msgService=new MessageService();
	
	
	// produces xml content
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getAllMessages()
	{
//		System.out.println(uriinfo.getAbsolutePath().toString());
		return msgService.getAllMessages();
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessagesJson()
	{
//		System.out.println(uriinfo.getAbsolutePath().toString());
		return msgService.getAllMessages();
	}
	
	
	@GET
	@Path("/bean")
	public String getAllMessagesBeanParam(@BeanParam Message msg)
	{
		return msg.getId()+" "+msg.getMessage()+" "+msg.getAuthor();
	}
	
	@GET
	@Path("/uri")
	public String getURI(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders)
	{
		return uriInfo.getAbsolutePath().toString()+" "+httpHeaders.getHeaderString("messageId");
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_XML)
	public Message getMessageByPathByPath(@PathParam("messageId") Long messageId)
	{
		return msgService.getMessageByPath(messageId);
	}
	
	@GET
	@Path("/query")
	@Produces(MediaType.TEXT_XML)
	public Message getMessageByPathByQuery(@QueryParam("messageId") Long messageId)
	{
		return msgService.getMessageByPath(messageId);
	}
	
	@GET
	@Path("/matrix")
	@Produces(MediaType.TEXT_XML)
	public Message getMessageByPathByMatrix(@MatrixParam("messageId") Long messageId)
	{
		return msgService.getMessageByPath(messageId);
	}
	
	@GET
	@Path("/header")
	@Produces(MediaType.TEXT_XML)
	public Message getMessageByPathByHeader(@HeaderParam("messageId") Long messageId)
	{
		return msgService.getMessageByPath(messageId);
	}
	
	@GET
	@Path("/cookie")
	@Produces(MediaType.TEXT_XML)
	public Message getMessageByPathByCookie(@CookieParam("messageId") Long messageId)
	{
		return msgService.getMessageByPath(messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addMessage(Message msg,@Context UriInfo uriInfo) throws URISyntaxException
	{
		boolean result=msgService.addMessage(msg);
		return Response.created(new URI(uriInfo.getAbsolutePath().toString())).status(javax.ws.rs.core.Response.Status.CREATED).entity(result).build();
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean updateMessage(@PathParam("messageId")Long id, Message msg)
	{
	 	return msgService.updateMessage(id, msg);
	}
	@DELETE
	@Path("/{msgId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteMessage(@PathParam("msgId") Long id)
	{
		return msgService.deleteMessage(id);
	}

}
