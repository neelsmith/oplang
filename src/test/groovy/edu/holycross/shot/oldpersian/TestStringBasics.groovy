package edu.holycross.shot.oldpersian


import static org.junit.Assert.*
import org.junit.Test


class TestStringBasics extends GroovyTestCase {




  void testXlitConstructor() {
    OPString xlit = new OPString("a-da-ma")
    assert xlit

    OPString leadingSpace = new OPString("   a-da-ma")
    assert leadingSpace

    String leadingNL = """

a-da-ma
"""
    OPString wNL = new OPString(leadingNL)
    assert wNL


    assert shouldFail {
      OPString empty = new OPString("")
    }
    

    assert shouldFail {
      OPString noContent = new OPString("   ")
    }

    assert shouldFail {
      OPString badContent = new OPString(".,<>")
    }
    
  }


  void testUniConstructor() {
    String adamStr = "𐎠𐎭𐎶𐎶"

    OPString adam = new OPString(adamStr)
    assert adam
  }

}