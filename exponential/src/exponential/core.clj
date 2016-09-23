(ns exponential.core
  (:gen-class))

(defn exp1               ;; recursive process
  [b n]
  (if (= n 0)
    1
    (* b (exp1 b (- n 1)))))

(defn exp2-iter 
  [b n result]
  (if (= n 0)
    result
    (exp2-iter b (- n 1) (* b result))))

(defn exp2                ;; itervative process 
  [b n]
  (exp2-iter b n 1))

(defn sqr[x] (* x x))

(defn exp3                ;; recursive process 
  [b n]
  (cond (= n 0) 1
        (even? n) (sqr (exp3 b (/ n 2)))
        :else (* b (exp3 b (- n 1)))))

(defn exp4                ;; recursive process 
  [b n]
  (cond (= n 0) 1
        (even? n) (exp4 (sqr b) (/ n 2))
        :else (* b (exp4 b (- n 1)))))

(defn exp5-iter           ;; iterative-process
  [b n result]
  (cond (= n 0) result
        (even? n) (exp5-iter (sqr b) (/ n 2) result)
        :else (exp5-iter b (- n 1) (* b result))))

(defn exp5
  [b n]
  (exp5-iter b n 1))

(defn -main
  [& args]
  (println (exp1 2 10))
  (println (exp2 2 10))
  (println (exp3 2 10))
  (println (exp4 2 10))
  (println (exp5 2 10)))



;; order of time or order of no. of growth of step

;; exp1  ==> O(n)
;; exp2  ==> O(n)
;; exp3  ==> O(log n)
;; exp4  ==> O(log n)
;; exp5  ==> O(log n)

;; Space required by iterative process is constant
;; space require by recursive process is grow with number of step, It require stack to keep track of operation that perform later.
