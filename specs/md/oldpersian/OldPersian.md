# Old Persian #


This specification defines a computational system for working with
Old Persian cuneiform. 

The following components have been specified with tests passed by the current version of the `oplang` library available from <https://github.com/neelsmith/oplang>:

- an unambiguous one-to-one mapping of [ASCII transliteration to Unicode characters](transliteration/Transliteration.html) in the  Old Persian range
- [tokenization of continuous text](tokenization/Tokenization.html) into orthographic tokens
 - [validation of tokens against an authority list](validation/Validation.html)
- [relating tokens in a text to a variety of lexical information](lexical/Lexical.html) (morphological identification, transcription for transliteration, English definitions)

The following components are either incompletely specified or incompletely implemented:

- a [sorting order for Old Persian cuneiform](sorting/Sorting.html) 



## Key to visual conventions ##


The specifications are defined using [concordion](http://concordion.org) to run
  automated tests.  The resulting web pages are highlighted as follows:


- <span class="success">successfully completed automated tests</span>
- <span class="failure">failed tests</span>


