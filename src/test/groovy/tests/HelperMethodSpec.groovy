package tests
import spock.lang.Specification

class HelperMethodSpec extends Specification {

    def "HashMap data check wtih helper method"() {

        def map = new HashMap()
        when:
        map.put(1, "abc");
        map.put(2, "xyz")
        map.put(3,"John")
        map.put(4 , "Sunny")
        then:
        helperMethodForAssertingKeyValue(map)
        helperMethodForAssertingMapSize(map)
    }

    def helperMethodForAssertingKeyValue(map) {
         map.get(1) == "abc"
    }

    void helperMethodForAssertingMapSize(map){
        assert map != null
        assert map.size() == 4
    }

}
