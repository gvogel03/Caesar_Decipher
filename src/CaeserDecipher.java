import java.util.Scanner;

public class CaeserDecipher{
	static String alpha = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
	static int[]count = new int[26];
	static int max = 0;
	static char maximum = 'a';
	public static StringBuilder cipher(StringBuilder sb, int key){
		for(int i = 0; i < sb.length(); i++){
			char index = sb.charAt(i);
			index = Character.toLowerCase(index);
			if(alpha.contains(index + "")){
				int ind = alpha.indexOf(index);
				ind += key;
				sb.setCharAt(i, alpha.charAt(ind));
			}
		}
		return sb;
	}
	public static int[] count(StringBuilder message){
		for(int i = 0; i < message.length(); i++){
			int index = alpha.indexOf(message.charAt(i));
			if(index != -1){
				count[index] += 1;
			}	
		}
		return count;
	}
	public static char decrypt(StringBuilder encrypted){
		count(encrypted);
		for(int i = 0; i < count.length; i++){
			if(count[i] > max){
				maximum = alpha.charAt(i);
				max = count[i];
			}
		}
		return maximum;
	}
	 public static void main(String[]args){
		 Scanner console = new Scanner(System.in);
		 System.out.println("What phrase do you want do decrypt?");
		 String input = console.nextLine();
		 StringBuilder choice = new StringBuilder(input);
		 count(choice);
		 char largest = decrypt(choice);
		 int shift = alpha.indexOf(largest) - 4;
		 shift = 26 - shift;
		 if(shift > 26){
			 shift = shift - 26;
		 }
		 System.out.println("Your Decrypted phrase is: " + cipher(choice, shift));
	 }
}
