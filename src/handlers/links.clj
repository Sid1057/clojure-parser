(ns handlers.links
  (:require [clojure.string :as string]))

(defn get-content-from-link
  "Try to get content from web page. Return link if link is right. 
   Return nil if link is wrong."
  [link]
  (try (if (slurp link) link)
       (catch Exception e (empty nil))))

(defn wikipedia
  "Return content from wikipedia"
  [sentence-with-data]
  (try (string/replace 
          (->>(:data-matches sentence-with-data)
              (:proper-name)
              (first)
              (str "https://www.wikipedia.org/wiki/")
              (slurp)
              (re-find #"\<p\>.+\</p\>.*"))
          #"(\<(/?[^\>]+)\>)" 
          "")
       (catch Exception e (println e))))

(defn link-check
  "Try to get content from links in sentence-with-data. 
   If link is right, nothing return. 
   Else return message:
   *link* is not avalaible."
  [sentence-with-data]
  (let [unvalaible-links (->>(for [link (:link (:data-matches sentence-with-data))]
                               link)
                             (map #(if (re-find #"https?://" %) % (str "https://" %)) )
                             (filter #(nil? (get-content-from-link %)))
                             (string/join " "))]
      (if (empty? unvalaible-links)
        (str "All links are avalaible.")
        (str "This is not avalaible links: " unvalaible-links))))

(defn link-handler
  ([sentence-with-data]
  	(str "Sentence:" 
         (:sentence sentence-with-data)
  	     "make something with links" 
         (:link (:data-matches sentence-with-data)) 
         "\n")))