(ns type-data-records
  (:use [handlers.commands])
  (:require [clojure.string]))

(defn every-case-regexp
  [word]
  (re-pattern (str "(" 
                   (first word) 
                   "|" 
                   (clojure.string/upper-case (first word)) 
                   ")"
                   (clojure.string/join "" (pmap str (next word))))))

(def commands-dict-regexp
  (re-pattern (str "(" 
                    (clojure.string/join 
                      "|" 
                      (pmap #(every-case-regexp (name %)) (keys commands-dict))) 
                    ")")))

(def regexp-by-typekey 
  (array-map
    :link #"(https?://)?(www\.)?(\w|\d|-|\.)+\.\w{2,8}((/|\\)(\w|\d|%|=|-|\?|_|/|\.)*)?"
    :phone-number #"(\+?(\d(\s|-|\(|\))?){6,11})";\d+(\s|-)?(\d|\s| |-|\(|\)){5,24})"
    :proper-name #"(([A-Z]\w{3,} ?)+)"
    :date #"((((0|1|2)?\d)|(30|31))(\.|\\|/))(0?([1-9])|(1[012]))((\.|\\|/)([1-9]\d{0,3}))?"
    :time #"((([01]?\d)|(20|21|22|23)):(([0-5]?\d))(:(\D+[0-5]?\d)\D+)?)"
    :email #"((\w|\d|-|\.)+@\w+\.(\w{2,4}))"
    :cash #"((\$(\d,?)+(\.[0-9]{2})?)|((\d,?)+(\.[0-9]{2})?\$))"
    :command commands-dict-regexp))

(def regexp-types
  (doall (for [regexp (keys regexp-by-typekey)]
             regexp)))

(defrecord sentence-with-data [sentence data-matches])
(defrecord data-matches 
  [link
   phone-number
   proper-name
   date
   time
   email
   cash
   command])