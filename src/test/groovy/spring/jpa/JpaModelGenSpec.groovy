package spring.jpa

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class JpaModelGenSpec extends Specification {
    def 'Generated Person model should include CollectionAttribute'() {
        expect:
            Person_.id.isId()
            Person_.firstName.getJavaType() == String
            Person_.lastName.getJavaType() == String
            Person_.nicknames.isCollection()
            Person_.nicknames.getJavaType() == List
            Person_.nicknames.getBindableJavaType() == String
    }
}