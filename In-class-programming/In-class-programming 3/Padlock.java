public class Padlock{
	
	private boolean state;
	private String key;
	private final String DEFAULT_KEY = "0000";
	
	private boolean OPEN;
	private boolean CLOSED;
	
	public Padlock(){
		OPEN = true;
		CLOSED = !OPEN;
		state = OPEN;
		key = DEFAULT_KEY;
	}
	
	public Padlock(String aKey){
		OPEN = true;
		CLOSED = !OPEN;
		if(aKey==null || aKey.length()==0){
			
			key = DEFAULT_KEY;
			
		}
		else{
			key = aKey;
		}
		state = OPEN;
	}
	
	
	public void close(){
		if(state == OPEN){
			state = CLOSED;
		}
		
		
	}
	
	
	public void open(String aKey){
		if(state == CLOSED && aKey.equals(key)){
				
				state = OPEN;
				
			
			
		}
		
		
	}
	
	public void setCombination(String oldKey, String newKey){
		
		if(oldKey== key && newKey != null && !newKey.equals("")){
			
			key = newKey;
			
		}
		
	}
	
	public String toString(){
		String stateString;
		if(state == OPEN){
			stateString = "Open";
		}
		else{stateString = "Closed";}
		
		return "Padlock is "+stateString+", combination is "+ key;
	}
	
	
}