package brainfuckint;

import java.io.Console;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrainfuckInterpreter y = new BrainfuckInterpreter();
		Scanner codeInput = new Scanner( System.in );
		System.out.println("Entrez le code à interpréter :"+"\n");
		String code = codeInput.nextLine();
		y.Execute(code);
		codeInput.close();
		
	}

}
