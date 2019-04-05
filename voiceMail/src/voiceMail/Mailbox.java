package voiceMail;

//A mailbox that contains messages that can be listed, saved or deleted
public class Mailbox {
	
	/**
	 * Creates mailbox object
	 * @param aPasscode passcode number
	 * @param aGreeting greeting string
	 */
	public Mailbox(String aPasscode, String aGreeting){
		
		passcode= aPasscode;
		greeting=aGreeting;
		newMessages= new MessageQueue();
		savedMessages= new MessageQueue();
		
	}

	
	/**
	 * Checks to see if passcode is correct
	 * 
	 */
	public boolean checkPassCode(String aPasscode){
		
		return aPasscode.equals(passcode);
		
	}
	
	/**
	 * Add a message to the mailbox
	 * @param aMessage to be added to the mailbox
	 * 
	 */
	public void addMessage(Message aMessage){
		
		newMessages.Add(aMessage);
				
	}
	
	/**
	 * Get current message
	 * @return the current message
	 * 
	 */
	public Message getCurrentMessage(){
		
		if(newMessages.size()>0) 
			return newMessages.peek();
		else if (savedMessages.size()>0) 
			return savedMessages.peek();
		else 
			return null;
		
	}
	
	/**
	 * Remove the current message from the mailbox
	 * @return the message that has been removed
	 * 
	 */
	public Message removeCurrentMessage(){
		
		if(newMessages.size()>0)
			return newMessages.remove();
		else if(savedMessages.size()>0)
			return savedMessages.remove();
		else
			return null;
		
	}
	
	/**
	 * save the current message
	 * 
	 */
	public void saveCurrentMessage(){
		
		Message m = removeCurrentMessage();
		if(m!=null){
			savedMessages.Add(m);
		}
	}
	/**
	 * Set new greeting
	 * @param newGreeting the new greeting String
	 * 
	 */
	public void setGreeting(String newGreeting){
		
		greeting= newGreeting;
	}
		
	/**
	 * Change passcode
	 * @param newPasscode 
	 */
	public void setPasscode(String newPasscode){
		
		passcode= newPasscode;
	}
	
	/**
	 * Get greeting
	 * @return greeting
	 * 
	 */
	public String getGreeting(){
		
		return greeting;
	}
	
	
	private String passcode;
	private String greeting;
	private MessageQueue newMessages;
	private MessageQueue savedMessages;
}
