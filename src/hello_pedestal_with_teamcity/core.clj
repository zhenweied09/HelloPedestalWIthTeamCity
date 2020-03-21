(ns hello-pedestal-with-teamcity.core
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

(def unmentionables #{"YHWH" "Voldemort" "Mxyzptlk" "Rumplestiltskin" "曹操"})

(defn ok [body]
  {:status 200 :body body})

(defn not-found []
  {:status 404 :body "Not found\n"})

(defn greeting-for [name]
  (cond 
    (unmentionables name) nil
    (empty? name) "Hello, World!\n" 
    :else (str "Hello," name "\n")))

(defn respond-hello [request] 
  (let [name (get-in request [:query-params :name])
        response (greeting-for name)]
      (if response
        (ok response)
        (not-found))))

(def routes
  (route/expand-routes
  #{["/greet" :get 'respond-hello :route-name :greet]}))

(def service-map 
    {::http/routes routes
    ::http/port 8081
    ::http/type :jetty })

(defn start []
  (http/start (http/create-server service-map)))

(defonce server (atom nil))

(defn start-dev []
  (reset! server
    (http/start 
      (http/create-server 
        (assoc service-map ::http/join? false)))))

(defn stop-dev [] 
  http/stop @server)

(defn restart []
  (stop-dev)
  (start-dev))

(defn -main [] 
  (start))
