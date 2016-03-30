(ns handlers.commands)

(defn command-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data))
  (println "make something with commands" (:command (:data-matches sentence-with-data)) "\n"))