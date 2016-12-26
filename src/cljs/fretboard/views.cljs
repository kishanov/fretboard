(ns fretboard.views
  (:require [re-frame.core :as re-frame]
            [fretboard.subs :as subs]))



(defn main-panel []
  (let [fretboard (re-frame/subscribe [::subs/fretboard])]
    (fn []
      [:div
       (doall
         (for [[i string] (map-indexed vector @fretboard)]
           ^{:key i}
           [:div {:style {:padding 0 :margin 0}}
            (for [[j fret] (map-indexed vector string)]
              ^{:key j}
              [:div
               {:style {:display     "inline-block"
                        :width       "3em"
                        :height      "2.4em"
                        :border-left "2px solid grey"
                        :text-align  "center"}}

               [:div {:style {:width      "100%"
                              :height     "0px"
                              :border     "0.2em solid black"
                              :margin-top "1em"}}]

               [:div {:style {:margin-top       "-0.75em"
                              :margin-left      ".5em"
                              :width            "1.5em"
                              :border-radius    "50%"
                              :border           "1px solid black"
                              :background-color "yellow"}}
                fret]])]))])))
