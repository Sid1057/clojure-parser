(ns application	
  (:use [parser-module]
        [type-data-records]
        [router]))

;; Application functions
(defn format-data-matches
  [data]
  (str (into [] 
             (for [type regexp-types :when (not-empty (type data))]
               (str (vector (name type) ":" (type data)))))))

(defn format-sentence-with-data
  [info]
  (str "Data from sentence: "
       (:sentence info)
       "\n"
       (format-data-matches (:data-matches info))
       "\nEnd of record\n\n"))

;; Application test
(def teststr
  "Hello. My name is Ivan. And I'm a student of SPbPU. My phone is 89111801882, email is ivanov.dale@gmail.com and git-hub profile is 
  github.com/Sid1057. Today is friday, 25.03.2015 14:33. $1 > 30 rubles. My favorite programming book is 
  The Art of Unix Programming by Eric S. Raymond. Test. Test...")

(def parsed-text (map-parser teststr))

(doseq [i parsed-text]
  (route i))

;;exit