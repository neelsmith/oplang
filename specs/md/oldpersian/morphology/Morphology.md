
# Morphology #

The `oplang` library can analyze the morphology of tokens.  The internal object model of a morphological analysis is unspecified:  instead formats for serialization as a structured string are specified.  The serialized form can also be converted directly converted to a readable label.

Given a token identified by is URN, the library can retrieve a (possibly empty) list of morphology objects.

Compound versus simple analysis.

### Examples ###

The orthographic token **hauvciy** (<code concordion:set="#hauvciy">urn:cite:oldpersian:orth.form33</code>) is a combination of two words, *hauv* and the enclitic particle *-ciy*.  It has
only *one*  (<code concordion:assertEquals="numberMorphs(#hauvciy)">1</code>) analysis, but that analysis <strong concordion:assertTrue="isCompound(#hauvciy)">is a compound analysis</strong>.
 
The token **hamaranā** (<code concordion:set="#neutambig">urn:cite:oldpersian:orth.form99</code>  is a neuter noun that can be either accusative or nominative plural in form.  It therefore has two (<code concordion:assertEquals="numberMorphs(#neutambig)">2</code>) analyses.

The <span concordion:set="#pos">noun</span> **kāram** 
(<code concordion:set="#karam">urn:cite:oldpersian:orth.form41</code>)
has only one 
(<code  concordion:assertEquals="numberMorphs(#karam)" >1</code>) analysis, as 
<strong concordion:assertEquals="posString(#karam, #pos)">masculine, accusative, singular</strong>.


The conjugated <span concordion:set="#vb">verb</span>  form **ϑātiy** (<code concordion:set="#thatiy">urn:cite:oldpersian:orth.form83</code>)
is analyzed as <strong concordion:assertEquals="posString(#thatiy, #vb)">third person, singular, present, indicative, active</strong>.