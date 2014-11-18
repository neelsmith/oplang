
# Validation #


(Note: to read this specification properly, your browser must be capable of displaying characters outside Unicode's basic multilingual plane, and you must have a font installed covering the Old Persian range of Unicode.)

There are more than 1,000 distinct orthographic tokens in the corpus of Old Persian.  The collection being assembled at <a concordion:set="#ref" href="https://raw.githubusercontent.com/neelsmith/op/master/collections/vocab.csv">https://raw.githubusercontent.com/neelsmith/op/master/collections/vocab.csv</a> can be used to validate a particular token or tokens.


It is also possible to validate a string of continuous text by tokenizing the string, and validating all resulting tokens.


<!--<div class="example">-->

### Examples ###


A valid token:  <strong concordion:assertTrue="isValid(#ref, #TEXT)">a-da-ma</strong>.

An invalid token:  <strong concordion:assertFalse="isValid(#ref, #TEXT)">ya-ba-da-ba-du-u</strong>.

Continuous text to tokenize and validate:

<pre concordion:set="#textinput">
a-da-ma:da-a-ra-ya-va-u-sha:xa-sha-a-ya-tha-i-ya:
</pre>

All of its resulting <strong concordion:assertTrue="stringValid(#ref, #textinput)">tokens are valid</strong>.


<!--</div>-->
