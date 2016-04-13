(ns handlers.propers)

(defn prop-handler
  [sentence-with-data]
  (str "Sentence:" 
       (:sentence sentence-with-data)
       "make something with propers" 
       (:proper-name (:data-matches sentence-with-data)) 
       "\n"))