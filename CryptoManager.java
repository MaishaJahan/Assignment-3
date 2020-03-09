/**
 *This class uses the set upper and lower bounds to test if a string can be encripted
 *to ceasar or bellaso.
 *The class also takes ceasar or bellaso text and changes them to a normal string. 
 * @author mjahan2, Maisha Jahan
 *
 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean bound = false;
		int check = 0;
		
		for ( int i = 0; i < plainText.length(); i ++)
		{
			if (plainText.charAt(i) >= LOWER_BOUND && plainText.charAt(i) <= UPPER_BOUND)
			{
				check += 0;
			}
			else
			{
				check += 1;
			}
		}
		
		if (check == 0)
		{
			bound = true;
		}
		return bound;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String textToCeasar = "";
		int characterEncrypted;
		char character;
		
		if (stringInBounds(plainText) == true)
		{
			for( int i = 0; i < plainText.length(); i++)
			{
				character = plainText.charAt(i);
				characterEncrypted = (key + character);
				
				while (characterEncrypted > UPPER_BOUND)
				{
					characterEncrypted = characterEncrypted - RANGE;
				}
				char characterToCeasar = (char)characterEncrypted;
				textToCeasar += characterToCeasar;
			}
		}
		return textToCeasar;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String textToBellaso = "";
		int textLength = bellasoStr.length();
		int characterEncrypted;
		char character;
		if (stringInBounds(plainText) == true)
		{
			for( int i = 0; i < plainText.length(); i++)
			{
				character = plainText.charAt(i);
				characterEncrypted = bellasoStr.charAt(i%textLength) + character;
				
				while (characterEncrypted > UPPER_BOUND)
				{
					characterEncrypted = characterEncrypted - RANGE;
				}
				char characterToBellaso = (char)characterEncrypted;
				textToBellaso += characterToBellaso;
			}
		}
		
		return textToBellaso;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String normalTextCeasar = "";
		int normalTextCharacter;
		char character;
		
		for ( int i = 0; i < encryptedText.length(); i ++)
		{
			character = encryptedText.charAt(i);
			normalTextCharacter = character - key;
			
			while (normalTextCharacter < LOWER_BOUND)
			{
				normalTextCharacter = normalTextCharacter + RANGE;
			}
			char characterToNormal = (char)normalTextCharacter;
			normalTextCeasar += characterToNormal;
		}
		return normalTextCeasar;
	}

	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String normalTextBellaso = "";
		int textLength = bellasoStr.length();
		int normalTextCharacter;
		char character;
		
		for( int i = 0; i < encryptedText.length(); i++)
		{
			character = encryptedText.charAt(i);
			normalTextCharacter = character - bellasoStr.charAt(i%textLength);
			
			while (normalTextCharacter < LOWER_BOUND)
			{
				normalTextCharacter = normalTextCharacter + RANGE;
			}
			char characterToNormal = (char)normalTextCharacter;
			normalTextBellaso += characterToNormal;
		}

		return normalTextBellaso;
	}

	
}