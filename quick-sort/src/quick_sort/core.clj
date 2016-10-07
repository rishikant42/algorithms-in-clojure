(ns quick-sort.core
  (:gen-class))


(defn insert
  [l]
  (let [k (first l)
        l (rest l)
        t (concat 
            (filter #(<= % k) l)
            [k]
            (filter #(> % k) l))]
    (.indexOf t k)))

;; (defn quicksort
;;   [arg]
;;   (if (empty? arg)
;;     nil
;;     (let [x (insert arg)
;;           y (nth arg x)
;;           arg (rmve y arg)
;;           [left right] (split-at x arg)]
;;       (println y))))
      ;; (concat (quicksort left) (quicksort right)))))

(defn -main
  [& args]
  (println (quicksort '(3 8 6 4 7 5 0 2 1))))
