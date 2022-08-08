
public class Book {
	private String bookID;
	private String title;
	private String author;
	private int publicationYear;
	
	public Book(String id, String tle, String atr, int pubYear) {
		bookID = id;
		title = tle;
		author = atr;
		publicationYear = pubYear;
	}
	
	public Book() {
		bookID = null;
		title = null;
		author = null;
		publicationYear = 0;
	}
	
	public String getBookId() {return bookID;}
	public String getBookID() {return this.getBookId();}
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	public int getPublicationYear() {return publicationYear;}
	
	public void setBookId(String id) {bookID = id;}
	public void setTitle(String tle) {title = tle;}
	public void setAuthor(String atr) {author = atr;}
	public void setPublicationYear(int pubYear) {publicationYear = pubYear;}
}
