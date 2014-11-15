package edu.holycross.shot.oldpersian


import static org.junit.Assert.*
import org.junit.Test


class TestFileXlit extends GroovyTestCase {
  
  void testFile() { 

    def fileList = ["DPa","XPe","DB-1"]

    fileList.each { fName ->
      File src = new File("testdata/${fName}.txt")

      File outFile = new File("testdata/testout/${fName}-xlit.txt")  
      Integer lnCount = 0
      src.eachLine { l ->
	lnCount++;
	String xlit = OPTransliteration.uToXLit(l) 
	outFile.append( "${xlit}" ,"UTF-8")
      }
      outFile.append("\n")
    }
  }
}