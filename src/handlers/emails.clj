(ns handlers.emails)

(defn send-mail
	[sentence-with-data]
	())

(defn email-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data))
  (println "make something with emails" (:email (:data-matches sentence-with-data)) "\n"))