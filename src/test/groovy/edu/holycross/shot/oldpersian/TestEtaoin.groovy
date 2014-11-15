package edu.holycross.shot.oldpersian


import static org.junit.Assert.*
import org.junit.Test


class TestEtaoin extends GroovyTestCase {
  
  void testFile() { 



    File src = new File("op-etaoin.txt")
    File outFile = new File("testdata/testout/etaoin-xlit.txt")  
    Integer lnCount = 0
    src.eachLine { l ->
      lnCount++;
      String xlit = OPTransliteration.uToXLit(l) 
      outFile.append( "${xlit}" ,"UTF-8")
    }
    outFile.append("\n")
  }
}