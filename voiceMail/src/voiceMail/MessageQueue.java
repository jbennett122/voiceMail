package voiceMail;

import java.util.ArrayList;

/**
 * 
 * @author Justin
 * A first in first out collection of messages. 
 *
 */
public class MessageQueue {
	
	/**
	 * 
	 * Constructs an empty message queue
	 * 
	 */

	public MessageQueue(){
		
		queue = new ArrayList<Message>();
		
	}
	
	/**
	 * Remove messages from head of queue
	 */
	public Message remove(){
		
		queue.remove(0);
				
	}
	
	/**
	 * append messages to end of queue
	 * 
	 */
	public void Add(Message newMessage){
		
		queue.add(newMessage);		
		
	}
	
	/**
	 * Get the total number of messages in the queue
	 * 
	 */
	public int size(){
		
		return queue.size();
		
	}
	
	/**
	 * Get message at head of queue
	 * @return message that is at head or null if the ArrayList is empty
	 */
	public Message peek(){
		
		if(queue.size()==0){
			return null;
		}
		else return queue.get(0);
		
	}
	
	
	private ArrayList<Message> queue;
}
