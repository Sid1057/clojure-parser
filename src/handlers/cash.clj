(ns handlers.cash)

(defn cash-handler
  [sentence-with-data]
  (str "Sentence:" 
       (:sentence sentence-with-data)
  		 "make something with cash" 
       (:cash (:data-matches sentence-with-data)) 
       "\n"))