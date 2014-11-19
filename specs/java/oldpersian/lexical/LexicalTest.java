package oldpersian.lexical;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPFormList;

import org.concordion.integration.junit3.ConcordionTestCase;

public class LexicalTest extends ConcordionTestCase {
    
    OPFormList formList = new OPFormList();    

    public boolean isRecognized(String xlit) {
	return formList.formRecognized(xlit);
    }
    
    public String transcribe(String xlit) {
	return formList.transcribe(xlit);
    }

}
