package oldpersian.morphology;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPFormList;
import edu.holycross.shot.oldpersian.OPLexicon;
import edu.holycross.shot.oldpersian.OPMorphAnalysis;
import edu.holycross.shot.oldpersian.OPMorphology;

import org.concordion.integration.junit3.ConcordionTestCase;

public class MorphologyTest extends ConcordionTestCase {
    
    OPFormList formList = new OPFormList();
    OPLexicon lexicon = new OPLexicon();    
    OPMorphology morphology = new OPMorphology();


    public boolean isCompound(String formUrn)
    throws Exception {
	try {
	    String analysisUrn = morphology.getAnalysisUrn(formUrn, 0);
	    return morphology.isCompound(analysisUrn);
	} catch (Exception e) {
	    throw e;
	}
    }

    
    public int numberMorphs(String formUrn) {
	return morphology.numberAnalyses(formUrn);
    }
    

    // for words with a single analysis, get readable label 
    public String posString(String urn, String pos) {
	OPMorphAnalysis morph = morphology.getAnalysis(urn,0);
	return morph.toString(pos);
    }

    
    public boolean isRecognized(String xlit) {
	return formList.formRecognized(xlit);
    }
    
    public String transcribe(String xlit) {
	return formList.transcribe(xlit);
    }

    public String translate(String urn) {
	return lexicon.getDefinition(urn);
    }
    
}
