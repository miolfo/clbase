(defproject clbase "0.1.0-SNAPSHOT"
  :description "Clojure and clojurescript project base"
  :license {
    :name "The MIT License"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [ring "1.6.3"]
    [compojure "1.3.4"]
    [hiccup "1.0.5"]
    [org.clojure/clojurescript "1.9.946"]
    [org.clojure/core.async "0.3.465"]]
  :plugins [
    [lein-cljsbuild "1.1.7"]
    [lein-ring "0.12.2"]
    [lein-pdo "0.1.1"]]
  :aliases {"up" ["pdo" "cljsbuild" "auto" "dev," "ring" "server-headless"]}
  :ring {:handler clbase.handler/app}
  :main clbase.handler
  :source-paths ["src/clj"]
  :cljsbuild {
    :builds [{
      :id "dev"
      :source-paths ["src/cljs"]
      :compiler {
        :output-to "resources/public/js/app.js"
        :output-dir "resources/public/js/out"
        :optimizations :none
        :source-map true}}]})
