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

(defn qsort1 [[pivot & xs]]
  (if (not (nil? pivot))
    (let [smaller #(< % pivot)]
      (concat (qsort1 (filter smaller xs))
              [pivot]
              (qsort1 (remove smaller xs))))))

(defn qsort2 [[pivot & xs]]
  (when pivot  
    (let [smaller #(< % pivot)]
      (concat (qsort2 (filter smaller xs))
              [pivot]
              (qsort2 (remove smaller xs))))))

(defn qsort3 [[pivot & xs]]
  (when pivot  
    (let [smaller #(< % pivot)
          greater #(> % pivot)]
      (concat (qsort3 (filter smaller xs))
              [pivot]
              (qsort3 (filter greater xs))))))

(defn -main
  [& args]
  (println (qsort1 '(3 8 6 4 7 5 0 2 1)))
  (println (qsort2 '(3 8 6 4 7 5 0 2 1)))
  (println (qsort3 '(3 8 6 4 7 5 0 2 1))))
