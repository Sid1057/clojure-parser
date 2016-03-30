(ns handlers.phones)

(defn phone-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data))
  (println "make something with phones" (:phone-number (:data-matches sentence-with-data)) "\n"))