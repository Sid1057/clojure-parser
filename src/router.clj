(ns router
(:use [type-data-records]
      [handlers.commands]))

(defn route
  [sentence-with-data]
  (doseq [type regexp-by-typekey]
    (if (not-empty (get (:data-matches sentence-with-data) (key type))) 
        ((get handlers (key type)) sentence-with-data))))