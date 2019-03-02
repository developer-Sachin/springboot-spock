package tests

import spock.lang.Specification

import javax.validation.constraints.Null

class StackSpec extends Specification {

    def "stack opeation test case"() {
        def stack = new Stack()
        def elem = "push me"
        when:
        stack.push(elem)
        then:
        !stack.isEmpty()
        stack.size() == 1
        stack.peek() == elem
        when:
        stack.pop()
        then:
        noExceptionThrown()
        when:
        stack.pop()
        then:
        thrown(EmptyStackException)
        when:
        stack.pop()
        then:
        EmptyStackException e = thrown()
        e.getCause() == null
    }

    def "HashMap accepts null key"(){
        setup:
        def map = new HashMap()
        when:
        map.put(null , "element")
        then:
        notThrown(NullPointerException)
    }


    def "setup and cleanup example"(){
        setup:
        def file = new File("src/test/resources/testFile.txt")
        file.createNewFile()
        cleanup:
        file.delete()
    }


}
