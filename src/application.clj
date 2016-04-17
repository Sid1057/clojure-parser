(ns application	
  (:use [parser-module]
        [type-data-records]
        [router]))

;; Application functions
(defn format-data-matches
  [data]
  (str (into [] 
             (for [type regexp-types :when (not-empty (type data))]
               (str (vector (name type) ":" (type data)))))))

(defn format-sentence-with-data
  [info]
  (str "Data from sentence: "
       (:sentence info)
       "\n"
       (format-data-matches (:data-matches info))
       "\nEnd of record\n\n"))

(defn parse-stdin
  []
  (doseq [data (map-parser (read-line))]
    (route data)))

;; Application test
(defn main
  []
  (println "Input.txt:" (slurp "input.txt") "\n")

  (def parsed-text (map-parser (slurp "input.txt")))

  (doseq [i parsed-text]
    (route i))
)
;  (parse-stdin))
;;exit