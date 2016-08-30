(ns msort.core
  (:gen-class))

(defn merged
  [left right]
  (cond (nil? left) right
        (nil? right) left
        :else (let [[l & *left] left
                    [r & *right] right]
                (if (>= l r)
                  (cons l (merged *left right))
                  (cons r (merged left *right))))))

(defn merge-sort
  [l]
  (if (< (count l) 2)
    l
    (let [mid (/ (count l) 2)
          [left right] (split-at mid l)]
      (merged (merge-sort left) (merge-sort right)))))

(defn -main
  [& args]
  (println (merge-sort (map read-string args))))
