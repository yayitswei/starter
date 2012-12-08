(ns {{name}}.views.routes
  (:require [{{name}}.views.common :as common])
  (:use [noir.core :only [defpage]]))

(defpage "/" []
         (common/layout
           [:div.container
            [:h1 "{{name}}"]
            [:p "Something goes here"]]))
