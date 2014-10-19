package edu.holycross.shot.oldpersian


/** A class for working with Old Persian strings represented
 * either in the Old Persian range of Unicode, or in the
 * transliteration scheme specified in this project.
 */
class OPTransliteration {


  /** Unicode code point for Old Persian word divider.*/
  static int WORD_DIVIDER = 66512


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

  /** Convert a string in ASCII translitertion to 
   * Old Persian range of Unicode.
   * @param s String  in ASCII transliteration.
   * @returns A String in the Unicode range for Old Persian.
   */
  static String xlitToU(String s) {
    
  }

  /** Convert a string in Old Persian range of Unicode
   * to the transliteration scheme specified in this project.
   * @param s String of Old Persian represented in Unicode 
   * range for Old Persian.
   * @returns A String in ASCII transliteration.
   */
  static String uToXLit(String s) {
    StringBuffer uBuffer = new StringBuffer(s)
    int cp = uBuffer.codePointAt(0)
    StringBuffer xlit = new StringBuffer(xlitForCodePoint(cp))    

    int max = uBuffer.codePointCount(0, uBuffer.length() - 1)
    int idx = 0
    boolean inWord = (cp != WORD_DIVIDER)
    Integer cpsFound = 0
    while (cpsFound < max) {
      if (getFollowingCP(idx, uBuffer) != null) {
	cpsFound++;
	int nextCP = getFollowingCP(idx,uBuffer)
	if (nextCP == WORD_DIVIDER) {
	  xlit.append(" ")
	  inWord = false

	} else {
	  String charXlit = xlitForCodePoint(nextCP)
	  if (inWord) {
	    xlit.append("-${charXlit}")
	  } else {
	    xlit.append(charXlit)
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
   * @returns The corresponding transliteration, or a
   * null string if the character is undefined.
   */
  static String xlitForCodePoint(int codept) {
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



    default:
    System.err.println "OPTransliteration: uncrecognized code point " + codept
    break

    }
    return xlit
  }

}