# clojure-parser
Library to produce an informative data from some text.

###Description

###Note!

###Supported data types:
 - Links
 - Dates
 - Times
 - Emails
 - Phone-numbers
 - Proper names

###Commands:
#####Supported commands:
 
#####In the pipeline:
 - Check *links*
 - Send-mail *message* to *email*
 - Wikipedia *Proper name*
 - Remind *message* *time and maybe date*
 - Phone-country *phone number*

[More about commands][Commands descriptions]

###Usage(just a simple example of demo version):
#####input.txt
*Text for parsing*

#####Console:
``` sh
  lein deps
  lein compile
  lein repl
```

###Example
#####input.txt:
>Hello. My name is Ivan. And I'm a student of SPbPU. My phone is 89111801882, email is ivanov.dale@gmail.com and git-hub profile is github.com/Sid1057. Today is friday, 25.03.2015 14:33. $1 > 30 rubles. My favorite programming book is The Art of Unix Programming by Eric S. Raymond>. Test. Test...
>
>Check www.google.com

#####Result:
![example's image alt](https://github.com/Sid1057/clojure-parser/raw/master/doc/cmd-screenshot.jpg)

###License and copyright

[commands descriptions]: <http://www.github.com/Sid1057/clojure-parser/blob/master/doc/commands-list.md>