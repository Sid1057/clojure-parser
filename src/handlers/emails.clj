(ns handlers.emails)

(defn send-mail
  [sentence-with-data]
  ())

(defn email-handler
  [sentence-with-data]
  (str "Sentence:" 
       (:sentence sentence-with-data)
       "make something with emails" 
       (:email (:data-matches sentence-with-data))
       "\n"))