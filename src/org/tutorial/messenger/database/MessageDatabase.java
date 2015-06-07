package org.tutorial.messenger.database;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Path;

import org.tutorial.messenger.model.Message;

@Path("/messages")
public class MessageDatabase {
	private static Map<Long, Message> messages=new HashMap<>();
	public static Map<Long,Message> getMessages()
	{
		return messages;
	}
	
}
