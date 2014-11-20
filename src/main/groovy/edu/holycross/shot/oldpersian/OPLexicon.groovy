package edu.holycross.shot.oldpersian

import au.com.bytecode.opencsv.CSVReader

/**
 */
class OPLexicon {

  /** Authority list for validating tokens. */
  static URL authList = new URL("https://raw.githubusercontent.com/neelsmith/op/master/collections/lexicon.csv")

  LinkedHashMap lexicon = [:]
  
  OPLexicon() {
    initLexicon()
  }

  void initLexicon() {
    String txt = authList.getText("UTF-8")

    CSVReader reader = new CSVReader(new StringReader(txt))
    reader.readAll().each { ln ->
	if (ln.size() == 4) {
	  String urn = ln[0]
	  OPLexItem lex = new OPLexItem(ln[1], ln[2], ln[3])
	  lexicon[urn] =  lex  
	}
    }
  }



  
  String getDefinition(String urn) {
    if (lexicon[urn]) {
      OPLexItem lex = lexicon[urn]
      return lex.translation
    } else {
      System.err.println "OPLexicon: no entry for ${urn}"
      return null
    }
  }
  
}