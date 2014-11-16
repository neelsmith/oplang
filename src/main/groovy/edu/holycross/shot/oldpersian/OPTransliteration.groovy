package edu.holycross.shot.oldpersian


/** A class for working with Old Persian strings represented
 * either in the Old Persian range of Unicode, or in the
 * transliteration scheme specified in this project.
 */
class OPTransliteration {

  //static Integer debug = 1
  

  /** Unicode code point for Old Persian word divider.*/
  static int WORD_DIVIDER = 66512


  /** Map of code points to transliteration. Keys are
   * transliteration strings, values are ints of Unicode
   * code points.
   */
  static HashMap xlitMap = [
    ":" : 66512,
    "a" : 66464,
    "i" : 66465,
    "u" :  66466,

    "ka" :  66467,
    "ku" : 66468,
    "ga" : 66469,
    "gu" : 66470,
    "xa" :  66471,
    "ca" :  66472,

    "ja" : 66473,
    "ji" : 66474,

    "ta" : 66475,
    "tu" : 66476,
    "da" :  66477,
    "di" :  66478,
    "du" :  66479,
    "tha" :  66480,


    "pa" : 66481,
    "ba" : 66482,
    "fa" :  66483,

    "na" : 66484,
    "nu" :  66485,
    "ma" : 66486,
    "mi" :  66487,
    "mu" :  66488,

    "ya" : 66489,

    "va" : 66490,
    "vi" : 66491,

    "ra" :  66492,
    "ru" : 66493,

    "la" :  66494,
    "sa" :  66495,
    "za" :  66496,
    "sha" :  66497,
    "sra" :  66498,

    "ha" : 66499,

    "AM1" : 66504,
    "AM2" : 66505,
    "AMHA" : 66506,
    "XS" : 66507,
    "DH1" : 66508,
    "DH2" : 66509,
    "BG" : 66510,
    "BU" : 66511,

    "1": 66513,
    "10": 66515,
    "100": 66517
    
  ]





  /** Finds index in a StringBuffer of the next code point
   * beyond a given index.
   * @param i Index to start looking from.
   * @param buff StringBuffer to search in.
   * @return Index of next code point, or -1 if there
   * is none.
   */
  static int getFollowingCP(int i, StringBuffer buff) {
    int nextIdx = buff.offsetByCodePoints(i,1)	

    if (nextIdx >= buff.size()) {
      return -1
    } else {
      int cp = buff.codePointAt(nextIdx)
      return(cp)
    }
  }

  /** Convert a string in ASCII transliteration to 
   * Old Persian range of Unicode.
   * @param s String  in ASCII transliteration.
   * @returns A String in the Unicode range for Old Persian.
   * @throws Exception if input is not valid.
   */
  static String xlitToU(String s)
  throws Exception {
    StringBuilder sb = new StringBuilder()
    // Ignore white space, split into words, then tokenize:
    def words = []
    def currWord = ""
    s.each { c ->
      switch (c) {
      case ' ':
      // omit
      break
      case ':':
      if (currWord.size() > 0) {
	words.add(currWord)
      }
      words.add(":")
      currWord = ""
      break
      default :
      currWord +=  c
      break
      }
    }
    // don't forget possible trailing word!
    if (currWord.size() > 0) {
      words.add(currWord)
    }
    words.each { w ->
      def tokens = w.split('-')
      tokens.each { t ->
	//String lc = t.toLowerCase()
	String lc = t
	if (xlitMap[lc]) {
	  sb.appendCodePoint(xlitMap[lc])
	} else {
	  throw new Exception("OPTransliteration:xlitToU: no transliteration for string ${lc}")
	  //System.err.println "No mapping for ${t}"
	}
      }
    }
    return sb.toString()
  }

