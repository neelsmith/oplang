package edu.holycross.shot.oldpersian


import static org.junit.Assert.*
import org.junit.Test


class TestLongXlit extends GroovyTestCase {

  /*  void testCP() {
    assert OPTransliteration.xlitForCodePoint(66492) == "ra"
    }*/


  void testSentence() { 
    String sentence = "𐎭𐎠𐎼𐎹𐎺𐎢𐏁𐏐𐎧𐏁𐎠𐎹𐎰𐎡𐎹𐏐𐎺𐏀𐎼𐎣𐏐"
    String xlitSentence = "da-a-ra-ya-va-u-sha xa-sha-a-ya-tha-i-ya va-za-ra-ka "
    System.err.println "Expected #" + xlitSentence + "# (length ${xlitSentence.size()})"
    String reply = OPTransliteration.uToXLit(sentence) 
    System.err.println "Got #" + reply + "# (length ${reply.size()})"


    assert reply == xlitSentence
  }


}