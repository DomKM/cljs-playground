(merge-env!
 :source-paths #{"source"}
 :resource-paths #{"resource"}
 :dependencies '[[adzerk/boot-cljs "0.0-2814-3"]
                 [adzerk/boot-reload "0.2.4"]
                 [org.clojure/clojure "1.6.0"]
                 [pandeiro/boot-http "0.6.2"]
                 [reagent "0.5.0-alpha3"]])

(require
 '[adzerk.boot-cljs :refer [cljs]]
 '[adzerk.boot-reload :refer [reload]]
 '[pandeiro.boot-http :refer [serve]])

(deftask dev
  "Starts the dev process."
  [nil silent bool "Silence notifications."]
  (comp
   (serve)
   (watch)
   (if silent identity (speak))
   (reload :on-jsload 'cljs.playground/main)
   (cljs :optimizations :none
         :source-map true)))
