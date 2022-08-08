import java.util.Scanner;
import java.io.*;

public class SubmissionPrep {

	public static void main(String[] args) throws FileNotFoundException, Exception {
		if(args.length < 6) { //Determines if there are less than 6 args and exits if true
			System.err.print("Not enough arguments.");
			System.exit(0);
		}
		
		Directory directory = new Directory(); //creates new default directory
		for(int i = 6; i < args.length; i++) { 
			File file = new File("C:\\Users\\bgbus\\Desktop\\CS211\\src\\" + args[i]); //assigns File file with the given file
			Scanner scan = new Scanner(file); //creates new scanner for File file
			String contents = scan.nextLine() + "\n"; 
			while (scan.hasNextLine()) 
			      contents += scan.nextLine() + "\n"; //scans the contents of file, adding the contents to String contents 
			if(args[i].substring(0, args[i].indexOf(".")).equals("java")) { //determines if file has the extension java and instantiates file as a SourceCode if true
				SourceCode elem = new SourceCode(args[i], contents);
				directory.add(elem);
			}
			else { //creates FileElement elem from file
				FileElement elem = new FileElement(args[i], contents); 
				directory.add(elem);
			}
			
			scan.close();
		}
		
		ChainFilter filt = new ChainFilter();
		IDInfo id = new IDInfo(args[0], args[1], args[2], args[3], args[4]);
		IDFile idFile = new IDFile(id);
		directory.add(idFile); //creates IDInfo id from args[0-4], creates IDFile idfile from id, adds idfile to directory
		SubmitFolder subFold = new SubmitFolder(args[5], id); //creates new SubmitFolder subFold with args[5] and id
		filt.add(subFold); //adds subfold to filt
		System.out.print(filt.process(directory)); //prints the toString return value of filt.process(directory)
	}

}
