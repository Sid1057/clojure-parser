(ns handlers.times)

(defn time-handler
  [sentence-with-data]
  (str "Sentence:" 
           (:sentence sentence-with-data)
           "make something with times" 
           (:time (:data-matches sentence-with-data)) 
           "\n"))