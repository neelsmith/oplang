package oldpersian.transliteration;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;
import edu.holycross.shot.oldpersian.OPToken;

import org.concordion.integration.junit3.ConcordionTestCase;

public class NumbersTest extends ConcordionTestCase {

    public boolean isValidNumber(String token) {
	boolean valid = false;
	try {
	    valid = OPToken.isValid(token);
	} catch (Exception e) {
	    System.err.println("Something is borken with numbers: " + e);
	}
	return valid;
    }

    public String getLogoXlit(String op) {
	try {
	    return OPTransliteration.uToXLit(op);
	} catch (Exception e) {
	    return e.toString();
	}
    }

    public String getLogoCun(String xlit) {
	try {
	    return OPTransliteration.xlitToU(xlit);
	} catch (Exception e) {
	    return e.toString();
	}
    }

    
    public String getPunctXlit(String op) {
	try {
	    return OPTransliteration.uToXLit(op);
	} catch (Exception e) {
	    return e.toString();
	}
    }

    public String cuneiformPunct(String xlit) {
	try {
	    return OPTransliteration.xlitToU(xlit);
	} catch (Exception e) {
	    return e.toString();
	}
    }

}
