(ns {{namespace}}.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.middleware.defaults :as defaults]
            [duct.support :as support]))

(defn build-routes [config]
  (routes
   (GET "/" [] (support/html-resource "public/welcome.html"))
   (route/not-found (support/html-resource "public/404.html"))))

(defn new-handler [config]
  (-> (build-routes config)
      (defaults/wrap-defaults defaults/site-defaults)))
