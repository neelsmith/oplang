package edu.holycross.shot.oldpersian


/**
 */
class OPTransliteration {

  static int WORD_DIVIDER = 66512


  static int getFollowingCP(int i, StringBuffer buff) {
    int nextIdx = buff.offsetByCodePoints(i,1)	

    if (nextIdx >= buff.size()) {
      return -1
    } else {
      int cp = buff.codePointAt(nextIdx)
      return(cp)
    }
  }

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
	  println "OPTransliteration: word divider."
	  xlit.append(" ")
	  inWord = false

	} else {
	  String charXlit = xlitForCodePoint(nextCP)
	  println "OPTransliteration: for code point ${nextCP}, got xlit ${charXlit} with inword ${inWord}"
	  if (inWord) {
	    xlit.append("-${charXlit}")
	  } else {
	    xlit.append(charXlit)
	  }
	  inWord = true
	}
      }
      idx = uBuffer.offsetByCodePoints(idx,1)
      println "Advacne to ${cpsFound} out of ${max} (index ${idx} out of ${uBuffer.size()} )"
    }
    return xlit.toString()
  }

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

    default:
    System.err.println "OPTransliteration: uncrecognized code point " + codept
    break
    /* Add logograms, numbers... */


    }
    return xlit
  }

}