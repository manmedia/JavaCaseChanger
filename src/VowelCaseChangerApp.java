/**
 * Case changer application.
 * 
 * ignores everything except the first two command-line arguments which are about 
 * input and output filenames respectively.
 * 
 * @author manna
 *
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class VowelCaseChangerApp {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger("VowelCaseChangerApp");
		
		logger.setLevel(Level.INFO);
		
		logger.info("\n\n########## JAVA APP FOR VOWEL CASE TOGGLING #############\n\n");
		
		logger.info("Checking for input types to see if strings are entered!\n\n");	
		
		assert(args[0] instanceof String):("Input file name in illegal format, please enter a string.\n");
		assert(args[1] instanceof String):("Output file name in illegal format, please enter a string.\n");
		
		logger.info("Argument types are fine, starting processor files with the arguments\n\n");
				
		/* Instantiate a case-changer */

		AbstractCaseChanger caseChanger = new VowelCaseChanger(args[0], args[1]);

		/* Process files */
		caseChanger.processFiles();
		
		logger.info("Case toggling complete..........Programme exiting........");

	}

}
