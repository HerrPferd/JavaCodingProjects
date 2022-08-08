
public class FileInserter implements FSFilter {
	private FSElement file;
	
	public FileInserter(FSElement file) {
		this.file = file;
	}
	
	public FSElement process(FSElement elem) throws Exception{ //inserts file into directory, throws exception if trying to insert file into non-directory
		if(elem instanceof Directory)
			((Directory) elem).add(file);
		if(elem instanceof Directory == false)
			throw new Exception("inserting file into non-directory");
		return elem;
	}
}
