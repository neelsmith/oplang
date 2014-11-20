package edu.holycross.shot.oldpersian


/** 
 */
class OPMorphology {


  /** Authority list for validating tokens. */
  URL authList = new URL("https://raw.githubusercontent.com/neelsmith/op/master/collections/morph.csv")

  // map of URN strings to morphology objects
  LinkedHashMap morphDb = [:]
  // index of surface forms to morphlogy
  LinkedHashMap formIndex = [:]

  
  
  OPMorphology() {
    initList(authList)
  }

  void initList(URL url) {
    String txt = url.getText("UTF-8")
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
	  formIndex[form] = urn
	}
	if (cols.size() == 4) {
	  String parse = cols[3]
	  morphDb[urn] = new OPMorphAnalysis(form,lexent,parse)
	} else {
	  morphDb[urn] = new OPMorphAnalysis(form,lexent,"")
	}
      }
      count++
    }
  }

  
  // consider what to do in case of multiple matches...?
  OPMorphAnalysis analyzeForm(String formUrn ) {
    if (formIndex.keySet().contains(formUrn)) {
      String morphKey = formIndex[formUrn]
      return morphDb[morphKey]
    }
  }
  
}