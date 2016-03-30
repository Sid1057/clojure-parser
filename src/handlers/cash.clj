(ns handlers.cash)

(defn cash-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data))
  (println "make something with cash" (:cash (:data-matches sentence-with-data)) "\n"))