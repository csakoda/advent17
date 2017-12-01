(ns advent17.day1)

(defn solve*
  [input]
  (let [result (->> input
                    (partition-all 2 1)
                    (filter (fn [[l r]] (and r (= l r))))
                    (map (fn [[l _]] (read-string (str l)))))]
    [result (reduce + result)]))

(defn solve
  [input & {:keys [vals?]}]
  (let [ext (str input (first input))]
   (solve* ext)))

(defn solve-extra
  [input]
  (let [size (count input)
        half (/ size 2)
        result
        (->> input
             (map-indexed (fn [index c]
                            (let [other-index (mod (+ index half) size)
                                  other-c (get input other-index)]
                              [c other-c])))
             (filter (fn [[c other-c]] (= c other-c)))
             (map (fn [[c _]] (read-string (str c)))))]
    [result (reduce + result)]))
