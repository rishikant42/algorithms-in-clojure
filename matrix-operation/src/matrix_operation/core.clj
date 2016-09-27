(ns matrix-operation.core
  (:use clojure.core.matrix)
  ;; (:use clojure.core.matrix.operators)
  ;; (:require [clojure.core.matrix :as M]) 
  (:gen-class))

(defn -main
  [ & args]
  (println (mmul (matrix [[1 2 3] 
                          [4 5 6]]) 
                 (matrix [[1 2] 
                          [3 4]
                          [5 6] ])))
  (println (add (matrix [[1 2]
                         [3 4]])
                (matrix [[5 6]
                         [7 8]])))
  (println (sub (matrix [[1 -2]
                         [3 4]])
                (matrix [[5 6]
                         [-7 8]]))))
