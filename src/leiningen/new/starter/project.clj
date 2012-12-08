(defproject {{name}} "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :min-lein-version "2.0.0"
            :dependencies [[org.clojure/clojure "1.4.0"]
                           [jayq "0.2.3"]
                           [fetch "0.1.0-alpha2"]
                           [crate "0.2.1"]
                           [noir "1.3.0-beta10"]]
            :plugins [[lein-cljsbuild "0.2.9"]]
            :cljsbuild {:builds
                        {:dev
                         {:source-path "src/cljs"
                          :compiler
                          {:output-to "resources/public/js/bin-debug/main.js"
                           :output-dir "resources/public/js/bin-debug"
                           :optimizations :whitespace
                           :pretty-print true}}
                         :prod
                         {:source-path "src/cljs"
                          :compiler
                          {:output-to "resources/public/js/bin/main.js"
                           :output-dir "resources/public/js/bin"
                           :optimizations :whitespace
                           :pretty-print true}}
                         }
                        }
            :s3 {:bucket "{{name}}"
                 :root "resources/public/"
                 :files ["js/bin/main.js"]}
            :main {{name}}.server)

