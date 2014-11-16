package edu.holycross.shot.oldpersian


/** occurence of a token
 */
class OPToken {

  String occurrence
  String token
  
  // can be initialized from an arraylist of
  // pairings between ID (such as URN) and xliterated
  // text.  The pairing should itself be a 2-element
  // ArrayList, so an ArrayList of ArrayLists.
  
  OPToken( String psg, String form) {
    this.occurrence = psg
    this.token = form
  }


}