
# Transliteration #


(Note: to read this specification properly, your browser must be capable of displaying characters outside Unicode's basic multilingual plane, and you must have a font installed covering the Old Persian range of Unicode.)

## Overview ##

The `oplang` library defines two equivalent transliteration systems for representing text in Old Persian cuneiform.    Fifty Unicode code points in the range for Old Persian cuneiform are equated with unique, case-sensitive ASCII equivalents, so text can be converted from either representation to the other unambiguously and without loss of information.  White space is ignored.    

In the *strict* transliteration, only the defined transliterations and white space are permitted.  In converting from cuneiform code points to ASCII equivalents, it is an error if the input includes code points other than the fifty Old Persian cuneiform characters or white space.  In converting from ASCII transliteration to cuneiform code points, it is an error if the input cannot be parsed into character units according to the specification for [transliteration of continous text](ContinuousText.html), or if any of the character units are not one of the fifty specified ASCII strings.

In the *expanded* transliteration, square brackets, angle brackets, braces and parentheses are also permitted.  In converting from one transliteration to the other, they are passed through unchanged.

<div class="example">
<h3>Examples of strict system of cuneiform code points</h3>

<p><strong>Valid input.</strong> This string is valid:</p>
<blockquote>
<code concordion:set="#good">𐎠 𐎭 𐎶</code>
</blockquote>
<p>The whitespace in it is ignored, and the resulting transliteration is
<code concordion:assertEquals="getXlitForCuneiform(#good)">a-da-ma</code>.
</p>

<p><strong>Invalid input.</strong> This string is invalid input for converting cuneiform code points to ASCII because it  includes non-white-space code points (the characters <code>1.</code>) outside the
fifty defined.</p>
<blockquote>
<code concordion:set="#bad">1. 𐎠𐎭𐎶</code>.
</blockquote>

<p>Attempting to convert it
<code concordion:assertTrue="failedCuneiform(#bad)">results in an exception</code>.
</p>

<h3>Examples of strict ASCII transliteration</h3>
<p><strong>Valid input.</strong></p>
<blockquote>
<code concordion:set="#good">a - da - ma</code>
</blockquote>
<p>The whitespace in it is ignored, and the resulting transliteration is
<code concordion:assertEquals="getCuneiformForXlit(#good)">𐎠𐎭𐎶</code>.
</p>
<p><strong>Invalid input.</strong> 
This string is invalid for converting ASCII transliteration to cuneiform code points
because it  includes a syllabic string (<code>doo</code>) not defined in the ASCII transliteration:
</p>

<blockquote>
<code concordion:set="#bad">ya-ba-da-ba-doo</code>
</blockquote>


<p>Attempting to convert it to cuneiform code points
<code concordion:assertTrue="failedXlit(#bad)">results in an exception</code>.
</p>

<h3>Examples of expanded transliteration systems</h3>
<p><strong>Valid input.</strong></p>
</div>




## Details ##


See the full specification for:

- [thirty-six alphabetic signs](Alphabetic.html)
- [eight logograms and one punctuation character](NonAlphabetic.html)
- [numbers written with five distinct signs](Numbers.html)
- [transliteration of continuous text](ContinuousText.html)

