package oldpersian.tokenization;

import  edu.holycross.shot.oldpersian.OPTokenization;
import  edu.holycross.shot.oldpersian.OPToken;

import java.util.ArrayList;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class TokenizationTest extends ConcordionTestCase {

    //public OPTokenization tokenizeXlit(String xlit) {
    public OPToken extractToken(String xlit, int idx) {
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
		System.err.println ("Entr " + i + ": " + inputLines) ;
	}
	OPTokenization tokenization = new OPTokenization(inputLines);
	return( tokenization.getToken(idx));
    }
    
    
    public String tokenizeCuneiform(String op) {
	return ("Not implemented yet.");
    }

}
