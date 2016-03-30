(ns handlers.times)

(defn time-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data))
  (println "make something with times" (:time (:data-matches sentence-with-data)) "\n"))