package voiceMail;

/**
 * 
 * @author Justin
 *Connects phone to mail system. Purpose is to keep
 *track of the state of a connection
 */
public class Connection {
	
	/**
	 * Construct a Connection object
	 * @param s a mailSystem object
	 * @param p a telephone object
	 * 
	 */
	public Connection(MailSystem s, Telephone p){
		
		system = s; 
		phone = p;
		resetConnection();
		
	}
	
	/**
	 * Respone to the users pressing a key on the phone touchpad
	 * @param key the phone key pressed by the user
	 */
	public void dial(String key){
		
		if(state==CONNECTED)
			connect(key);
		else if(state==RECORDING)
			login(key);
		else if(state==CHANGE_PASSCODE)
			changePasscode(key);
		else if(state==CHANGE_GREETING)
			changeGreeting(key);
		else if(state==MAILBOX_MENU)
			mailboxMenu(key);
		else if (state==MESSAGE_MENU)
			messageMenu(key);
		
	}
	
	/**
	 * Record voice
	 * @param voice spoken by user
	 * 
	 */
	public recordVoice(String voice){
		
		if(state==RECORDING || state==CHANGE_GREETING )
			currentRecording += voice;
		
	}
	
	/**
	 * user hangs up the phone
	 * 
	 */
	public void hangup(){
		
		if(state==RECORDING){
			currentMailbox.addMessage(new Message(voice));
		}
	}
	
	/**
	 * reset connection to inital stae and prompt for mailbox number
	 * 
	 */
	private void resetConnection(){
		
		currentRecording="";
		accumulatedKeys="";
		state=CONNECTED;
		phone.speak(INITIAL_PROMPT);
		
	}
	
	/**
	 * try to connect the user with the specified mailbox
	 * @param key the phone key pressed by the user
	 * 	 
	 */
	private void connect(String key){
		
		if(key.equals("#")){
			currentMailbox = system.findMailbox(accumulatedKeys);
			
			if(currentMailbox!=null){
				state = RECORDING;
				phone.speak(currentMailbox.getGreeting());
			}
			else
				phone.speak("Incorrect mailbox number");
		}
		
		
	}
	private MailSystem system;
	private Mailbox currentMailbox;
	Telephone phone;
	
	private int state;
	private String key;
	private String voice;
}
