(ns cljs.playground
  (:require
   [goog.dom :as gdom]
   [reagent.core :as r]))

(enable-console-print!)

(defn hello [name]
  [:h1 "Hello, " name])

(defn app []
  [hello "Lily"])

(defn main []
  (r/render [app] (gdom/getElement "app")))
