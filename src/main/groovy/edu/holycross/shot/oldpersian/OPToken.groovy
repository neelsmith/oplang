package edu.holycross.shot.oldpersian


/** An instance of an orthographic token.
 */
class OPToken {

  /** Identifier for the passage where the token occurs.*/
  String occurrence
  /** String, in transliteration, of the token. */
  String token

  /** Authority list for validating tokens. */
  static URL authList = new URL("https://raw.githubusercontent.com/neelsmith/op/master/collections/vocab.csv")

  
  // can be initialized from an arraylist of
  // pairings between ID (such as URN) and xliterated
  // text.  The pairing should itself be a 2-element
  // ArrayList, so an ArrayList of ArrayLists.
  
  OPToken( String psg, String form) {
    this.occurrence = psg
    this.token = form
  }


  static boolean textIsValid(URL csvFile, String txt) {
    boolean valid = true

    def tokenList = [];
    Integer idx = 0;
    csvFile.getText("UTF-8").eachLine { l ->
      idx++;
      def cols = l.split(/,/);
      if (cols.size() > 1) {
	def pair = [idx, cols[1]];
	tokenList.add(pair);
	}
    }

    
    def inputLines = []
    txt.eachLine {
      inputLines.add(it)
    }
    //System.err.println "textisvalid: using token list " + tokenList.size() + " and input lines " + inputLines.size()
    OPTokenization tokens = new OPTokenization(inputLines);
    tokens.tokens.each { t ->
      //System.err.println "Examine token " + t.token
      if (! tokenList.contains(t.token)) {
	valid = false;
	System.err.println "NO match for " + t.token
      }
    }
    return (valid)
  }

  
  static boolean isValid(URL csvFile, String form) {
    // col 0 = urn, col 1 =form
    boolean valid = false
    if (form ==~ /\d+/) {
      valid = true
    }
    if (! valid) {
      csvFile.getText("UTF-8").eachLine { l ->
	def cols = l.split(/,/)
	if (form == cols[1]) {
	  valid = true
	}
      }
    }
    return valid
  }
  
  static boolean isValid(String form) {
    return isValid(authList, form)
  }

  
}