  /** Convert a string in Old Persian range of Unicode
   * to the transliteration scheme specified in this project.
   * @param s String of Old Persian represented in Unicode 
   * range for Old Persian.
   * @returns A String in ASCII transliteration.
   * @throws Exception if input includes code points other than
   * white space or one of 50 code points defined for Old Persian
   * cuneiform.
   */
  static String uToXLit(String s)
  throws Exception  {
    StringBuffer uBuffer = new StringBuffer(s.replaceAll(/\w/,''))
    int cp = uBuffer.codePointAt(0)

    int max = uBuffer.codePointCount(0, uBuffer.length() - 1)
    StringBuffer xlit = new StringBuffer(xlitForCodePoint(cp));
    int idx = 0
    boolean inWord = (cp != WORD_DIVIDER)
    Integer cpsFound = 0
    while (cpsFound < max) {
      cpsFound++;
      int nextCP = getFollowingCP(idx,uBuffer)
      if (nextCP > 0) {
	if (nextCP == WORD_DIVIDER) {
	  xlit.append(":")
	  inWord = false

	} else {
	  
	  String charXlit = xlitForCodePoint(nextCP)
	  if (charXlit.size() > 0) {
	    if (inWord) {
	      xlit.append("-${charXlit}")
	    } else {
	      xlit.append(charXlit)
	    }
	  }
	  inWord = true
	}
      }
      idx = uBuffer.offsetByCodePoints(idx,1)
    }
    return xlit.toString()
  }



  /** Converts a single Unicode code point to
   * the corresponding transliteration.
   * @param codept The Unicode code point for a
   * single Old Persian character.
   * @returns The corresponding transliteration.
   * @throws Exception if the character is undefined.
   */
  static String xlitForCodePoint(int codept)
  throws Exception {
    String xlit = ""

    switch (codept) {


    case 66464:
    xlit = "a"
    break
    case 66465:
    xlit = "i"
    break
    case 66466:
    xlit = "u"
    break

    case 66467:
    xlit = "ka"
    break
    case 66468:
    xlit = "ku"
    break
    case 66469:
    xlit = "ga"
    break


    case 66470:
    xlit = "gu"
    break
    case 66471:
    xlit = "xa"
    break
    case 66472:
    xlit = "ca"
    break
    case 66473:
    xlit = "ja"
    break
    case 66474:
    xlit = "ji"
    break
    case 66475:
    xlit = "ta"
    break
    case 66476:
    xlit = "tu"
    break
    case 66477:
    xlit = "da"
    break
    case 66478:
    xlit = "di"
    break
    case 66479:
    xlit = "du"
    break

    case 66480:
    xlit = "tha"
    break
    case 66481:
    xlit = "pa"
    break
    case 66482:
    xlit = "ba"
    break
    case 66483:
    xlit = "fa"
    break
    case 66484:
    xlit = "na"
    break
    case 66485:
    xlit = "nu"
    break
    case 66486:
    xlit = "ma"
    break
    case 66487:
    xlit = "mi"
    break
    case 66488:
    xlit = "mu"
    break
    case 66489:
    xlit = "ya"
    break


    case 66490:
    xlit = "va"
    break
    case 66491:
    xlit = "vi"
    break
    case 66492:
    xlit = "ra"
    break
    case 66493:
    xlit = "ru"
    break
    case 66494:
    xlit = "la"
    break
    case 66495:
    xlit = "sa"
    break
    case 66496:
    xlit = "za"
    break
    case 66497:
    xlit = "sha"
    break
    case 66498:
    xlit = "sra"
    break
    case 66499:
    xlit = "ha"
    break

    
    /* Add logograms, numbers... */
    case 66504:
    xlit = "AM1"
    break
    case 66505:
    xlit = "AM2"
    break
    case 66506:
    xlit = "AMHA"
    break
    case 66507:
    xlit = "XS"
    break
    case 66508:
    xlit = "DH1"
    break
    case 66509:
    xlit = "DH2"
    break
    case 66510:
    xlit = "BG"
    break
    case 66511:
    xlit = "BU"
    break


    case 66512:
    xlit = ":"
    break



    case 66513:
    xlit = "1"
    break
    case 66515:
    xlit = "10"
    break
    case 66517:
    xlit = "100"
    break


    // ignore whitespace:
    case 9:
    case 10:
    case 13:
    case 32:
    break

    default:
    //System.err.println "OPTransliteration:xlitForCodePt: uncrecognized code point " + codept
    throw new Exception("OPTransliteration:xlitForCodePoint: invalid code point ${codept}")
    break

    }
    return xlit
  }

}