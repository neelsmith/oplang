package specs.oldpersian;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class TransliterationTest extends ConcordionTestCase {
    
    public String xlit(String op) {
	return OPTransliteration.uToXLit(op);
    }
}
