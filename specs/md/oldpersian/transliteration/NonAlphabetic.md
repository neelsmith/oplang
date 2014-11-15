
# Transliteration of non-alphabetic characters #


(Note: to read this specification properly, your browser must be capable of displaying characters outside Unicode's basic multilingual plane, and you must have a font installed covering the Old Persian range of Unicode.)


## Punctuation ##


The sole punctuation mark in Old Persian is the word divider <code concordion:set="#worddiv">𐏐</code>.  It is transcribed with a colon,
<code concordion:assertEquals="getPunctXlit(#worddiv)">:</code>.


<div class="example">
  <h3>Example</h3>
  <p>Conversely, the colon <code concordion:set="#colon">:</code> can be converted to the word divider,
  <code concordion:assertEquals="cuneiformPunct(#colon)">𐏐</code>.
  </p>
</div>


## Logograms ##


The Old Persian script includes the following logograms, transliterated with the upper-case ASCII strings defined in this table:


<table concordion:execute="#result = getLogoXlit(#cuneiform)">
  <tr>
    <th concordion:set="#cuneiform">Cuneiform character</th>
    <th concordion:assertEquals="#result">Transliteration</th>
    <th>Transcription</th>
  </tr>
   <tr><td>𐏈</td><td>AM1</td><td/></tr>
   <tr><td>𐏉</td><td>AM2</td><td/></tr>
   <tr><td>𐏊</td><td>AMHA</td><td/></tr>
   <tr><td>𐏋</td><td>XS</td><td/></tr>
   <tr><td>𐏌</td><td>DH1</td><td/></tr>
   <tr><td>𐏍</td><td>DH2</td><td/></tr>
   <tr><td>𐏎</td><td>BG</td><td/></tr>
   <tr><td>𐏏</td><td>BU</td><td/></tr>
</table>  


Because these mapping is 1-1, these relations can be  reversed.

<table concordion:execute="#result = getLogoCun(#logo)">
  <tr>
    <th concordion:set="#logo">Transliteration of logogram</th>
    <th concordion:assertEquals="#result">Cuneiform</th>
  </tr>
   <tr><td>AM1</td><td>𐏈</td></tr>
   <tr><td>AM2</td><td>𐏉</td></tr>
   <tr><td>AMHA</td><td>𐏊</td></tr>
   <tr><td>XS</td><td>𐏋</td></tr>
   <tr><td>DH1</td><td>𐏌</td></tr>
   <tr><td>DH2</td><td>𐏍</td></tr>
   <tr><td>BG</td><td>𐏎</td></tr>
   <tr><td>BU</td><td>𐏏</td></tr>
</table>    


## Numeric signs ##



The individual numeric signs are transcribed as follows:

<table concordion:execute="#result = getLogoXlit(#cuneiform)">
  <tr>
    <th concordion:set="#cuneiform">Cuneiform character</th>
    <th concordion:assertEquals="#result">Transliteration</th>
  </tr>
  <tr><td>𐏑</td><td>1</td></tr>
  <tr><td>𐏓</td><td>10</td></tr>
  <tr><td>𐏕</td><td>100</td></tr>
</table>

Usage of signs in combination will be specified here.
𐏑	1
𐏒	2
𐏓	10
𐏔	20
𐏕	100

