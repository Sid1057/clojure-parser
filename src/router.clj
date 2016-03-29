(ns router
  (:use [type-data-records]

        [handlers.links]
        [handlers.phones]
        [handlers.propers]
        [handlers.dates]
        [handlers.times]
        [handlers.emails]
        [handlers.cash]
        [handlers.commands]))

(def handlers {
  :link #(link-handler %)
  :phone-number #(phone-handler %)
  :proper-name #(prop-handler %)
  :date #(date-handler %)
  :time #(time-handler %)
  :email #(email-handler %)
  :cash #(cash-handler %)
  :command #(command-handler %)
  })

(defn route
  [sentence-with-data]
  (doseq [type regexp-by-typekey]
    (if (not-empty (get (:data-matches sentence-with-data) (first type))) 
        ((get handlers (first type)) sentence-with-data)
        ())))