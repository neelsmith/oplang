package specs.oldpersian.transliteration;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class AlphabeticTest extends ConcordionTestCase {
    
    public String xlit(String op) {
	return OPTransliteration.uToXLit(op);

    }


    public String cuneiform(String xlit) {
	return OPTransliteration.xlitToU(xlit);
    }

}
