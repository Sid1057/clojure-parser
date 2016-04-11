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

;; Application test
(println "Input.txt:" (slurp "input.txt"))

(def parsed-text (map-parser (slurp "input.txt")))

(doseq [i parsed-text]
  (route i))
;;exit