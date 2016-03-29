(ns type-data-records)

(def regexp-by-typekey 
  (array-map
    :link #"(https?://)?(www\.)?(\w|\d|-|\.)+\.(com|org|ru|uk|google)((/|\\)(\w|\d|%|=|-|\?|_|/|\.)*)?"
    :phone-number #"(\+?(\d(\s|-|\(|\))?){6,11})";\d+(\s|-)?(\d|\s| |-|\(|\)){5,24})"
    :proper-name #"(([A-Z]\w{3,} ?)+)"
    :date #"((((0|1|2)?\d)|(30|31))(\.|\\|/))(0?([1-9])|(1[012]))((\.|\\|/)([1-9]\d{0,3}))?"
    :time #"((([01]?\d)|(20|21|22|23)):(([0-5]?\d))(:(\D+[0-5]?\d)\D+)?)"
    :email #"((\w|\d|-|\.)+@\w+\.(\w{2,4}))"
    :cash #"((\$(\d,?)+(\.[0-9]{2})?)|((\d,?)+(\.[0-9]{2})?\$))"
    :command #"(\:\w+)"))

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
   cash
   commands])

; (defn empty-data-matches
;   []
;   (apply ->data-matches
;     (for [type regexp-types] {})))

; (defrecord data-touple [data sentences])

; (defn data-touple-from-data-matches
;   [data-matches-by-type sentence]
;   (let [result-touple {}]
;     (apply merge-with 
;            concat 
;            result-touple 
;            (for [i data-matches-by-type]
;               ({(keyword i) [sentence]})))))

; (defn get-edm-from-swd
;   "convert from sentence-with-data to empty-data-matches of data-touple"
;   [sentence-with-data]
;   (apply ->data-matches
;     (for [type regexp-types]
;       (data-touple-from-data-matches (type sentence-with-data)
;                                      (:sentence sentence-with-data)))))

; (defn convert-from-swd-to-dm
;   ; "union-data is result, that should be like                              ;; union-data is empty-data-matches
;   ;   {:links {{"vk.com" ["sentence one with vk.com" "sentence two vk.com"} ;; it's key(:links) and data-touple of string-key("vk.com") and vector of sentences
;   ;            {"google.com" ["love google"]} 
;   ;           } 
;   ;    :dates ...}
;   ;   }"
;   [sentence-touple-vector]
;   (let [union-data (empty-data-matches)]  
;     (doseq [sentence-touple sentence-touple-vector]
;       (doseq [type regexp-types]
;         (sentence-touple [:data-matches type])))
;   ))