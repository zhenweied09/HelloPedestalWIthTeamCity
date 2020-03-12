(ns hello-pedestal-with-teamcity.core
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route])
  ; (:gen-class)
  )

(defn respond-hello [request] 
  {:status 200
    :body "Hello, World."})

(def routes
  (route/expand-routes
  #{["/greet" :get 'respond-hello :route-name :greet]}))

(defn start []
  (-> { ::http/routes routes
        ::http/port 8081
        ::http/type :jetty }
      http/create-server
      http/start))

; (defn -main
;   "I don't do a whole lot ... yet."
;   [& args]
;   (println "Hello, World!"))
