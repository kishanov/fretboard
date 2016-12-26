(ns fretboard.db)

(def default-db
  {:frets-count 18
   :alphabet    (->> "ABCDEFG"
                     (map #(when-not (contains? #{"B" "E"} %)
                             (str % "#")))
                     (interleave "ABCDEFG")
                     (filter (complement nil?)))})

