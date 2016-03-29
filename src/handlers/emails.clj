(ns handlers.emails
  (:use parser-module))

(defn email-handler
  [sentence-with-data]
  (println (:sentence sentence-with-data)))