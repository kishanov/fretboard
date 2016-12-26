(ns fretboard.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]
            [cljs.pprint :as pp]))



(re-frame/reg-sub
  ::alphabet
  (fn [db]
    (:alphabet db)))


(re-frame/reg-sub
  ::frets-count
  (fn [db]
    (:frets-count db)))


(re-frame/reg-sub
  ::fretboard
  :<- [::alphabet]
  :<- [::frets-count]
  (fn [[alphabet frets-count]]
    (let [string-notes #(->> alphabet
                             (cycle)
                             (drop-while (partial not= %))
                             (take frets-count)
                             (vec))]

      (mapv string-notes "EBGDAE"))))

