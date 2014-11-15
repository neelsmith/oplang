package oldpersian.transliteration;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class AlphabeticTest extends ConcordionTestCase {
    
    public String getXlit(String op) {
	return OPTransliteration.uToXLit(op);

    }


    public String getCuneiform(String xlit) {
	System.err.println ("Get cuneiform for xlit " + xlit.toLowerCase());
	return OPTransliteration.xlitToU(xlit.toLowerCase());
    }

}
