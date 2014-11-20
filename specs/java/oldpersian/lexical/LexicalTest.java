package oldpersian.lexical;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.oldpersian.OPFormList;
import edu.holycross.shot.oldpersian.OPLexicon;
import edu.holycross.shot.oldpersian.OPMorphAnalysis;
import edu.holycross.shot.oldpersian.OPMorphology;

import org.concordion.integration.junit3.ConcordionTestCase;

public class LexicalTest extends ConcordionTestCase {
    
    OPFormList formList = new OPFormList();
    OPLexicon lexicon = new OPLexicon();    
    OPMorphology morphology = new OPMorphology();

    public OPMorphAnalysis findLemma(String urn) {
	return morphology.analyzeForm(urn);
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
