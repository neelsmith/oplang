
# Tokenization #


The `oplang` library tokenizes texts into *orthographic tokens* following the explicit conventions of Old Persian orthography: tokens are delimited by the Old Persian "word divider" character (in transliteration, ":";  in the Old Persian range of Unicode, "𐏐" (103D0).  Note that this means that lexical entities written with attached enclitics or proclitics are treated as a single orthographic token, that could subsequently analyzed as a composition of two lexical units.

While diplomatic editions of Old Persian texts are conventionally cited by physical line, the layout of Old Persian texts does not regularly observe these breaks, so orthographic tokens can span physical lines.  Given input consisting of an ordered  series of identifiied lines, the `oplang` library can tokenize the input into an ordered list of tokens.  The input should include an identifier for each line (which could be a URN).  The output will include with each token the identifier of the line where it occurs.    If the token spans more than one input line, the identifier will be expressed as a range from the first to the last input line.
<div class="example">
<h3>Example</h3>
<p>The tokenization of the following pairings of identifiers and transliterated texs yields produces an ordered list of four tokens:</p>

<pre concordion:set="#datablock">1=a-da-ma:d-a-ra-ya-va-u-sha:xa-
2=sha-a-ya-tha-i-ya:va-za-ra-ka:
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
<td>1</td>
</tr>

<tr>
<td>1</td>
<td>d-a-ra-ya-va-u-sha</td>
<td>1</td>
</tr>


<tr><td>2</td><td>xa-sha-a-ya-tha-i-ya</td><td>1-2</td></tr>

<tr><td>3</td><td>va-za-ra-ka</td><td>2</td></tr>

</table>

<p></p>
</div>

