package edu.holycross.shot.oldpersian

/** A class for orthographic tokenizing of Old Persian content.
 */
class OPTokenization {


  /** An ordered list of OPToken objects. */
  public ArrayList tokens = []



  OPTokenization(ArrayList inputLines, boolean stripExtended) {
    initTokens(inputLines, stripExtended)
  }
  OPTokenization(ArrayList inputLines) {
    initTokens(inputLines, false)
  }

  /** Initializes tokens array from an ordered list of 2-element
   * ArrayLists.
   * @param inputLines A ordered series of pairings of identifiers
   * with text content.  In each pair, the identifier should
   * element 0, and the text content should be element 1.
   * Empty or incomplete elements of inputLines are ignored.
   */
    void initTokens(ArrayList inputLines, boolean stripExtended) {

      if (stripExtended) {
	System.err.println "INITIALIZING WITH STRIP EXTENDED TRUE"
	System.err.println "Input is " + inputLines
      }
      
    String currLine = ""
    String prevLine = ""
    String prevWordStart = ""
    inputLines.each { pair ->
      	if (stripExtended) {
	  System.err.println "Pair: " + pair
	}
      if (pair.size() == 2 ) {
	String ref = pair[0]
	String txt = "${prevWordStart}${pair[1]}"
      
	def wds = txt.split(/:/)
	if (stripExtended) {
	  System.err.println "CONSIDER: " + wds.size() + " words"
	}
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
	    if (stripExtended) {
	      System.err.print "Strip extended: look at ${w}..."
	      //w = w.replaceAll(/[\\[\\]\\(\\)\\{\\}<>]/,'')
	      w = w.replaceAll(/[\[\]<>\(\)\{\}]/,'')
	      System.err.println " and go to ${w}"
			       
	    }
	    
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
	}
      }
      prevLine = currLine
    }
  }

  /** Get an OPToken identified by index number
   * from the tokens list.
   * @param idx Position of the token in the list.
   * @returns An OPToken object.
   * @throws Exception if the value of idx is invalid.
   */
  OPToken getToken(int idx)
  throws Exception {
    if ((idx < 0) || (idx >= tokens.size())) {
      throw new Exception("OPTokenization:getToken: invalid index value ${idx}")
    }
    return tokens.get(idx)
  }

}