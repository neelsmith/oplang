package edu.holycross.shot.oldpersian


/**
 * A class for working with a Greek word.
 */
class OPWord {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0

  OPString oldPersianWord

  /** Constructor ...
   * @param srcString 
   * @throws Exception if not all characters in srcString are valid.
   */
  OPWord(String srcString) 
  throws Exception {
    Integer count = 0
    this.oldPersianWord = new OPString(srcString)
  }


  /** Overrides default implementation of toString.
   * @returns Beta-code version of a Greek word.
   */
  String toString() {
    return this.oldPersianWord
  }

}