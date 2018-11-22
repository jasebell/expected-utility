(ns nm.utility.core)

(defn probability->decimal [p]
  (if (> p 1)
    (double (/ p 100))
    p))

(defn expected-utility [expected-gain expected-loss probability]
  (let [gain-score (* expected-gain (probability->decimal probability))
        loss-score (* expected-loss (- 1 (probability->decimal probability)))
        utility-score (- gain-score loss-score)]
    {:gain-utility gain-score
     :loss-utility loss-score
     :gain-probability (probability->decimal probability)
     :chance-of-loss (- 1 (probability->decimal probability))
     :expected-utility utility-score
     :execute-descion (if (> utility-score 0)
                        true
                        false)}))
