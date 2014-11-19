
# Lexical operations #


(Note: to read this specification properly, your browser must be capable of displaying characters outside Unicode's basic multilingual plane, and you must have a font installed covering the Old Persian range of Unicode.)


The library can consult on-line collections of forms and lexical information.

For recognized forms, the library can determine whether a not a form is recognized, and if recognized, can provide transcriptions for transliterated form.

## Examples ##

A recognized form: <strong concordion:assertTrue="isRecognized(#TEXT)">a-da-ma</strong>.

An unrecognized form: <strong concordion:assertFalse="isRecognized(#TEXT)">ya-ba-da-ba-du-u</strong>.

The form <code concordion:set="#xlit">a-da-ma</code> is transcribed as <strong concordion:assertEquals="transcribe(#xlit)">adam</strong>.
