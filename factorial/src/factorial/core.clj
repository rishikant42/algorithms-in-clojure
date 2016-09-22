(ns factorial.core
  (:gen-class))

(defn fact1
  [n]
  (if (= n 1)
    1
    (* n (fact1 (dec n)))))

(defn fact-iter
  [product counter max-count]
  (if (> counter max-count)
    product
    (fact-iter (* product counter) (inc counter) max-count)))

(defn fact2
  [n]
  (fact-iter 1 1 n))

(defn help
  []
  (println 
"lein run rfact <arg>
lein run ifact <arg>"))

(defn -main
  [& args]
  (let [[command arg] args]
    (case command
      "rfact" (println (fact1 (read-string arg)))
      "ifact" (println (fact2 (read-string arg)))
      (help))))
