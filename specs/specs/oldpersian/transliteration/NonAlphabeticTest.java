package specs.oldpersian.transliteration;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class NonAlphabeticTest extends ConcordionTestCase {
    
    public String xlitPunct(String op) {
	StringBuffer buff = new StringBuffer(op);
	int   codePoint = buff.codePointAt(0);
	int max = buff.codePointCount(0, buff.length() - 1);
	    
	System.err.println ("Total cps: " + max + ". First code point " + codePoint);
	return OPTransliteration.uToXLit(op);

    }

    public String cuneiformPunct(String xlit) {
	return OPTransliteration.xlitToU(xlit);
    }

}
