
# Morphology #

The `oplang` library can analyze the morphology of tokens.

Morphological information is serialized as a structured string.  This can be converted to a readable label.

## Examples ##

The <span concordion:set="#pos">noun</span> **kāram** (<code concordion:set="#karam">urn:cite:oldpersian:orth.form41</code>)
is analyzed as <strong concordion:assertEquals="posString(#karam, #pos)">masculine, accusative, singular</strong>.


The conjugated <span concordion:set="#vb">verb</span>  form **ϑātiy** (<code concordion:set="#thatiy">urn:cite:oldpersian:orth.form83</code>)
is analyzed as <strong concordion:assertEquals="posString(#thatiy, #vb)">third person, singular, present, indicative, active</strong>.