
# Tokenization #


The `oplang` library tokenizes texts into *orthographic tokens* following the explicit conventions of Old Persian orthography: tokens are delimited by the Old Persian "word divider" character (in transliteration, ":";  in the Old Persian range of Unicode, "𐏐" (103D0).  Note that this means that lexical entities written with attached enclitics or proclitics are treated as a single orthographic token, that could subsequently analyzed as a composition of two lexical units.

While diplomatic editions of Old Persian texts are conventionally cited by physical line, the layout of Old Persian texts does not regularly observe these breaks, so orthographic tokens can span physical lines.  Given input consisting of an ordered  series of identifiied lines, the `oplang` library can tokenize the input into an ordered list of tokens.  The input should include an identifier for each line (which could be a URN).  The output will include with each token the identifier of the line where it occurs.    If the token spans more than one input line, the identifier will be expressed as a range from the first to the last input line.
<div class="example">
<h3>Example</h3>
<p>The tokenization of the following pairings of identifiers and transliterated texs yields produces an ordered list of four tokens:</p>

<pre concordion:set="#datablock">line1=a-da-ma:d-a-ra-ya-va-u-sha:xa-
line2=sha-a-ya-tha-i-ya:va-za-ra-ka:
</pre>


<table concordion:execute="#token = extractToken(#datablock, #idx)">
<tr>
<th concordion:set="#idx">Sequence (0-origin)</th>
<th concordion:assertEquals="#token.token">Token</th>
<th concordion:assertEquals="#token.occurrence">Passage reference</th>
</tr>
<tr>
<td>0</td>
<td>a-da-ma</td>
<td>line1</td>
</tr>

<tr>
<td>1</td>
<td>d-a-ra-ya-va-u-sha</td>
<td>line1</td>
</tr>


<tr><td>2</td><td>xa-sha-a-ya-tha-i-ya</td><td>line1-line2</td></tr>

<tr><td>3</td><td>va-za-ra-ka</td><td>line2</td></tr>

</table>

</div>


White space is omitted in tokenization.

### Example ###

Given a transliteration including white space like 

<blockquote concordion:set="#white">a - da - ma:da-a-ra-ya-va-u-sha</blockquote>,
 the first token (<code concordion:set="#tokenidx">0</code>) 
in the 
<span concordion:execute="#res = extractStrippedToken(#white, #tokenidx)">resulting tokenization</span>
should be <strong concordion:assertEquals="#res.token">a-da-ma</strong>.



## Extended transliteration system ##


The library supports an option to accept the extended transliteration (possibly including brackets, etc.), but to strip them out of the tokenization.

### Example ###

Given a sequence <code concordion:set="#extended">a[-da]-ma:</code>,
tokenizing the first token (<code concordion:set="#idx">0</code>) in the
resulting <span concordion:execute="#result=extractStrippedToken(#extended,#idx)">tokenization</span> should be 

 <strong concordion:assertEquals="#result.token">a-da-ma</strong>.

