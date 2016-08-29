(ns merge-sort.core
  (:gen-class))

(defn merged 
  [left right]
  (cond (nil? left) right
        (nil? right) left
        :else (let [[l & *left] left
                    [r & *right] right]
                (if (<= l r) (cons l (merged *left right))
                  (cons r (merged left *right))))))

(defn merge-sort 
  [list]
  (if (< (count list) 2)
    list
    (let [mid (/ (count list) 2)
          [left right] (split-at mid list)]
      (merged (merge-sort left) (merge-sort right)))))

(defn -main
  [& args]
  (println (merge-sort (map read-string args))))
