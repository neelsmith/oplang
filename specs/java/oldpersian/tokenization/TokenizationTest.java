package oldpersian.tokenization;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class TokenizationTest extends ConcordionTestCase {
    
    public String tokenizeXlit(String op) {
	//return OPTransliteration.uToXLit(op);
	return ("Not implemented yet.");
    }

    public String tokenizeCuneiform(String xlit) {
	//	return OPTransliteration.xlitToU(xlit);
	return ("Not implemented yet.");
    }

}
