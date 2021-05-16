package test.com.groovy.common


import main.com.groovy.common.JodaDateParser

@GrabConfig(systemClassLoader = true)
@Grab(group = 'joda-time', module = 'joda-time', version = '2.10.10')
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Groovy dependency management Grape is not working and is going through common problem of : ClassLoaderNotFound
 * Online solutions suggest using @GrabConfig, but that didn't worked out as well.
 *
 * If any one has any specific solution, do let me know or raise a pull request
 * For now : EXCLUDING the test case
 */
class JodaDateParserTest { // extends GroovyTestCase {

     def void testJodaParseDateTime() {
        def dateParser = new JodaDateParser()
        def testDateTime = "15/05/2021 22:33:00"
        def dateTime = LocalDateTime.parse(testDateTime, DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss"))
        def dateTimeString = dateParser.parseDate(dateTime);
        assert "05/15/2021 - 10:33 pm" == dateTimeString
    }
}
