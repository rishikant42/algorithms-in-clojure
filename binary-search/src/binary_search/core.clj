(ns binary-search.core
  (:gen-class))

(defn bsearch1
  [k list]
  (if (= (count list) 0)
    (println "Element" k "is not present in list")
    (let [mid (/ (count list) 2)
          current (nth list mid)
          split-list (split-at mid list)
          left (first split-list)
          right (last split-list)]
      (cond (= k current) (println "Element" k "is present in list")
            (< k current) (bsearch1 k left)
            :else (bsearch1 k right)))))

(defn bsearch2
  [k list]
  (loop [new-list list]
    (let [size (count new-list)
          mid (/ size 2)
          current (nth new-list mid)
          split-list (split-at mid new-list)
          left (first split-list)
          right (last split-list)]
      (cond (= k current) (println "Element" k "is present in list")
            (< k current) (recur left)
            :else (recur right)))))

(defn -main
  [& args]
  (bsearch1 4 '(1 2 3 4 5 6 7 8 9 10))
  (bsearch2 4 '(1 2 3 4 5 6 7 8 9 10)))


;; (defn -main
;;   [& args]
;;   (let [a (map read-string args)
;;         f (first a)
;;         r (rest a)]
;;     (bsearch1 f r)
;;     (bsearch2 f r)))
