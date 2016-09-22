(ns binary-search.core
  (:gen-class))

(defn bsearch
  [k list]
  (loop [new-list list]
    (let [size (count new-list)
          mid (/ size 2)
          current (nth new-list mid)
          split-list (split-at mid new-list)
          left-end (first split-list)
          right-end (last split-list)]
      (if (= current k)
        (println "find")
        (if (> current k)
          (recur left-end)
          (recur right-end))))))

(defn -main
  [& args]
  (println (bsearch 1 '(1 2 3 4 5 6 7 8 9 10))))
