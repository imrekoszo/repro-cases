(ns foo-test
  (:require
   [clojure.template :refer [do-template]]
   [clojure.test :refer :all]))

(deftest foo-test
  (do-template
    [param expected]
    (testing (str "case 1: " param)
      (is (= expected {})))

    false
    {:bar 1 #_2})

  (do-template
    [param]
    (testing (str "case 2: " param)
      (is (= 1 1)))

    :foo
    :bar))
