###Structure:
 - command
 - description
 - example

#####check
*Check links in sentence, output message about wrong links*
```
input:
check www.google.com www.googge.abv http://github.com/Sid1057/clojure-parser
output:
This is not avalaible links: www.googge.com www.goggee.abv
```
#####wikipedia
*Get information from wikipedia about first proper name in sentence*
```
input:
wikipedia Clojure
output:
Clojure ...
```