(ns quick-sort.core
  (:gen-class))


;; (defn pivot-index
;;   [l]
;;   (let [k (first l)
;;         l (rest l)
;;         t (concat 
;;             (filter #(<= % k) l)
;;             [k]
;;             (filter #(> % k) l))]
;;     (.indexOf t k)))

(defn qsort [[pivot & xs]]
  (when pivot
    (let [smaller #(< % pivot)]
      (lazy-cat (qsort (filter smaller xs))
                [pivot]
                (qsort (remove smaller xs))))))
(defn -main
  [& args]
  (println (qsort '(3 8 6 4 7 5 0 2 1))))
