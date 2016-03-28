(ns type-data-records)

(def regexp-by-typekey 
  (array-map
    :link #"(https?://)?(www\.)?(\w|\d|-|\.)+\.(com|org|ru|uk|google)((/|\\)(\w|\d|%|=|-|\?|_|/|\.)*)?"
    :phone-number #"(\+?(\d(\s|-|\(|\))?){6,11})";\d+(\s|-)?(\d|\s| |-|\(|\)){5,24})"
    :proper-name #"(([A-Z]\w{3,} ?)+)"
    :date #"((((0|1|2)?\d)|(30|31))(\.|\\|/))(0?([1-9])|(1[012]))((\.|\\|/)([1-9]\d{0,3}))?"
    :time #"((([01]?\d)|(20|21|22|23)):(([0-5]?\d))(:(\D+[0-5]?\d)\D+)?)"
    :email #"((\w|\d|-|\.)+@\w+\.(\w{2,4}))"
    :cash #"((\$(\d,?)+(\.[0-9]{2})?)|((\d,?)+(\.[0-9]{2})?\$))"))

(def regexp-types
  (into [] (for [regexp (into [] regexp-by-typekey)]
             (first regexp))))

(defrecord sentence-with-data [sentence data-matches])
(defrecord data-matches 
  [link
   phone-number
   proper-name
   date
   time
   email
   cash])