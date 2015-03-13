import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class thirteen {
	static List<Character> alphabet = new ArrayList<Character>(26);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = null;
		String str = null;
		char replacement;
		int t = 0;
		
		fillList();
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			sb = new StringBuilder(str);
			
			for (int i = 0; i < str.length(); i++) {
				t = alphabet.indexOf(Character.toLowerCase(str.charAt(i)));
				if ( t > -1 ) {
					t = (t + 13) % 26;
					replacement = alphabet.get(t);
					if (Character.isUpperCase(str.charAt(i))) {
						sb.setCharAt(i, Character.toUpperCase(replacement));
					}
					else {
						sb.setCharAt(i, replacement);
					}
				}
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}
	
	public static void fillList() {
		alphabet.add('a');
		alphabet.add('b');
		alphabet.add('c');
		alphabet.add('d');
		alphabet.add('e');
		alphabet.add('f');
		alphabet.add('g');
		alphabet.add('h');
		alphabet.add('i');
		alphabet.add('j');
		alphabet.add('k');
		alphabet.add('l');
		alphabet.add('m');
		alphabet.add('n');
		alphabet.add('o');
		alphabet.add('p');
		alphabet.add('q');
		alphabet.add('r');
		alphabet.add('s');
		alphabet.add('t');
		alphabet.add('u');
		alphabet.add('v');
		alphabet.add('w');
		alphabet.add('x');
		alphabet.add('y');
		alphabet.add('z');
	}
}
