(ns simple-rpg.core)

(def max-lvl 18)

(defn calc-attack
  "calculates attack based on level"
  [lvl]
  (* lvl 2))

(defn calc-def
  "calculates defence based on level"
  [lvl]
  (int (* lvl 1.5)))

(defn calc-hp
  "calculates hp based on lvl"
  [lvl]
  (* lvl 20))

(defn create-charater
  "constructs character "
  ([name lvl]
   {:name   name
    :lvl    lvl
    :attack (calc-attack lvl)
    :def    (calc-def lvl)
    :hp     (calc-hp lvl)})
  ([name lvl attack def]
   {:name   name
    :lvl    lvl
    :def    def
    :attack attack
    :hp     (calc-hp lvl)}))

(def player (create-charater "some-username-placeholder" 1))

(def m-minion (create-charater "Mili-Minion" 1 1 0))
(def r-minion (create-charater "Range-Minion" 1 5 0))

(def dragon (create-charater "Dragon" 1))

(defn roll-dice
  [sides]
  (inc (rand-int sides)))

(defn hit
  [attacker defender]
  (- (defender :hp) (- (attacker :attack) (defender :def))))


(defn default-wave
  []
  [m-minion,
   m-minion,
   m-minion,
   r-minion,
   r-minion,
   r-minion])

(println (roll-dice 6))

(println (hit player r-minion))
(println (default-wave))

(println "__\n"  (first (default-wave)))
