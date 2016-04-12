(ns handlers.dates)

(defn remind
	[sentence-with-data]
	())

(defn date-handler
  [sentence-with-data]
  (str "Sentence:" 
       (:sentence sentence-with-data)
       "make something with dates" 
       (:date (:data-matches sentence-with-data))
       "\n"))