package tests

import com.example.groovyspock.domain.Account
import spock.lang.Specification

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

class WithExampleSpec extends Specification{

    @slow
    def "working with with"(){
      def account = new Account(accountNo: 1234 , balance: 124343)
        expect:
        with(account){
            accountNo == 1234
            balance == 124343
        }
    }


}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface slow{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface fast{}
