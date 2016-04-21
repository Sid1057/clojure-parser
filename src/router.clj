(ns router
(:use [type-data-records :as structs]
      [handlers.commands :as commands]))

(defn route
  [sentence-with-data]
  (doseq [type structs/regexp-by-typekey]
    (if (not-empty (get (:data-matches sentence-with-data) (key type))) 
        ((get commands/handlers (key type)) sentence-with-data))))