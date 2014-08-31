package edu.holycross.shot.oldpersian


/**
 * A class for working with text in Old Persian cuneiform.  
 * Instances may be initialized using either Unicode code points in the range for Old Persian cuneiform, or
 * following an ASCII representation using standard transliteration.
 *
 */
class OPString {

  // Temporary constructs for debugging:
  Integer debugLevel = 0

  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3

  /** Immutable set of consonant characters. */
  static consonant = [
  ]

  /** Immutable set of vowel characters. */
  static vowel = [
  ]

  /** Immutable set of vowel quantity markers. */
  static numeric = []

  /** Immutable set of punctuation characters. */
  static punctuation = [
  ]

  /** The string in Unicode characters.*/
  String unicodeString

  /** The string in standard transliteration.*/
  String transliteration


  /** Constructor determines if srcString is valid transliteration
   * or Unicode form of Old Persian String.
   * @param srcString String composed either of code points in the 
   * Unicode Old Persian range, or the ASCII set used in standard
   * transliteration of Old Persian.
   * @throws Exception if not all characters in srcString are valid.
   */
  OPString(String srcString)  
  throws Exception {
    StringBuffer strBuff = new StringBuffer(srcString)

    // Check value of first codepoint  != space or nl
    // to see if OP text is in xlit or ucode
    boolean foundIt = false
    int cpCount = 0
    while (! foundIt) {
      int cp = strBuff.codePointAt(cpCount) 
      if (debugLevel > WARN) {
	System.err.println "OPString: checking codepoint " + cp
      }
      switch ( cp) {
      case 32:
      case 10:
      break

      case 66464..66517:
      foundIt = true
      this.unicodeString = srcString
      this.transliteration = OPTransliteration.uToXLit(srcString)
      break

      case 45:
      case 48..57:
      case 65..90:
      case 97..122:
      foundIt = true
      break

      default:
      String badChar =   new String(Character.toChars(strBuff.codePointAt(cpCount)))
      throw new Exception("OPString: invalid character in input: ${badChar}")
      break
      }
      cpCount++;
    }
  }

  /** Overrides default implementation of toString.
   * @returns Beta-code version of a Greek word.
   */
  String toString() {
    return this.unicodeString
  }

}