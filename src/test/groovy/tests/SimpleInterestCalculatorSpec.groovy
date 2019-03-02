package tests

import com.example.groovyspock.domain.SimpleInterestCalculation
import spock.lang.FailsWith
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class SimpleInterestCalculatorSpec extends Specification {

    def "interest rate calcs with simple calculator"() {
        given:
        @Subject
        def calc = new SimpleInterestCalculation()
        calc.rate = 0.05
        expect:
        1000.0 == calc.calculate(10000, 2)
    }

    def "showing off interest in calc"() {
        given:
        def calc = new SimpleInterestCalculation(rate: 0.05)
        expect:
        interest == calc.calculate(amount, year)
        where:
        interest = 1000.0
        amount = 10000.0
        year = 2
    }

    @Unroll("int: #interest | amount:#amount | year: #year")
    def "showing off vars list in calc"() {
        def calc = new SimpleInterestCalculation(rate: 0.05)
        expect:
        interest == calc.calculate(amount, year)
        where:
        interest << [1000.0, 25.0]
        amount << [10000, 100]
        year << [2, 5]
    }

    def "show of data table"() {
        given:
        def calc = new SimpleInterestCalculation(rate: 0.05)
        expect:
        interest == calc.calculate(amout, year)
        where:
        interest | amout   | year
        1000.0   | 10000   | 2
        25.0     | value() | 5
    }

    def value() {
        10 * 10
    }

    @FailsWith(IllegalArgumentException)
    def "failure example on call"() {
        expect:
        def calc = new SimpleInterestCalculation(rate: 0.05)
        1000.0 == calc.calculate(10000, -1)
    }

    @Ignore
    def "hamcrest values"(){
        def calc = new SimpleInterestCalculation()
        expect:
        that calc.subtract(2.0,1.1), closeTo(0.9,0.01)
    }

}
