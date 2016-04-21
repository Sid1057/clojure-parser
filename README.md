# clojure-parser
Library to produce an informative data from some text.

###Supported data types:
 - Links
 - Dates
 - Times
 - Emails
 - Phone-numbers
 - Proper names

###Commands:
#####Supported commands:
 - Check *links*
 - Wikipedia *Proper name*
 
#####In the pipeline:
 - Send-mail *message* to *email*
 - Remind *message* *time and maybe date*
 - Phone-country *phone number*

[More about commands][Commands descriptions]

###Usage(in REPL):

#####Console:
``` sh
  lein deps
  lein compile
  lein repl
```
#####REPL:
``` repl
  (parse string)
```

###Example
![example's image alt](https://github.com/Sid1057/clojure-parser/raw/master/doc/cmd-screenshot.jpg)

###License and copyright
[GPLv3]

[GPLv3]: <http://www.github.com/Sid1057/clojure-parser/blob/master/LICENSE.md>
[commands descriptions]: <http://www.github.com/Sid1057/clojure-parser/blob/master/doc/commands-list.md>