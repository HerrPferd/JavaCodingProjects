
public class SubmitFolder implements FSFilter {
	private String assignment;
	private IDInfo id;
	private String directoryName;
	
	public SubmitFolder(String assignment, IDInfo id) { //Constructor initialized assignment, id, and directoryName
		this.assignment = assignment;
		this.id = id;
		directoryName = id.getLab() + "_" + id.getUserId() + "_" + this.assignment;
	}
	
	public FSElement process(FSElement elem) throws Exception{ //Processes directory in accordance with the perameters given in Project3.html
		Directory def = new Directory(); //creates new default directory def
		if(elem instanceof Directory) { //determines if elem is a directory object
			if(((Directory) elem).isDefault()) { //determines if elem is a default directory
				elem.rename(directoryName); //renames elem to directoryName
				def.add(elem); //adds elem to def
			}
			else {
				Directory nonDef = new Directory(directoryName); //creates new directory nonDef with name directoryName
				nonDef.add(elem); //adds elem to nonDef
				def.add(nonDef); //adds nonDef to def
			}
		}
		else {
			Directory fileDir = new Directory(directoryName); //creates new directory fileDir with name directoryName
			fileDir.add(elem); //adds elem to fileDir
			def.add(fileDir); //adds fileDir to def
		}
		return def; //Returns def
	}
}
