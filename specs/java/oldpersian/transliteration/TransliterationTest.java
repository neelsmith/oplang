package oldpersian.transliteration;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPTransliteration;

import org.concordion.integration.junit3.ConcordionTestCase;

public class TransliterationTest extends ConcordionTestCase {


    // Test bad input.  Return true if
    // transliteraion correctly throws an Exception
    public boolean failedCuneiform(String op) {
	try {
	    String xlit =  OPTransliteration.uToXLit(op);
	} catch (Exception e) {
	    return true;
	}
	return false;
    }


    public boolean failedXlit(String xlit) {
	try {
	    String cuneiform =  OPTransliteration.xlitToU(xlit);
	} catch (Exception e) {
	    return true;
	}
	return false;
    }



    
     public String getXlitForCuneiform(String op) {
	 try {
	     return OPTransliteration.uToXLit(op);
	 } catch (Exception e) {
	     return e.toString();
	 }
    }


    public String getCuneiformForXlit(String xlit) {
	try {
	    return OPTransliteration.xlitToU(xlit);
	} catch (Exception e) {
	    return e.toString();
	}
    }
}
