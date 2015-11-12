package cards;

public class Card {
	
	private final Suit suit;
	private final Value value;
	
	public Card(Suit s,Value v){
		suit=s;
		value=v;
				
	}
	
	public String toString(){
		
		return value + " of "+ suit;
	}
	

}
