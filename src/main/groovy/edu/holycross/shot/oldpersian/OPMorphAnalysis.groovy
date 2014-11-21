package edu.holycross.shot.oldpersian


/** 
 */
class OPMorphAnalysis {

  String surfaceFormUrn
  String lexicalEntityUrn
  String morphologyCode
  

  OPMorphAnalysis(String surface, String lexicalEntity, String morphology) {
    this.surfaceFormUrn = surface
    this.lexicalEntityUrn = lexicalEntity
    this.morphologyCode = morphology
  }

  String verbString() {
    def cols = morphologyCode.split(/:/)

    if (cols.size() < 5) {
      return morphologyCode
    } else {
    String asString = ""
    switch (cols[0]) {
    case "1":
    asString = "first person, "
    break
    case "2":
    asString = "second person, "
    break
    case "3":
    asString = "third person, "
    break
    default:
    asString = "${cols[0]}, "
    break
    }
    switch (cols[1]) {
    case "s":
    asString += "singular, "
    break
    case "pl":
    asString += "plural, "
    break
    default:
    asString += "${cols[1]}, "
    break
    }
    switch (cols[2]) {
    case "pres":
    asString += "present, "
    break
    case "impft":
    asString += "past, "
    break

    default:
    asString += "${cols[2]}, "
    break
    }
    switch (cols[3]) {
    case "ind":
    asString += "indicative, "
    break
    case "subj":
    asString += "subjunctive, "
    break
    case "impv":
    asString += "imperative"
    break
    default:
    asString += "${cols[3]}, "
    break
    }
    switch (cols[4]) {
    case "act":
    asString += "active"
    break
    case "mid":
    asString += "middle"
    break
    case "pass":
    asString += "passive"
    break
    
    default:
    asString += "${cols[4]}"
    break
    }
    
    return asString
    }
  }

  String nounString() {
    def cols = morphologyCode.split(/:/)

    if (cols.size() < 3) {
      return morphologyCode
    } else {
    String asString = ""
    switch (cols[0]) {
    case "masc":
    asString = "masculine, "
    break
    case "fem":
    asString = "feminine, "
    break
    case "neut":
    asString = "neuter, "
    break

    default:
    asString = "${cols[0]}, "
    break
    }

    switch (cols[1]) {
    case "nom":
    asString += "nominative, "
    break
    case "gen":
    asString += "genitive, "
    break
    case "acc":
    asString += "accusative, "
    break
    case "obl":
    asString += "oblique, "
    break
    default:
        asString += "${cols[1]}, "
    break
    }

    switch (cols[2]) {
    case "s":
    asString += "singular"
    break
    case "pl":
    asString += "plural"
    break

    default:
        asString += "${cols[2]}"
    break
    }
    return asString
    }
  }
  
  String toString (String pos) {
    switch (pos) {
      // all substantive forms with GCN:
    case "noun":
    case "pronoun":
    case "adjective":
    return nounString()
    break

    case "verb":
    return verbString()
    break


    case "conjunction":
    case "adverb":
    case "particle":
    case "preposition":
    return "indeclinable"
    break

    
    default:
    System.err.println "Unrecognized part of speech: " + pos
    break
    }
  }
  
}