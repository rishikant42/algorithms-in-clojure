(ns isort.core
  (:gen-class))

(defn insert
  [l k]
  (concat 
    (filter #(>= % k) l)
    [k]
    (filter #(< % k) l)))

(defn isort
  [arg]
  (loop [sorted-list []
         unsorted-list arg]
    (if (empty? unsorted-list)
      sorted-list
      (recur (insert sorted-list (first unsorted-list)) (rest unsorted-list)))))

(defn -main
  [& args]
  (println (isort (map read-string args))))
