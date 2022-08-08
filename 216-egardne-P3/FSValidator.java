
public class FSValidator implements FSFilter {
	public FSValidator() {}
	
	public FSElement process(FSElement elem) throws Exception{ //validates elem, throws exception if elem fails to validate
		elem.validate();
		return elem;
	}
}
