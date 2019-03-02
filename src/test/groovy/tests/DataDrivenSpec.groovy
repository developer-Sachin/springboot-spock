package tests

import spock.lang.Specification

class DataDrivenSpec extends Specification {

    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 6]
        b << [1, 4]
        c << [3, 6]
    }
}
