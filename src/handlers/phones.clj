(ns handlers.phones)

(defn phone-country
  [sentence-with-data]
  ())

(defn phone-handler
  [sentence-with-data]
  (str "Sentence:" 
       (:sentence sentence-with-data)
       "make something with phones" 
       (:phone-number (:data-matches sentence-with-data)) 
       "\n"))