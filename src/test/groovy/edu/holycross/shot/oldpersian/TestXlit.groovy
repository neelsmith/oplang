package edu.holycross.shot.oldpersian


import static org.junit.Assert.*
import org.junit.Test


class TestXlit extends GroovyTestCase {

  String adamStr = "𐎠𐎭𐎶"
  String xlit = "a-da-ma"

  void testStatic() {
    assert OPTransliteration.uToXLit(adamStr) == xlit
  }

  void testUToXlit() {
    OPString adam = new OPString(adamStr)
    assert adam.getTransliteration() == xlit
  }

}