(ns handlers.links)

(defn link-check
  "Try to get content from web page. Return link if link is right. Return nil if link is wrong."
  [link]
  (try (if (slurp link) link)
       (catch Exception e (empty nil))))

(defn link-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data))
  (println "make something with links" (:link (:data-matches sentence-with-data)) "\n"))