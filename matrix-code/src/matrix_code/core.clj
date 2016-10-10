(ns matrix-code.core
  (:gen-class))

(defn transpose
  [s]
  (apply map vector s))

(defn nested-for
  [f x y]
  (map (fn [a]
         (map (fn [b]
                (f a b)) y))
       x))

(defn matrix-mult
  [a b]
  (nested-for (fn [x y] (reduce + (map * x y)))
              a
              (transpose b)))

(defn -main
  [& args]
  (let [m1 [[1 2] [3 4]]
        m2 [[5 6] [7 8]]
        ]
    (println (matrix-mult m1 m2))))
