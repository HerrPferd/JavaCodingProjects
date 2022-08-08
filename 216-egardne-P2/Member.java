import java.util.*; 

public class Member extends Person {
	private String memberID;
	private ArrayList<Book> borrowedBooks;
	
	public Member(String fN, String lN, Address adr, String id, ArrayList<Book> books) {
		super(fN, lN, adr);
		memberID = id;
		borrowedBooks = books;
	}
	
	public Member() {
		super();
		memberID = null;
		borrowedBooks = null;
	}
	
	public String getMemberId() {return memberID;}
	public ArrayList<Book> getBorrowedBooks() {return borrowedBooks;}
	
	public void setMemberId(String id) {memberID = id;}
	public void setBorrowedBooks(ArrayList<Book> books) {borrowedBooks = books;}
	
	public void borrowBooks(Book book) {
		borrowedBooks.add(book);
	}
	
	public void returnBooks(Book book) {
		borrowedBooks.remove(book);
	}
	
	public void listBorrowedBooks() {
		for(Book e : borrowedBooks) {
			System.out.printf("%-10s %-20s %-20s %-10d\n", e.getBookID(), e.getTitle(), e.getAuthor(), e.getPublicationYear());
		}
	}
	
	public String toString() {
		String out = memberID + " " + super.toString();
		return out;
	}
}