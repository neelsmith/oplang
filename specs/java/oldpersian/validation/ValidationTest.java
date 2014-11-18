package oldpersian.validation;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

//import edu.holycross.shot.oldpersian.OPTransliteration;

import java.net.URL;
import edu.holycross.shot.oldpersian.OPToken;

import org.concordion.integration.junit3.ConcordionTestCase;



public class ValidationTest extends ConcordionTestCase {

    public boolean isValid(String addr, String token) {
	boolean valid = false;
	try {
	    valid = OPToken.isValid(new URL(addr),token);
	} catch (Exception e) {
	    System.err.println ("Something went wrong: " + e);
	}
	return (valid);
    }

    public boolean stringValid(String addr, String inputText) {
	boolean valid = false;
	try {
	    valid = OPToken.textIsValid(new URL(addr),inputText);
	} catch (Exception e) {
	    System.err.println ("Something went wrong: " + e);
	}
	return valid;
    }

    
    /*
    
    public String parseData(String blockOData) {
	String [] arr = blockOData.split("\n");
	return "Number lines = " + arr.length;
    }
    

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


    public String getXlitForCuneiformLoose(String op) {
	boolean strict = false;
	try {
	    return OPTransliteration.uToXLit(op, strict);
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
    */
}
