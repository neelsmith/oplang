# Old Persian #


This specification defines a computational system for working with
Old Persian cuneiform. 

The following components have been specified with tests passed by the current version of the `oplang` library:

- an unambiguous one-to-one mapping of [ASCII transliteration to Unicode characters](transliteration/Transliteration.html) in the  Old Persian range
- [tokenization of continuous text](tokenization/Tokenization.html) into orthographic tokens
 
The followign components are either incompletely specified or incompletely implemented:

- a [sorting order for Old Persian cuneiform](sorting/Sorting.html) (TO BE ADDED)
- validation of tokens against an authority list
- resolutoin of orthographic tokens to one or more lexical tokens



## Key to visual conventions ##


The specifications are defined using [concordion](http://concordion.org) to run
  automated tests.  The resulting web pages are highlighted as follows:


- <span class="success">successfully completed automated tests</span>
- <span class="failure">failed tests</span>


