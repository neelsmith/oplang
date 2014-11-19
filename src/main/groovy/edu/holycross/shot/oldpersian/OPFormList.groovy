package edu.holycross.shot.oldpersian


/** 
 */
class OPFormList {


  /** Authority list for validating tokens. */
  URL authList = new URL("https://raw.githubusercontent.com/neelsmith/op/master/collections/vocab.csv")

  // map of URN strings to OPForm objects
  LinkedHashMap formsList = [:]

  // map of transliterations to URNs
  LinkedHashMap formIndex = [:] 

  
  OPFormList() {
    initList(authList)
  }

  void initList(URL url) {
    String txt = url.getText("UTF-8")
    // skip first line
    Integer count = 0
    txt.eachLine { l ->
      if (count > 0) {
	def cols = l.split(/,/)
	String urn  = cols[0]
	String form = cols[1]
	String xscr = cols[2]
	formIndex[form] = urn
	formsList[urn] = new OPForm(form, xscr)
      }
      count++
    }
  }

  boolean formRecognized(String form) {
    return formIndex.keySet().contains(form)
  }
  
  String transcribe(String transliteration) {
    String urn = formIndex[transliteration]
    OPForm form = formsList[urn]
    return form.transcribed
  }
  
}