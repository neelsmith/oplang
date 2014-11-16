package edu.holycross.shot.oldpersian


/**
 */
class OPTokenization {


  
  public ArrayList tokens = []

  // can be initialized from an arraylist of
  // pairings between ID (such as URN) and xliterated
  // text.  The pairing should itself be a 2-element
  // ArrayList, so an ArrayList of ArrayLists.
  
  OPTokenization(ArrayList inputLines) {
    String currLine = ""
    String prevLine = ""
    String prevWordStart = ""
    inputLines.each { pair ->
      String ref = pair[0]
      String txt = "${prevWordStart}${pair[1]}"
      
      def wds = txt.split(/:/)
      Integer limit

      if (txt.charAt(txt.size() - 1) == '-') {
	prevWordStart = wds[wds.size() - 1]
	currLine = ref
	limit = wds.size() - 2

      } else {
	limit = wds.size() - 1
	prevWordStart = ""
	currLine = ""
      }
      wds.eachWithIndex { w, i ->
	if (w != "") {
	  if (i == 0) {
	    if (prevLine != "") {
	      OPToken token = new OPToken("${prevLine}-${ref}",w)
	      tokens.add(token)
	      
	    } else {
	      OPToken token = new OPToken(ref,w)
	      tokens.add(token)
	    }
	  } else if (i <= limit) {
	    OPToken token = new OPToken(ref,w)
	    tokens.add(token)
	  }
	}

      // omit last if next line not beginning with word div
      //idx++;
      prevLine = currLine
      }
    }
  }


  // test for bad values of idx
  OPToken getToken(int idx) {
    System.err.println "OPTokenziation: get token ${idx} out of arrayilst ${tokens.size()}"
    return tokens.get(idx)
  }

  /*
  ArrayList [] getTokensArray () {
    ArrayList [] returnMe = this.tokens.toArray()
    System.err.println "REGURNING OBJ OF TYPE " + returnMe.getClass()
    return returnMe
    }*/

}