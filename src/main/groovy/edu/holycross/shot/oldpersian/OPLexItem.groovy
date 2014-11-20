package edu.holycross.shot.oldpersian


/** An instance of a  lexical entity
 */
class OPLexItem {

  String stem
  String pos
  String translation

  /** Authority list for validating tokens. */
  static URL authList = new URL("https://raw.githubusercontent.com/neelsmith/op/master/collections/lexicon.csv")

  OPLexItem(String root, String ptOfSpeech, String xlation) {
    this.stem = root
    this.pos = ptOfSpeech
    this.translation = xlation
  }

}