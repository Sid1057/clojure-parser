(ns handlers.propers)

(defn prop-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data))
  (println "make something with propers" (:proper-name (:data-matches sentence-with-data)) "\n"))