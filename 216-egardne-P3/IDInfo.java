
public class IDInfo {
	private String name;
	private String userId;
	private String gNum;
	private String lecture;
	private String lab;
	
	public IDInfo(String name, String userId, String gNum, String lecture, String lab) {
		this.name = name;
		this.userId = userId;
		this.gNum = gNum;
		this.lecture = lecture;
		this.lab = lab;
	}
	
	public String getName() {return name;}
	public String getUserId() {return userId;}
	public String getGNum() {return gNum;}
	public String getLecture() {return lecture;}
	public String getLab() {return lab;}
}
