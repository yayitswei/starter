(ns cljs.main
  (:require [fetch.remotes :as remotes])
  (:require-macros [fetch.macros :as fm])
  (:use [jayq.core :only [$]]
        [jayq.util :only [log clj->js]])
  (:use-macros [crate.def-macros :only [defpartial defhtml]]))

(def $body ($ :body))

(log "hello world!")
