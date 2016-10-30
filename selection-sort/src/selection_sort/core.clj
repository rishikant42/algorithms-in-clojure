(ns selection-sort.core
  (:gen-class))

(defn remov
  [x args]
  (filter (fn [y] (not= x y)) args))

(defn isort
  [arg]
  (loop [sorted-list []
         unsorted-list arg]
    (if (empty? unsorted-list)
      sorted-list
      (let [minimum (apply min unsorted-list)]
        (recur (cons minimum sorted-list)
               (remov minimum unsorted-list))))))

(defn -main
  [& args]
  (println (isort (map read-string args))))


;; clojure primitive procedure, remove

;; => (remove (fn[x] (= x 3)) '(1 2 3 4 5))
;; (1 2 4 5)

;; above self defined procedure, remov

;; => (remov 3 '(1 2 3 4 5))
;; (1 2 4 5)
