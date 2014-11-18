package oldpersian.tokenization;

import  edu.holycross.shot.oldpersian.OPTokenization;
import  edu.holycross.shot.oldpersian.OPToken;

import java.util.ArrayList;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class TokenizationTest extends ConcordionTestCase {


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
