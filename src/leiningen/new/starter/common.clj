(ns {{name}}.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "{{name}}"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))



(def prod (System/getenv "LEIN_NO_DEV"))

(def main-js-path (if prod
                    "/js/bin/main.js"
                    "/js/bin-debug/main.js"))

(def asset-host (when prod "http://{{name}}.s3.amazonaws.com"))

(defpartial layout [& content]
            (html5
              [:head
               [:title "{{name}}"]
               (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/css/bootstrap-combined.min.css"
                            "http://fonts.googleapis.com/css?family=Abel")
               [:link {:href "/less/styles.less",
                       :type "text/css",
                       :rel "stylesheet/less"}]]
              [:body
               [:div#wrapper
                content]
               (include-js
                 "http://lesscss.googlecode.com/files/less-1.0.18.min.js"
                 "https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
                 "//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"
                 (str asset-host main-js-path))]))

