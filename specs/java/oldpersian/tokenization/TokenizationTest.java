package oldpersian.tokenization;

import  edu.holycross.shot.oldpersian.OPTokenization;
import  edu.holycross.shot.oldpersian.OPToken;

import java.util.ArrayList;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class TokenizationTest extends ConcordionTestCase {


    /* Takes a line-oriented input string in transliteration formatted as
     * ref=TEXT, and uses OPTokenization to extract a requested entry
     * from it.
     */
    public OPToken extractToken(String xlit, int idx)
	throws Exception {
	// Format  line-oriented  input given in a <pre>
	// element as an ArrayList:
	String [] arr = xlit.split("\n");
	ArrayList inputLines = new ArrayList();
	    
	for (int i=0;i < arr.length; i++) {
	    String [] parts = arr[i].split("=");
	    ArrayList entry = new ArrayList();
	    if (parts.length == 2) {
		entry.add(parts[0]);
		entry.add(parts[1]);
		inputLines.add(entry);
	    } else {
		//
	    }
	}
	OPTokenization tokenization = new OPTokenization(inputLines);
	try {
	    return( tokenization.getToken(idx));
	} catch (Exception e) {
	    throw e;
	}
    }


    /* Similar to previous, except that it uses settings
     * to accept exended notation in input, and strip out the extended
     * notation in output, and only expects tokes in input
     *  (no references).
     */
    public OPToken extractStrippedToken(String xlit, int idx)
    throws Exception {
	// Format  line-oriented  input given in a <pre>
	// element as an ArrayList:
	String [] arr = xlit.split("\n");
	ArrayList inputLines = new ArrayList();
	    
	for (int i=0;i < arr.length; i++) {
	    ArrayList entry = new ArrayList();
	    entry.add("RefString");
	    entry.add(arr[i]);
	    inputLines.add(entry);
	}
	OPTokenization tokenization = new OPTokenization(inputLines, true);
	System.err.println ("TOKENIZAION YIELDED " + tokenization.tokens.size() + " elements.");
	try {
	    return( tokenization.getToken(idx));
	} catch (Exception e) {
	    throw e;
	}
    }

    
    public String tokenizeCuneiform(String op) {
	return ("Not implemented yet.");
    }

}
