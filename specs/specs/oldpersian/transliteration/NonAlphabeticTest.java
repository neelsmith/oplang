package specs.oldpersian.transliteration;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class NonAlphabeticTest extends ConcordionTestCase {


    public String getLogoXlit(String op) {
	return OPTransliteration.uToXLit(op);
    }

    public String getLogoCun(String xlit) {
	return OPTransliteration.xlitToU(xlit);
    }

    
    public String getPunctXlit(String op) {
	return OPTransliteration.uToXLit(op);
    }

    public String cuneiformPunct(String xlit) {
	return OPTransliteration.xlitToU(xlit);
    }

}
