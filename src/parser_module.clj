;;parser
(ns parser-module
  (:use [clojure.set]
        [type-data-records]))

(defn return [x] (if true x))

(defn split-by-words
  [content]
  (clojure.string/split content #"\s+"))

(defn split-by-sentences 
  [content]
  (clojure.string/split content #"(\.|\?|!|;|\Z|$){1,3}(\s|\Z|$)"))

(defn has-some-type-info?
  [words type]
  (some #(re-find (regexp-by-typekey type) %) words))

(defn has-any-info?
  [words]
  (some #(has-some-type-info? words %) regexp-types))

(defn get-type-from-string
  [word type]
  (first (re-find (regexp-by-typekey type) word)))

(defn construct-data-matches
  [words]
  (apply ->data-matches 
          (for [type regexp-types]             
            (filter #(not= nil %) (map #(get-type-from-string % type) words)))))

(defn map-parser
  [content]
  (->> (return content)
       (split-by-sentences)
       (map split-by-words)
       (into [])
       (filter has-any-info?) 
       (map #(->sentence-with-data % (construct-data-matches %)))))

(defn link-check
  "Try to get content from web page. Return link if link is right. Return nil if link is wrong."
  [link]
  (try (if (slurp link) link)
       (catch Exception e (empty nil))))