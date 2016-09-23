(ns binary-search.core
  (:gen-class))

(defn bsearch
  [k list]
  (if (= (count list) 0)
    (println "Element" k "is not present in list")
    (let [mid (/ (count list) 2)
          current (nth list mid)
          split-list (split-at mid list)
          left (first split-list)
          right (last split-list)]
      (cond (= k current) (println "Element" k "is present in list")
            (< k current) (bsearch k left)
            :else (bsearch k right)))))

(defn -main
  [& args]
  (bsearch 3 '(1 2 3 4 5 6 7 8 9 10)))


;; (defn -main
;;   [& args]
;;   (let [a (map read-string args)
;;         f (first a)
;;         r (rest a)]
;;     (bsearch f r)))
