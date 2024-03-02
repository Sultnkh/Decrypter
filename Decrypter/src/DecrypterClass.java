import java.util.LinkedHashMap;

public class DecrypterClass {

	public static void main(String[] args) {
		
		String Secret1 = "1yo1ur; ro2ckst2ar;i2nn1er. us6, Come unl1eash 2wi2th1";
		String Secret2 = "a3t f1or p2a2r1t1y y1o1u p4o1ol o1u3r cinema Waiting";
		String Secret3 = "In2vita1tion 1Night1 Cine1ma Po1ol Mo1vie";
		String Secret4 = "t1e1s2t, Hell1o, 1th1e, fir2st1";
		
		Decrypter(Secret1);
		Decrypter(Secret2);
		Decrypter(Secret3);
		Decrypter(Secret4);

	}
	
	public static void Decrypter(String Secret) {

		// An object used to map sums(keys) to words(values)
		// Linkedhashmap is used to preserve order of isnertion 
		// and to keep last added word in case of multiple words having the same sum value
		LinkedHashMap<Integer, StringBuilder> map = new LinkedHashMap<>();
		
		//Step 1: Splitting the message using [\W_]+ to split at any symbol that isn't a letter or a number 
		//including the "_" symbol
		String[] wordsArray = Secret.split("[\\W_]+");		
		
		//showing the encrypted message before starting decryption process
		System.out.print("\nEncrypted message is: ");
		for (String word : wordsArray) {
			System.out.print(word + " ");
		}

		// Looping through the array and operating on each letter, in this loop I get the sum for each word 
		// and remove digits from the words
		for (String word : wordsArray) {
			int sum = 0;
			
			//Storing the words in a StringBuilder Object to manipluate the same obejct and remove digits
			StringBuilder cleanedWord = new StringBuilder(word);

			//Looping through letters 
			for (int i = 0; i < cleanedWord.length(); i++) {
				char letter = cleanedWord.charAt(i);

				if (Character.isDigit(letter)) {
					//Step 2: Calculating the sum of numbers in each word
					sum += Character.getNumericValue(letter);
					//Step 4: Removing numeric values
					cleanedWord.deleteCharAt(i);
				}
			}
			//Step 3: Mapping each word(value) to its numbers sum(Key) (sum,word).
			map.put(sum, cleanedWord);

		}
		//Initializing an array of string to the size of the map+1 to avoid reaching out of bounds indexes
		String[] orderedString = new String[map.size()+1];

		// Step 5: Arranging the words based on their order
		// Using the keys as array indexes and storing the key's value to the index
		for (Integer key : map.keySet()) {
			orderedString[key] = map.get(key).toString();
		}

		// Converting the string array into a single String and ignoring null values
		StringBuilder message = new StringBuilder();
		for (String s : orderedString) {
			if(s != null) {
				message.append(s).append(" ");}
		}
		System.out.print("\nMessage Is: "+message);
		System.out.print("\n");
	}
}
