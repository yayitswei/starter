(ns leiningen.new.starter
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "starter"))

(defn starter
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             ["src/{{sanitized}}/views/routes.clj" (render "routes.clj" data)]
             ["src/{{sanitized}}/views/common.clj" (render "common.clj" data)]
             ["src/cljs/main.cljs" (render "main.cljs" data)]
             ["resources/public/less" (render "styles.less" data)]
             "resources/public/js"
             "resources/public/img"
             "src/{{sanitized}}/models"
             "test/{{sanitized}}")))
