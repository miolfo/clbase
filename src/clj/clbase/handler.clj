(ns clbase.handler
  (require [ring.adapter.jetty :as jetty]
           [ring.middleware.reload :refer [wrap-reload]]
           [ring.util.response :refer [resource-response response]]
           [compojure.core :refer [defroutes GET]]
           [compojure.route :as route]
           [hiccup.page :as page]))

(defroutes app
  (GET  "/" [] (resource-response "index.html" {:root "public"}))
  (route/resources "/")
  (route/not-found "Page not found"))

(defn -main
  "Ring jetty webserver"
  [port]
  (jetty/run-jetty app {:port (Integer. port)}))
