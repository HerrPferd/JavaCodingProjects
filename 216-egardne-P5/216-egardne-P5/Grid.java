
public class Grid {
	private Boolean[][] grid;
	private int sizeX;
	private int sizeY;
	public Grid(int sizeX, int sizeY) { //Creates new grid object with a 2d array of booleans
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		grid = new Boolean[sizeY][sizeX];
		for(int y = 0; y < sizeY; y++) {
			for(int x = 0; x < sizeX; x++) {
				grid[y][x] = false;
			}
		}
	}
	
	public int sizeX() { //getter for int sizeX
		return this.sizeX;
	}
	
	public int sizeY() { //getter for int sizeY
		return this.sizeY;
	}
	
	public void setToken(Coordinate c) { //setter for boolean in 2d array grid, takes coordinate object, throws GridCoordsOutOfBoundsException
		try {
			grid[c.getY()][c.getX()] = true;
		}
		catch(Exception e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	public void setToken(int x, int y) { //setter for boolean in 2d array grid, takes two ints, throws GridCoordsOutOfBoundsException
		try {
			grid[y][x] = true;
		}
		catch(Exception e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	public void resetToken(Coordinate c) { //Setter for boolean in 2d array grid, takes Coordinate object, throws GridCoordsOutOfBoundsException
		try {
			grid[c.getY()][c.getX()] = false;
		}
		catch(Exception e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	public void resetToken(int x, int y) { //Setter for boolean in 2d array grid, takes two ints, throws GridCoordsOutOfBoundsException
		try {
			grid[y][x] = false;
		}
		catch(Exception e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	public boolean hasToken(int x, int y){ //Getter for boolean in 2d array grid, takes two ints, throws GridCoordsOutOfBoundsException
		try {
			return grid[y][x];
		}
		catch(Exception e) {
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	public boolean hasToken(Coordinate c){ //Getter for boolean in 2d array Grid, takes Coordinate objects
		try {
			return grid[c.getY()][c.getX()];
		}
		catch(Exception e) {
			throw new GridCoordsOutOfBoundsException();
			
		}
	}

}
