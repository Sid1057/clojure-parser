;;parser
(ns parser-module
  (:use [clojure.set]
        [type-data-records :as structs]))

(defn return [x] (if true x))

(defn split-by-words
  [content]
  (clojure.string/split content #"\s+"))

(defn split-by-sentences 
  [content]
  (clojure.string/split content #"(\.|\?|!|;|\Z|$){1,3}(\s|\Z|$)"))

(defn has-some-type-info?
  [words type]
  (some #(re-find (structs/regexp-by-typekey type) %) words))

(defn has-any-info?
  [words]
  (some #(has-some-type-info? words %) structs/regexp-types))

(defn get-type-from-string
  [word type]
  (first (re-find (structs/regexp-by-typekey type) word)))

(defn construct-data-matches
  [words]
  (apply structs/->data-matches 
           (for [type structs/regexp-types]             
             (filter #(not= nil %) (pmap #(get-type-from-string % type) words)))))

(defn map-parser
  [content]
  (->> (return content)
       (split-by-sentences)
       (pmap split-by-words)
       (into [])
       (filter has-any-info?) 
       (pmap #(->sentence-with-data % (construct-data-matches %)))))