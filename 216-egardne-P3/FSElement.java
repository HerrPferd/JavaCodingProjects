
public interface FSElement { //interface to be implemented in other classes
	public String name();
	public void rename(String name);
	public void validate() throws Exception;
}
