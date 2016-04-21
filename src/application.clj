(ns application	
  (:use [parser-module :as parser]
        [type-data-records :as structs]
        [router :as router]))

(defn format-data-matches
  [data]
  (str (into [] 
             (for [type structs/regexp-types :when (not-empty (type data))]
               (str (vector (name type) ":" (type data)))))))

(defn format-sentence-with-data
  [info]
  (str "Data from sentence: "
       (:sentence info)
       "\n"
       (format-data-matches (:data-matches info))
       "\nEnd of record\n\n"))

(defn parse-stdin
  ([]
  (doseq [data (parser/map-parser (read-line))]
    (router/route data)))
  ([string]
  (doseq [data (parser/map-parser string)]
    (router/route data))))