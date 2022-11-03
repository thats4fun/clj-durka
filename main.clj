(defn make-data
  ([x] #{x})
  ([x y] #{x y}))

(println (make-data 1 2))

(def x
  (+ 7654 1234))

(println x)

; ( 7 + 3 * 4 + 5 ) / 10
(println (/ (+ 7 (* 3 4) 5) 10))

; simple anon function
(println (#(+ 6 %) 2))

; apply

; How to create a vector of one argument? That's how:
; #1
(println "hehe1" ((fn [x] [x]) 1)) ;; fn [x] [x]
; #2
(println "hehe" (vector 1) )       ;; vector 1
; #3
#(vector %)                        ;; #(vector %)

; let ??? (skipped)

(defn say-something [greeting]
      (fn [who] (println greeting who)))

(def hello (say-something "Hello"))

(hello "World")

; lists
(list :a :b :c)
'(:a :b :c)

; conj on lists
( conj '(1 2 3) 4)

;(= ('(1 2 3 4) (conj '(2 3 4) 1)))

( println (= '(1 2 3 4) (conj '(2 3 4) 1)))
( println (= '(1 2 3 4) (conj '(3 4) 2 1)))

; accessing maps
(println ({:a 1 :b 2} :b))

; vector contruction
(vector 1 2 3)
(vec '(1 2 3))
[:a :b :c]

; list and vectors can be compared =
( println (= [1 2 3 4] (conj [1 2 3] 4)))
( println (= [1 2 3 4] (conj [1 2] 3 4)))

; (clojure.set/union #{:a :b} #{:b :c})
(= #{1 2 3 4} (conj #{1 4 3} 2))

(println "eee" (= 20 ((hash-map :b 20 :c 30) :b)))
(println "bbb" (= 20 (:b {:a 10, :b 20, :c 30})))

(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

(= [20 30 40] (rest [10 20 30 40]))

;(= __ ((fn add-five [x] (+ x 5)) 3))
;(= __ ((fn [x] (+ x 5)) 3))
;(= __ (#(+ % 5) 3))
;(= __ ((partial + 5) 3))


(println (= (#(* % 2) 5) 8))

;;(= (__ "Dave") "Hello, Dave!")
;(= (__ "Jenn") "Hello, Jenn!")
;(= (__ "Rhea") "Hello, Rhea!")
#(+ "Hello, " % "!")