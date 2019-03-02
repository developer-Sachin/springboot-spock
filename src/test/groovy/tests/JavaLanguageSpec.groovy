package tests

import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification

class JavaLanguageSpec extends Specification {

    @IgnoreIf({ !jvm.java8 })
    def "java 8 feature"() {
        def friends = ["Sam", "Peter", "Alex", "Roxy"]
        expect:
        friends.stream().findFirst() != null
    }

    @Requires({ jvm.java8})
    def "java 8 feature java 8 reuiqred"(){
        def friends = ["Sam", "Peter", "Alex", "Roxy"]
        expect:
        friends.stream().findFirst() != null
    }
}
