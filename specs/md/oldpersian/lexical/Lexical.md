
# Lexical operations #

The `oplang` library can consult on-line collections of forms and lexical information.


## Transcription ##


For recognized forms, the library can determine whether a not a form is recognized, and if recognized, can provide transcriptions for transliterated form.

### Examples ###



A recognized form: <strong concordion:assertTrue="isRecognized(#TEXT)">a-da-ma</strong>.

An unrecognized form: <strong concordion:assertFalse="isRecognized(#TEXT)">ya-ba-da-ba-du-u</strong>.

The form <code concordion:set="#xlit">a-da-ma</code> is transcribed as <strong concordion:assertEquals="transcribe(#xlit)">adam</strong>, while the form
<code concordion:set="#xerxes">xa-sha-ya-a-ra-sha-a</code> is transcribed as <strong concordion:assertEquals="transcribe(#xerxes)">Xšayāršā</strong>.


## Morphological resolution ##

Recognized forms can be resolved to a specific lexical entity. 

### Examples ###


The nominative form of the first pronouns is **adam** (<code concordion:set="#adam">urn:cite:oldpersian:orth.form4</code>).  
When we <span concordion:execute="#an1 = findLemma(#adam)">analyze it morphologically</span>,  we find that it is a form of the lexical entity 
<strong concordion:assertEquals="#an1.lexicalEntityUrn">urn:cite:oldpersian:lex.4</strong>.




An oblique case of the same pronoun is **manā** (<code concordion:set="#mana">urn:cite:oldpersian:orth.form46</code>).    When we <span concordion:execute="#an2 = findLemma(#mana)">analyze it</span>, we find that it, too, is a form of <strong concordion:assertEquals="#an2.lexicalEntityUrn">urn:cite:oldpersian:lex.4</strong>.

## Lexicon ##

We can an look up information, including notes on  translation, by the URN of a lexical item.  

### Example ###

The first-person personal pronoun has the urn <code concordion:set="#adam">urn:cite:oldpersian:lex.4</code>: its definition in the lexical notes is

<blockquote concordion:assertEquals="translate(#adam)">I (1st person pronoun)</blockquote>


