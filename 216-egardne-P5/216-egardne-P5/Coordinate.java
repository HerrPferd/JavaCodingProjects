
public final class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate(int x, int y) { //creates coordinate object that takes two ints
		this.x = x;
		this.y = y;
	}
	
	public int getX() { //getter for x
		return x;
	}
	
	public int getY() { //getter for y
		return y;
	}
	
	public Coordinate plus(int dx, int dy) { //adds dx to x and adds dy to y
		Coordinate out = new Coordinate(this.x + dx, this.y + dy);
		return out;
	}
	
	public Coordinate plus(Coordinate delta) { //adds delta's x to x, and adds delta's y to y
		Coordinate out = new Coordinate(delta.getX() + this.x, delta.getY() + this.y);
		return out;
	} 
	
	public String toString() { //Override, returns string formatted "(x, y)"
		return "(" + this.x + ", " + this.y + ")";
	}
	
	public Coordinate plus(Direction d) { //adds Coordinate from d.delta() to x and y using method plus(Coordinate delta)
		return this.plus(d.delta());
	}

}
