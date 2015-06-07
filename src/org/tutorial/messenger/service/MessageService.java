package org.tutorial.messenger.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.tutorial.messenger.database.MessageDatabase;
import org.tutorial.messenger.exception.DataNotFoundException;
import org.tutorial.messenger.model.Message;

public class MessageService {
	private Map<Long,Message> messages = MessageDatabase.getMessages();
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	}
	public Message getMessageByPath(Long messageId)
	{
		if(messages.get(messageId)!=null)
			return messages.get(messageId);
		else
			throw new DataNotFoundException("This record is not available currently: "+messageId);
	}
	public boolean addMessage(Message msg)
	{
		msg.setId(messages.size()+1L);
		msg.setDateCreated(new Date());
		messages.put(msg.getId(),msg);
		return true;
	}
	public boolean updateMessage(Long id, Message msg)
	{
//		messages.get(id).setMessage(msg.getMessage());
//		messages.get(id).setAuthor(msg.getAuthor());
//		messages.get(id).setDateCreated(new Date());
//		messages.get(id).setId(msg.getId());
		msg.setId(id);
		msg.setDateCreated(new Date());
		messages.put(id, msg);
		return true;
	}
	public boolean deleteMessage(Long id)
	{
		messages.remove(id);
		return true;
	}
	
	public MessageService()
	{
		messages.put(1L, new Message(1L,"Hi","harish"));
		messages.put(2L, new Message(2L,"Hello","harish"));
		messages.put(3L, new Message(3L,"How are you","harish"));
	}
}
