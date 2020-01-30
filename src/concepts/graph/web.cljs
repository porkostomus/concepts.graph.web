(ns concepts.graph.web
  (:require [reagent.core :as r]
            [concepts.graph :as graph]
            ["viz.js" :as viz]))

(defn app []
  [:div#app
   [:h1 "concepts.graph.web"]])

(defn render []
  (r/render [app]
            (.getElementById js/document "root")))

(defn ^:dev/after-load start []
  (render)
  (js/console.log "start"))

(defn ^:export init []
  (js/console.log "init")
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
