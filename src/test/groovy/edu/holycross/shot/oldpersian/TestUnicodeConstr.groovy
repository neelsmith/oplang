package edu.holycross.shot.oldpersian


import static org.junit.Assert.*
import org.junit.Test


class TestUnicodeConstr extends GroovyTestCase {


  void testUniConstructor() {
    String adamStr = "𐎠𐎭𐎶𐎶"

    OPString adam = new OPString(adamStr)
    assert adam
  }

}