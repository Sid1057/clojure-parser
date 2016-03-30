(ns handlers.dates)

(defn date-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data))
  (println "make something with dates" (:date (:data-matches sentence-with-data)) "\n"))