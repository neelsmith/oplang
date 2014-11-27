package edu.holycross.shot.oldpersian

import java.util.ArrayList;
/// may need to type analyses as either compound or single, since
// we are analyzing *orthographic* tokens
//

/** 
 */
class OPMorphology {

  Integer debug = 0


  
  /** Authority list for validating tokens. */
  URL authList = new URL("https://raw.githubusercontent.com/neelsmith/op/master/collections/morph.csv")

  // Should also carry further information  so that
  // multiple parts of a compound analysis can be distinguished from
  // alternate analyses.
  /** Map of morphological analyses, keyed by URN string, to
   * a list of morphological analysis objects.
   */


  // REDO HIS YET AGAIN.  Should map directly from a single
  // morph analysis URN to a single OPMorphAnalysis object.
  // Morph'l ambiguity is handled in the formIndex.
  // Compound analyses have analysis value "compound" and a lex.entity
  // URN in the "compound" Collection that can be further resolved.
  // Sigh.
  LinkedHashMap morphDb = [:]


  /** Map of forms, keyed by URN string, to
   * a list of morphological analysis URNs.
   */
  LinkedHashMap formIndex = [:]

  
  
  OPMorphology() {
    initList(authList)
  }


  // true if analysis is compound
  boolean isCompound(String analysisUrn)
  throws Exception {
    OPMorphAnalysis analysis = morphDb[analysisUrn]
    
    if (analysis.lexicalEntityUrn ==~ /urn:cite:oldpersian:compound.+/) {
      return true
    } else if (analysis.lexicalEntityUrn ==~ /urn:cite:oldpersian:lex.+/) {
      return false
    } else {
      throw new Exception("OPMorphology:isCompound: unrecognized CITE collection in lexical entity URN ${analysis.lexicalEntityUrn}")
    }
  }
  

  // Initializes morphological databse from authority list
  // in csv format at url.
  // data are keyed by urn of the morphological analysis' URN,
  // so we also need to create an inverted index to find morph.URNs
  // give the urn of a form, since that's the most common way to work with
  // all of this.
  void initList(URL url) {
    String txt = url.getText("UTF-8")
    if (debug > 0) {
      System.err.println "Initialize DB from URL ${url}"
    }
    // skip first line
    Integer count = 0
    txt.eachLine { l ->
      if (count > 0) {
	def cols = l.split(/,/)
	String urn
	String lexent
	String form

	if (cols.size() > 3) {
	  urn  = cols[0]
	  lexent = cols[1]
	  form = cols[2]
	  //formIndex[form] = urn
	}
	
	
	OPMorphAnalysis analysis
	if (cols.size() == 4) {
	  String parse = cols[3]
	  //analysis = new OPMorphAnalysis(form,lexent,parse)
	  morphDb[urn] = new OPMorphAnalysis(form,lexent,parse)
	} else {
	  morphDb[urn] = new OPMorphAnalysis(form,lexent,"")
	  //analysis = new OPMorphAnalysis(form,lexent,"")
	}

	/*
	if (morphDb[urn]) {
	  def analysisList = morphDb[urn]
	  analysisList.add(analysis)

	  if (debug > 5) {
	    System.err.println "Init: key #${urn}# of class ${urn.getClass()} gets list " + analysisList
	    System.err.println "morphDb keyset includes ${urn}: ${morphDb.keySet().contains(urn)}"
	  }
	  morphDb[urn] = analysisList
	  
	} else {
	  def analysisList = [analysis]
	  morphDb[urn] = analysisList

	  if (debug > 5) {
	    System.err.println "Init: NEW key #${urn}# of class ${urn.getClass()} gets list " + analysisList
	    System.err.println "morphDb keyset includes ${urn}: ${morphDb.keySet().contains(urn)}"
	  }
	}
	*/
	
	if (formIndex[form]) {
	  def indexList = formIndex[form]
	  indexList.add(urn)
	  formIndex[form] = indexList

	} else {
	  def indexList = [urn]
	  formIndex[form] = indexList
	  if (debug > 5) {
	    System.err.println "Indexed list to new form #${form}# : ${indexList}"
	  }

	}
	
      }
      count++
    }
  }


  // finds number of analyses for a form
  Integer numberAnalyses(String formUrn) {
    if (formIndex.keySet().contains(formUrn)) {
      def morphList = formIndex[formUrn]
      return morphList.size()
    } else {
      return 0
    }
  }

  String getAnalysisUrn(String formUrn, Integer idx ) {
    if (formIndex.keySet().contains(formUrn)) {
      def morphKeys = formIndex[formUrn]
      return morphKeys[idx]
    }      
  }

  // get a specific analysis identified by index number from
  // the arraylist of analyses for a specified form
  OPMorphAnalysis getAnalysis(String formUrn, Integer idx ) {
    if (debug > 0) {
      System.err.println "Lookup analysis at position ${idx} for ${formUrn}"
    }
    ArrayList morphs = analyzeForm(formUrn)
    if (debug > 0) {
      System.err.println "For ${formUrn}, found ${morphs.size()} analyses"
    }
    return morphs[idx]
  }
  
  // get a (possibly empty) list of OPMorphAnalysis
  // objects for a form identified by URN
  ArrayList analyzeForm(String formUrn ) {
    
    if (debug > 0) {
      System.err.println "CHECK ANALYSIS OF FORM " + formUrn
      System.err.println "It's a key? " + formIndex.keySet().contains(formUrn)
    }
    
    if (formIndex.keySet().contains(formUrn)) {
      if (debug > 0) {
	System.err.println "So with this key, num morph IDs = " + formIndex[formUrn].size()
      }
      def morphKeys = formIndex[formUrn]
      if (debug > 0) {
	System .err.println " And morphkeys are " + morphKeys
      }

      ArrayList analysisList = []
      morphKeys.eachWithIndex {  morphKey, i ->
	if (debug > 0) {
	  System.err.println "${i}: ${morphKey}"
	}
	analysisList.add(morphDb[morphKey])
      }
	/*
	//analysisList.add("Data from ${morphKey}")
	def listForKey = morphDb[morphKey]
	if (debug > 0) {
	  System.err.println "For ${morphKey}, we get " + listForKey + " of class " + listForKey.getClass()
	}
	listForKey.each {
	  analysisList.add(it)
	}
	if (debug > 0) {
	  System.err.println "Analysis list now " + analysisList
	}
	}*/
      
      return analysisList

      
    } else {
      System.err.println "OPMorphology:analyzeForm: no record for form ${formUrn}"
      ArrayList emptyList = []
      return emptyList
    }
  }
  
}