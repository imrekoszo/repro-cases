(ns foo-test
  (:require
   [clojure.template :refer [do-template]]
   [clojure.test :refer :all]))

;; It appears this is related to a comment in the first do-template
;; while having multiple cases for the second do-template???

(deftest wrong-1
  (do-template [expected]
    (testing "case 1"
      (is (not= expected expected)))

    {:bar 1 #_2})

  (do-template [expected]
    (testing "case 2"
      (is (= expected expected)))

    :foo
    :bar))

(deftest wrong-2
  (do-template [expected]
    (testing "case 1"
      (is (not= expected expected)))

    {:bar 1} ;
    )

  (do-template [expected]
    (testing "case 2"
      (is (= expected expected)))

    :foo
    :bar))

(deftest wrong-3
  (do-template [expected]
    (testing "case 1"
      (is (not= expected expected)))

    {:bar 1}
    ;
    )

  (do-template [expected]
    (testing "case 2"
      (is (= expected expected)))

    :foo
    :bar))

(deftest good-1
  (do-template [expected]
    (testing "case 1"
      (is (not= expected expected)))

    {:bar 1})

  (do-template [expected]
    (testing "case 2"
      (is (= expected expected)))

    :foo
    :bar))

(deftest good-2
  (do-template [expected]
    (testing "case 1"
      (is (not= expected expected)))

    {:bar 1 #_2})

  (do-template [expected]
    (testing "case 2"
      (is (= expected expected)))

    :foo))

(deftest good-3
  (do-template [expected]
    (testing "case 1"
      (is (not= expected expected)))

    {:bar 1}
    ;
    )

  (do-template [expected]
    (testing "case 2"
      (is (= expected expected)))

    :foo))

(deftest good-4
  (do-template [expected]
    (testing "case 1"
      (is (not= expected expected)))

    ;
    {:bar 1})

  (do-template [expected]
    (testing "case 2"
      (is (= expected expected)))

    :foo))
