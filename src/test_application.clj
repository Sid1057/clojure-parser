(ns test-application
	(:use parser-module))
;; Application test
(def teststr
  "Hello. My name is Ivan. And I'm a student of SPbPU. My phone is 89111801882, email is ivanov.dale@gmail.com and git-hub profile is 
  github.com/Sid1057. Today is friday, 25.03.2015 4:33 PM. $1 > 30 rubles. My favorite programming book is 
  The Art of Unix Programming by Eric S. Raymond")

(println (str teststr "\n\n"))
(println (map format-info-text-for-print (map-parser teststr)))
;(print (map format-info-text-for-print (map-parser (read-line))))))

