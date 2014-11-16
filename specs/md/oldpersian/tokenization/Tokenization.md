
# Tokenization #


The `oplang` library tokenizes texts into *orthographic tokens* following the explicit conventions of Old Persian orthography: tokens are delimited by the Old Persian "word divider" character (in transliteration, ":";  in the Old Persian range of Unicode, "𐏐" (103D0).  Note that this means that lexical entities written with attached enclitics or proclitics are treated as a single orthographic token, that could subsequently analyzed as a composition of two lexical units.

While diplomatic editions of Old Persian texts are conventionally cited by physical line, Old Persian layout does not regularly observe these breaks, so orthographic tokens can span physical lines.  Given input consisting of an ordered  series of identifiied lines, the `oplang` library can tokenize the input into an ordered list of tokens.  The input should include an identifier for each line (which could be a URN).  The output will include with each token the identifier of the line where it occurs.    If the token spans more than one input line, the identifier will be expressed as a range from the first to the last input line.

Given these pairings of identifiers and transliterated text:

<pre concordion:set="#datablock">1=a-da-ma:d-a-ra-ya-va-u-sha:xa-
2=sha-a-ya-tha-i-ya:va-za-ra-ka:
</pre>

Get the first element  (element <code concordion:set="#idx">0</code>) from the tokenization, 
the <em concordion:execute="#token = extractToken(#datablock, #idx)">resulting tokenization</em> will identify the first token as
<code concordion:assertEquals="#token.token">a-da-ma</code>.




