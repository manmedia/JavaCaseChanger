/**
 * Extended class for implementing vowel case changing
 * 
 * @author manna
 *
 */
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

public class VowelCaseChanger extends AbstractCaseChanger {

	/**
	 * Attributes
	 * 
	 */

	private String input_filename = "";
	private String output_filename = "";

	private final String VOWEL = "aeiou";

	/**
	 * Constructor
	 * 
	 **/

	public VowelCaseChanger() {
		super();
	}

	public VowelCaseChanger(String input_filename, String output_filename) {
		this.input_filename = input_filename;
		this.output_filename = output_filename;
	}

	/**
	 * Getters and setters
	 * 
	 * 
	 **/
	public String getInputFileName() {
		return this.input_filename;
	}

	public void setInputFileName(String input_filename) {
		this.input_filename = input_filename;
	}

	public String getOutputFileName() {
		return this.output_filename;
	}

	public void setOutputFileName(String output_filename) {
		this.output_filename = output_filename;
	}

	/**
	 * Implemented method to process files. This extended class also therefore,
	 * allows to read a file and toggle cases for all the vowels.
	 * 
	 */

	@Override
	public void processFiles() {

		try {

			/*
			 * Open files within exception handling block in case anything is
			 * corrupted
			 */
			FileReader f1 = new FileReader(this.input_filename);

			StringBuffer sbf_in = new StringBuffer();

			// Read one character first
			int c = f1.read();

			// Now read the rest
			while (c != -1) {
				sbf_in.append((char) (c));
				c = f1.read();
			}

			// Close the file
			f1.close();

			// Get the string form
			String inputFileStr = sbf_in.toString();

			// System.out.println(inputFileStr);

			// Main processing loop

			char ipchar = ' ';
			char cc = ' ';

			/* Buffered file writing for efficiency */
			FileWriter f2 = new FileWriter(this.output_filename);
			BufferedWriter bf1 = new BufferedWriter(f2);

			/* loop through each character */
			for (int i = 0; i < inputFileStr.length(); i++) {

				ipchar = inputFileStr.charAt(i);

				if (VOWEL.indexOf(ipchar) != -1) {

					if (Character.isUpperCase(ipchar)) {

						cc = Character.toLowerCase(ipchar);

					} else if (Character.isLowerCase(ipchar)) {

						cc = Character.toUpperCase(ipchar);
					}

				} else {

					cc = ipchar;
				}
				// Write character to file
				bf1.write(cc);
			}

			// Close file
			bf1.flush();
			bf1.close();

		} catch (FileNotFoundException fnfe) { // If file name incorrect or not
												// found
			fnfe.printStackTrace();

		} catch (IOException ioe) { // IO handling issues e.g. disk writing
									// failed

			ioe.printStackTrace();

		} catch (PatternSyntaxException pse) { // Regex problems

			pse.printStackTrace();

		} catch (Exception e) { // Generic exceptions

			e.printStackTrace();

		}

	}

}
