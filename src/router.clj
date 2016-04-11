  (ns router
  (:use [type-data-records]
        [handlers.commands]))

(defn route
  [sentence-with-data]
  (doseq [type regexp-by-typekey]
    (if (not-empty (get (:data-matches sentence-with-data) (first type))) 
        ((get handlers (first type)) sentence-with-data)
        ())))