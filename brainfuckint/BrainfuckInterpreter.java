package brainfuckint;

import java.util.Scanner;
import java.util.ArrayList;

public class BrainfuckInterpreter {
	private ArrayList<Integer> _dataHolder;
	private int _dataIndex;
	private Scanner _inputScanner = new Scanner(System.in);

	public BrainfuckInterpreter() {
		_dataHolder = new ArrayList<Integer>();
		_dataHolder.add(0);
		_dataIndex = 0;
	}

	public void Execute(String InputCode) {
		char[] instructions = InputCode.toCharArray();
		int instructionIndex = 0;
		while (instructionIndex < instructions.length) {
			char instructionChar = instructions[instructionIndex];
			switch (instructionChar) {
			case ',':
				int numberInput = (int) _inputScanner.nextLine().charAt(0);
				_dataHolder.set(_dataIndex, numberInput);
				break;
			case '.':
				int letterValue = _dataHolder.get(_dataIndex);
				char letterOutput = (char) letterValue;
				System.out.println(letterOutput);
				break;
			case '<':
				if (_dataIndex > 0) {
					_dataIndex--;
				}
				break;
			case '>':
				_dataIndex++;
				if (_dataHolder.size() == _dataIndex) {
					_dataHolder.add(0);
				}
				break;
			case '+':
				_dataHolder.set(_dataIndex, _dataHolder.get(_dataIndex) + 1);
				break;
			case '-':
				if (_dataHolder.get(_dataIndex) > 0) {
					_dataHolder.set(_dataIndex, _dataHolder.get(_dataIndex) - 1);
				}
				break;
			case '[':
				instructionIndex++;
				StringBuilder bracketContent = new StringBuilder();
				int bracketLevel = 1;
				do {
					if (instructions[instructionIndex] == ']') {
						bracketLevel--;
					}
					if (instructions[instructionIndex] == '[') {
						bracketLevel++;
					}
					if (bracketLevel > 0) {
						bracketContent.append(instructions[instructionIndex]);
						instructionIndex++;
					}
				} while (bracketLevel > 0);

				while (_dataHolder.get(_dataIndex) != 0) {
					Execute(bracketContent.toString());
				}
				break;
			}
			instructionIndex++;
		}
	}
}