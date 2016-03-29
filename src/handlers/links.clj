(ns handlers.links)

(defn link-check
  "Try to get content from web page. Return link if link is right. Return nil if link is wrong."
  [link]
  (try (if (slurp link) link)
       (catch Exception e (empty nil))))

(defn link-handler
  [sentence-with-data]
  ())