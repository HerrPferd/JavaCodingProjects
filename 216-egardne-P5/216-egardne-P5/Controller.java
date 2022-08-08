import java.util.*;

public class Controller implements Signalable<Drone> {

	public List<Coordinate> tokens;
	
	public Controller() { //creates new controller object, initializing tokens list of Coordinates
		tokens = new ArrayList<Coordinate>();
	}
	
	public int count() { //getter for tokens size
		return tokens.size();
	}
	
	public List<Coordinate> getCoords(){ //getter for tokens
		return tokens;
	}
	
	public void signal(Drone d) { //inherited abstract method from Signalable, adds signaled grid space to tokens if tokens does not already contain given grid space
		try {
			for(Coordinate e : tokens){
				if(e.toString().equals(d.getPosition().toString()))
					throw new Exception();
			}
			tokens.add(d.getPosition());
		}
		catch(Exception e) {}
	}

}
