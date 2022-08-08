
public class TextProcessor {

  /** methods 1a/1b: these methods will convert back and forth between a string
    * and an array of characters.  For example, stringToArray would convert the five-characters
    * string "abcde" into the array {'a', 'b', 'c', 'd', 'e'}, while arrayToString would convert
    * the array back into a string.
    */
    public static char[] stringToArray(String input) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
    	char[] arr = new char[input.length()]; //Creates an array of chars with the same length as input
        for(int i = 0; i < input.length(); i++) {
        	arr[i] = input.charAt(i); //populates the indexes of arr with the character at index i for the string Input
        }
        return arr;
    }
 
    public static String arrayToString(char[] input) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
    	String str = new String(""); //creates a new empty string
        for(Character i : input) {
        	str = str + i.toString(); //iterates over input, and concats the character i to string str 
        }
        return str;
    }
 
  /** methods 2a/2b: these methods will count the number of occurrences of
    * a given character within a string.  In the case of freqOccurrence,
    * the result will be given in the form of a fraction of the total string
    * length.  For example, given the input string "baba" and the character 'a', 
    * numOccurrences will report 2 while freqOccurrence would return 0.5.
    * If the string is empty, freqOccurrence should always return 0.
    */
    public static int numOccurrences(char c, String str) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        int begin = str.length(); int end; 
        String secStr = str.replace(Character.toString(c), ""); //creates a second string where all instances of c are removed
        end = secStr.length();
        return begin - end; //returns the difference in length between str and secStr, which is equal to the number of c in str
    }

    public static double freqOccurrence(char c, String str) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
    	int begin = str.length(); 
    	if (begin <= 0) {return 0.0;}
    	int fin = TextProcessor.numOccurrences(c, str); //sets fin equal to the number of c's in str
        return ((double)fin)/((double)begin); //divides fin by the length of the original string
    }
 
  /** method 3: this method determines which character is the most frequently occurring
    * character in the given input string.  For example, in the string "banana", the
    * letter 'a' is the most frequent and would be returned.  In the case of a tie, the 
    * earliest occurring letter would be returned.  Thus, for the string "haha", 'h' and
    * 'a' are equally frequent but 'h' occurs first and would be returned.  In the case of
    * an empty string, return (char)0.
    *
    * Hint: previously defined methods such as numOccurrences may help you solve this.
    */
    public static char mostFrequent(String str) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
    	if(str.length() <= 0) {return (char)0;}
    	int comp; int max = 0; int maxIndex = 0;
    	for(int a = 0; a < str.length(); a++) {
    		comp = TextProcessor.numOccurrences(str.charAt(a), str); //iterates over str, finding the number of times the character at a in str occurs in str
    		if (comp > max) { 
    			max = comp;
    			maxIndex = a; //determines if comp is greater than the current max value, and replaces max and maxIndex if comp is greater than max
    		}
    	}
    	return str.charAt(maxIndex);
    }
 
  /** method 4: this method takes a number (a double value) and an array of double values, and
    * determines which element of the array is closest in value to the input number.  For example,
    * for the input 5.3 and the array {1.2, 7.8, 2.3, 10.1}, the value 5.3 is closest to 7.8 (5.3 is a
    * distance of 2.5 from 7.8, and a distance of 3.0 from 2.3).  Since the 7.8 is at index 1, the
    * method would return 1.  If the array is empty, the method should return -1, and if there is
    * a tie, then the method should return the index of the first closest option.
    */
    public static int closest(double v, double[] values) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
    	if (values.length <= 0) {return -1;}
        double min = Math.abs(v - values[0]); //sets the minimum value to the absolute value of the difference between v and values[0]
        int minIndex = 0;
        for(int i = 0; i < values.length; i++) {
        	if(Math.abs(v-values[i]) < min) { //iterates over values, and determines if the difference between v and values[i]
        		min = Math.abs(v-values[i]);  //is less than min. if so, min is replaced with the distance between v and 
        		minIndex = i;                 //values[i] and minIndex is replaced with I
        	}
        }
        return minIndex;
    }
 
  /** method 5: sometimes a cipher is applied to text, meaning that the letters become scrambled while
    * the form of the text remains the same.  When attempting to decode such a text, we will often relyReturn
    * on the knowledge that certain characters appear at a fairly consistent rate within the language.  For example,
    * in a typical English text, the letter e occurs at a rate of approximately 12.7%.  Given an encoded input string and some
    * character, we want to guess what that character really is using its frequency of occurrence. 
    * 
    * As an example, suppose that our given character is 'q', and we determine that 0.07 of the characters in our input
    * string match a 'q'.  Then we will guess that our 'q' character is most likely really an 'i', because the 'i' typically 
    * occurs at a rate of 6.966% (see the charFrequencies array).  Essentially, for any frequency, we choose the closest frequency in the
    * charFrequency array.
    *      
    * Hint: we can use the previously defined method freqOccurrence to find out how often our character appears.  We can use the given
    * charFrequencies array and the method closest to find out which frequency is the closest to it.  We can use the given characters 
    * array to find out which character corresponds to that frequency.   
    */
    public static char letterGuess(char c, String str) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        double freq = TextProcessor.freqOccurrence(c, str); //Uses previously defined freqOccurrence method to determine the frequency at which c appears in str
        int index = TextProcessor.closest(freq, charFrequencies); //Uses previously defined closest method to determine the closest value to freq in charFrequencies 
        return characters[index]; //returns the appropriate char from characters at the index provided by closest
    }
 
    static final char[] characters = {
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
      'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    };
    static final double[] charFrequencies = { 
      /* source: https://en.wikipedia.org/wiki/Letter_frequency */
      /* a */ 0.08167, /* b */ 0.01492, /* c */ 0.02782,
      /* d */ 0.04253, /* e */ 0.12702, /* f */ 0.02228,
      /* g */ 0.02015, /* h */ 0.06094, /* i */ 0.06966,
      /* j */ 0.00153, /* k */ 0.00772, /* l */ 0.04025,
      /* m */ 0.02406, /* n */ 0.06749, /* o */ 0.07507,
      /* p */ 0.01929, /* q */ 0.00095, /* r */ 0.05987,
      /* s */ 0.06327, /* t */ 0.09056, /* u */ 0.02758,
      /* v */ 0.00978, /* w */ 0.02360, /* x */ 0.00150,
      /* y */ 0.01974, /* z */ 0.00074,
    };   

  /** method 6: determines whether the characters in the first string form a subset of the characters in the
    * second string, that is, if every character appears at least once in the second string.  
    * For example, the characters "abc" do form a subset of "abracadabra" because each of 'a', 'b', and 'c'
    * appear in the second string, whereas "abc" is not a subset of "bcdefghi" because the second string lacks the 
    * character 'a'.  This method should not be concerned about order or duplicates, so "aaab" would be considered 
    * a subset of "ba".
    */  
    public static boolean charSubset(String first, String second) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
    	int num;
        for(int i = 0; i < first.length(); i++) {
        	num = TextProcessor.numOccurrences(first.charAt(i), second); 
        	if (num <= 0) {return false;} //Uses the previously defined numOccurences to determine if the char at index i of first appears in second
        }                                 //returns false if num is less than or equal to zero
        return true;                      //returns true if the loop is able to complete
    }

  /** method 7: as in the charSubset method above, this method will determine whether all characters in the
    * first string also occur in the second string.  However, unlike charSubset, this method is concerned with
    * duplicates, so if a character appears several times in the first string, then it must appear at least as
    * many times in the second string.  Thus, if the first string is "barb" and the second string is "abracadabra",
    * then containsAll returns true, whereas it returns false when checking if "banana" is contained in "bandaid" 
    * (too few 'a's and 'n's).
    */
    public static boolean containsAll(String first, String second) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
    	int num1, num2;
    	for(int i = 0; i < first.length(); i++) {
        	num1 = TextProcessor.numOccurrences(first.charAt(i), second);
        	num2 = TextProcessor.numOccurrences(first.charAt(i), first); //Similar to charSubset, but also ensures the number of times the char at index i of first
        	if ((num1 <= 0) || (num2 > num1)) {return false;}			 //less than or equal to the number of times it appears in string Second
    	}
    	return true;//returns true if the loop is able to complete
    }
 
  /** method 8: this method will combine adjacent identical characters in the
    * input string to produce the output string.  For example, if the input string
    * is "aaabcdddeeeddcbbaaaa", then the output would be "abcdedcba", where substrings
    * of identical characters such as the "aaa" at the beginning become condensed into a
    * a single "a".
    */
    public static String condenseDuplicates(String str) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        String fin = "";
        for(int a = 0; a < str.length(); a++) {
        	fin = fin.concat(str.substring(a, a + 1));  //Concats the character at index a of str to fin
        	for(int b = a + 1; b < str.length(); ++b) { //iterates over str beginning at index a + 1
        		if(str.charAt(a) == str.charAt(b)) //Increments a if the character at index a and index b are equal
        			a++;
        		else  //Breaks loop if the character at index and and index b are not equal
        			break;
        	}
        }
        return fin;
    }
 
  /** methods 9a/9b: the method reversedString will take the given input string and produce
    * an output string which is the reverse of the characters in the input.
    * for example, if the input string is "Hello world!", then the output
    * string would be "!dlrow olleH".
    *
    * The method isPalindrome indicates whether or not the given input string
    * is a palindrome.  A palindrome is a string which is identical when read
    * both forwards and backwards.  For example, "racecar" is a palindrome, 
    * because when written backwards, it is still the word "racecar".
    */
    public static String reversedString(String str) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        String reverse = "";
        for(int i = str.length() - 1; i >= 0; i--) {
        	reverse = reverse.concat(Character.toString(str.charAt(i))); //iterates over str in reverse, and concats the
        }                                                                //individual characters to string reverse
        return reverse;
    }

    public static boolean isPalindrome(String str) {
       // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        String pal = TextProcessor.reversedString(str); //Uses the already defined method reversedString
        return pal.equals(str); //returns the truth of pal and str's equality
    }
 
  /** method 10: this method takes the given input string and appends
    * the fewest number of characters possible in order to produce a
    * palindrome.  For example, if the input is "wow", then it is already
    * a palindrome, so this method would return "wow", while if the input is
    * "java", then "javaj" is the shortest palindrome which could be returned.
    *
    * Hint: suppose that "java" is the input.  Then we know that "java" + "avaj"
    * would produce a palindrome.  However, we might be able to get away with 
    * fewer characters.  Between "java" + "", "java" + "j", "java" + "aj", 
    * "java" + "vaj", and "java" + "avaj", which one is the shortest valid
    * palindrome?
    */
    public static String createPalindrome(String str) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        String reverse = TextProcessor.reversedString(str); //creates a reversal of str using the method reversedString
        String sub;
        for(int i = 0; i < str.length(); i++) {
        	sub = str.substring(0, i); //creates string sub using a substring of str at indexes 0 and i
        	if(TextProcessor.isPalindrome(sub.concat(reverse))) { //Concats reverse to sub and uses method isPalindrome to determine if the resultant string is a palindrome
        		return sub.concat(reverse);
        	}
        }
        return str.concat(reverse);
    }
    
  //*******************************************************************************************************
  /** The follwoing two methods are only for Honors section students
    * 
    */
  //********************************************************************************************************
    
  /** method 11: This method takes two input strings and returns true if the two strings are Anagrams. 
    * Two strings are Anagrams, if they contain the same set of characters but in different order.
    * For example, "Hello World" and  "World Hello" are Anagrams so as "Listen" and  "Silent"  and "Funeral"
    * and  "Real fun". Where as "enjoy"  and "enjoy", "Three"  and "Tree"  are not.
    */
    public static boolean isAnagram(String str1, String str2) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        throw new RuntimeException("not implemented!");  
    }

  /** method 12: This method accepts an integer and returns the inverse of the integer.
    * For example, if num=456 the method returns 654 (six hundered fifty four). Similalry 
    * if  num=100000, it returns  1 (one) and if num = -98 it reurns -89.
    */
    public static long reverseInt(long num) {
     // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
        throw new RuntimeException("not implemented!");  
    }
    
}