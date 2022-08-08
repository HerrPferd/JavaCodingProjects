
public class Librarian extends Person {
	private String employeeID;
 
 public Librarian(String fN, String lN, Address adr, String id) {
	 super(fN, lN, adr);
	 employeeID = id;
 }
 
 public Librarian() {
	 super();
	 employeeID = null;
 }
 
 public String getEmployeeId() {return employeeID;}
 
 public void setEmployeeId(String id) {employeeID = id;}
 
 public void registerBooks(Book book) {
	 Library.BookArray.add(book);
 }
 
 public boolean deleteBooks(Book book) {
	 return Library.BookArray.remove(book);
 }
 
 public void registerMember(Member member) {
	 Library.MemberList.add(member);
 }
 
 public boolean deleteMember(Member member) {
	 return Library.MemberList.remove(member);
 }
 
 public void listMembers() {
	 for(Member e : Library.MemberList) {
		 System.out.printf("%-10s %-10s %-10s %-10s \n", e.getMemberId(), e.getFirstName(), e.getLastName(), e.getAddress().getCity());
	 }
 }
 
 public void listBooks() {
	 for(Book e : Library.BookArray) {
		 System.out.printf("%-10s %-20s %-20s %-10d\n", e.getBookID(), e.getTitle(), e.getAuthor(), e.getPublicationYear());
	 }
 }
 
 public String toString() {
	 String out = employeeID + " " + super.toString();
	 return out;
 }
}
