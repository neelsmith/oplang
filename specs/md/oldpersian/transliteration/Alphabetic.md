
# Transliteration #


(Note: to read this specification properly, your browser must be capable of displaying characters outside Unicode's basic multilingual plane, and you must have a font installed covering the Old Persian range of Unicode.)

## Alphabetic signs ##

The following table defines a transliteration for thirty-six alphabetic signs.

The table lists the signs in cuneiform sorting order. (See the specification for [alphabetical sorting of Old Persian cuneiform](../sorting/Sorting.html).)

   <table concordion:execute="#result = getXlit(#cuneiform)">
     <tr>
       <th concordion:set="#cuneiform">Cuneiform character</th>
       <th concordion:assertEquals="#result">Transliteration</th>
     </tr>
<tr><td>𐎣</td><td>ka</td></tr>
<tr><td>𐎿</td><td>sa</td></tr>
<tr><td>𐏀</td><td>za</td></tr>
<tr><td>𐎰</td><td>tha</td></tr>
<tr><td>𐎹</td><td>ya</td></tr>
<tr><td>𐎷</td><td>mi</td></tr>
<tr><td>𐎳</td><td>fa</td></tr>
<tr><td>𐎬</td><td>tu</td></tr>
<tr><td>𐎭</td><td>da</td></tr>
<tr><td>𐎠</td><td>a</td></tr>
<tr><td>𐎨</td><td>ca</td></tr>
<tr><td>𐏁</td><td>sha</td></tr>
<tr><td>𐎤</td><td>ku</td></tr>
<tr><td>𐎥</td><td>ga</td></tr>
<tr><td>𐏃</td><td>ha</td></tr>
<tr><td>𐎦</td><td>gu</td></tr>
<tr><td>𐎯</td><td>du</td></tr>
<tr><td>𐎢</td><td>u</td></tr>
<tr><td>𐎧</td><td>xa</td></tr>
<tr><td>𐎵</td><td>nu</td></tr>
<tr><td>𐏂</td><td>sra</td></tr>
<tr><td>𐎱</td><td>pa</td></tr>
<tr><td>𐎶</td><td>ma</td></tr>
<tr><td>𐎺</td><td>va</td></tr>
<tr><td>𐎩</td><td>ja</td></tr>
<tr><td>𐎻</td><td>vi</td></tr>
<tr><td>𐎪</td><td>ji</td></tr>
<tr><td>𐎽</td><td>ru</td></tr>
<tr><td>𐎡</td><td>i</td></tr>
<tr><td>𐎴</td><td>na</td></tr>
<tr><td>𐎲</td><td>ba</td></tr>
<tr><td>𐎫</td><td>ta</td></tr>
<tr><td>𐎼</td><td>ra</td></tr>
<tr><td>𐎮</td><td>di</td></tr>
<tr><td>𐎸</td><td>mu</td></tr>
<tr><td>𐎾</td><td>la</td></tr>
		
</table>
		
Because there is a one-to-one mapping of signs to transcription, the system can unambiguously convert transcription to the Unicode codepoint for each sign. 



### Examples ###


The same thirty-six signs, here converted from transliteration to Unicode code point.  The table is sorted alphabetically by ASCII transliteration.

   <table concordion:execute="#result = getCuneiform(#xlit)">
     <tr>
       <th concordion:set="#xlit">Transliteration</th>
       <th concordion:assertEquals="#result">Cuneiform character</th>
     </tr>
	<tr><td>a</td><td>𐎠</td></tr>
<tr><td>ba</td><td>𐎲</td></tr>
<tr><td>ca</td><td>𐎨</td></tr>
<tr><td>da</td><td>𐎭</td></tr>
<tr><td>di</td><td>𐎮</td></tr>
<tr><td>du</td><td>𐎯</td></tr>
<tr><td>fa</td><td>𐎳</td></tr>
<tr><td>ga</td><td>𐎥</td></tr>
<tr><td>gu</td><td>𐎦</td></tr>
<tr><td>ha</td><td>𐏃</td></tr>
<tr><td>i</td><td>𐎡</td></tr>
<tr><td>ja</td><td>𐎩</td></tr>
<tr><td>ji</td><td>𐎪</td></tr>
<tr><td>ka</td><td>𐎣</td></tr>
<tr><td>ku</td><td>𐎤</td></tr>
<tr><td>la</td><td>𐎾</td></tr>
<tr><td>ma</td><td>𐎶</td></tr>
<tr><td>mi</td><td>𐎷</td></tr>
<tr><td>mu</td><td>𐎸</td></tr>
<tr><td>na</td><td>𐎴</td></tr>
<tr><td>nu</td><td>𐎵</td></tr>
<tr><td>pa</td><td>𐎱</td></tr>
<tr><td>ra</td><td>𐎼</td></tr>
<tr><td>ru</td><td>𐎽</td></tr>
<tr><td>sa</td><td>𐎿</td></tr>
<tr><td>sha</td><td>𐏁</td></tr>
<tr><td>sra</td><td>𐏂</td></tr>
<tr><td>ta</td><td>𐎫</td></tr>
<tr><td>tha</td><td>𐎰</td></tr>
<tr><td>tu</td><td>𐎬</td></tr>
<tr><td>u</td><td>𐎢</td></tr>
<tr><td>va</td><td>𐎺</td></tr>
<tr><td>vi</td><td>𐎻</td></tr>
<tr><td>xa</td><td>𐎧</td></tr>
<tr><td>ya</td><td>𐎹</td></tr>
<tr><td>za</td><td>𐏀</td></tr>
</table>
