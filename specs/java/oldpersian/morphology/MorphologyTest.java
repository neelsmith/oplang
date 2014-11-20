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

    public String posString(String urn, String pos) {
	System.err.println ("Analyzing morphology of " + urn + " for part of speech " + pos);
	OPMorphAnalysis morph =  morphology.analyzeForm(urn);
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
