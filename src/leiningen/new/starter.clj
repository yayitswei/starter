(ns leiningen.new.starter
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "starter"))

(defn starter
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             ["project.clj" (render "project.clj" data)];check
             [".gitignore" (render "gitignore" data)];check
             ["README.md" (render "README.md" data)];check
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)];cehck
             ["src/{{sanitized}}/views/routes.clj" (render "routes.clj" data)];check
             ["src/{{sanitized}}/views/common.clj" (render "common.clj" data)];check
             ["src/cljs/main.cljs" (render "main.cljs" data)]
             "resources/public/js"
             "resources/public/img"
             "src/{{sanitized}}/models"
             "test/{{sanitized}}")))
