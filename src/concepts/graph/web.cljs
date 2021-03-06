(ns concepts.graph.web
  (:require [reagent.core :as r]
            [concepts.graph :as graph]))

(defn rect [w h x y]
  [:rect
   {:width        w
    :height        h
    :fill         "none"
    :x            x
    :y            y
    :stroke       "#000000"
    :stroke-width 1}])

(defn text [s x y]
  [:text {:x           x
          :y           y
          :text-anchor "middle"
          :font-size   11}
   s])

(defn node [s x y]
  [:g 
   [rect (+ 3 (* (count s) 6)) 11 (+ x 18 (* -2.8 (count s))) y]
   [text s (+ 19.5 x (* -0.01 (count s))) (+ 9 y)]])

(defn edge [x1 y1 x2 y2]
  [:g 
   [:line 
    {:x1     x1 :y1     y1
     :x2     x2 :y2     y2
     :stroke "black"}]
   [:polygon
    {:points 
     (apply str (interpose " "
                           [x2 (+ y2 2)
                            (- x2 2) (- y2 4)
                            (+ x2 2) (- y2 4)]))}]])

(defn app []
  [:div#app
   [:h1 "concepts.graph.web"]
   [:svg {:width    "100%"
          :view-box (str "0 0 100 100")}
    [node "Root" 30 5]
    [edge 50 16 50 40]]])

(defn render []
  (r/render [app]
            (.getElementById js/document "root")))

(defn ^:dev/after-load start []
  (render)
  (js/console.log "start"))

(defn ^:export init []
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
