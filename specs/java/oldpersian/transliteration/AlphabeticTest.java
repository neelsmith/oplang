package oldpersian.transliteration;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class AlphabeticTest extends ConcordionTestCase {
    
    public String getXlit(String op) {
	try {
	    return OPTransliteration.uToXLit(op);
	} catch (Exception e) {
	    return e.toString();
	}
    }

    public String getCuneiform(String xlit) {
	try {
	    return OPTransliteration.xlitToU(xlit);
	} catch (Exception e) {
	    return e.toString();
	}
    }

}
