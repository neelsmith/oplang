package edu.holycross.shot.oldpersian


/** An instance of a word form
 */
class OPForm {

  // trasnliteration
  String transliterated
  // transcription
  String transcribed

  /** Authority list for validating tokens. */
  static URL authList = new URL("https://raw.githubusercontent.com/neelsmith/op/master/collections/vocab.csv")

  OPForm(String xlit, String xscr) {
    this.transliterated = xlit
    this.transcribed = xscr
  }


  
}