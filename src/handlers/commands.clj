(ns handlers.commands
  (:use
    [handlers.links :as links]
    [handlers.phones :as phones]
    [handlers.propers :as propers]
    [handlers.dates :as dates]
    [handlers.times :as times]
    [handlers.emails :as emails]
    [handlers.cash :as cash])
  (:require clojure.string))

(def commands-dict{
  :check #(links/link-check %)
  :wikipedia #(links/wikipedia %)
  :remind #(dates/remind %)
  :send-mail #(emails/send-mail %)
  :phone-country #(phones/phone-country %)})

(defn command-handler
  [sentence-with-data]
  (println "Sentence:" (:sentence sentence-with-data) 
           "\nCommand: " (:command (:data-matches sentence-with-data)))
  (if (->>(:data-matches sentence-with-data)
          (:command)
          (not-empty)) ;then
      (println ((->>(:data-matches sentence-with-data)
                    (:command)
                    (first)
                    (clojure.string/lower-case)
                    (keyword)
                    (get commands-dict)) sentence-with-data ))))

(def handlers {
  :link #(links/link-handler %)
  :phone-number #(phones/phone-handler %)
  :proper-name #(propers/prop-handler %)
  :date #(dates/date-handler %)
  :time #(times/time-handler %)
  :email #(emails/email-handler %)
  :cash #(cash/cash-handler %)
  :command #(command-handler %)
  })