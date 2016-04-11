(ns handlers.links
  (:use [clojure.string :only (join)]))

(defn get-content-from-link
  "Try to get content from web page. Return link if link is right. 
   Return nil if link is wrong."
  [link]
  (try (if (slurp link) link)
       (catch Exception e (empty nil))))

(defn wikipedia
  "Return content from wikipedia"
  [link]
  (try (if (slurp link) link)
       (catch Exception e (empty nil))))

(defn link-check
  "Try to get content from links in sentence-with-data. 
   If link is right, nothing return. 
   Else return message:
   *link* is not avalaible."
  [sentence-with-data]
  (->>(for [link (:link (:data-matches sentence-with-data))]
           link)
      (filter #(nil? (get-content-from-link %)))
      (clojure.string/join " ")
      (println "This is not avalaible links:")))

(defn link-handler
  ([sentence-with-data]
  	(println "Sentence:" (:sentence sentence-with-data))
  	(println "make something with links" (:link (:data-matches sentence-with-data)) "\n"))
  ([sentence-with-data command]
  	()))