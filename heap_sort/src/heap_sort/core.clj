(ns heap-sort.core
  (:gen-class))

(defn make-tree 
  [entry left right]
  (list entry left right))

(defn entry
  [tree]
  (first tree))

(defn left-branch
  [tree]
  (first (rest tree)))

(defn right-branch
  [tree]
  (last tree))

(defn max-heap
  [tree]
  (if (nil? tree)
    '()
    (let [en (entry tree)
          lb (left-branch tree)
          rb (right-branch tree)]
      (cond (nil? entry) tree
            (or (empty? lb) (> en (entry rb))) tree
            (or (empty? rb) (> en (entry lb))) tree
            (and (empty? lb) (empty? rb)) tree
            (and (> en (entry lb)) (> en (entry rb))) tree
            (< en (entry lb)) (make-tree (entry lb) (max-heap (make-tree en (left-branch lb) (right-branch lb)))  rb)
            (< en (entry rb)) (make-tree (entry rb) lb (max-heap (make-tree en (left-branch rb) (right-branch rb))))))))

(defn -main
  [& args]
  (let [left1 (make-tree 8 (make-tree 2 () ()) (make-tree 4 () ()))
        right1 (make-tree 7 (make-tree 6 () ()) ())
        left (make-tree 14 left1 right1)
        right (make-tree 10 (make-tree 9 () ()) (make-tree 3 () ()))
        tree (make-tree 1 left right)]
    (println (max-heap tree))))
