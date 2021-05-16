package test.com.groovy.common

import groovy.test.GroovyTestCase
import main.com.groovy.common.ArgumentEvaluatesToNullException
import main.com.groovy.common.DateParser

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateParserTest extends GroovyTestCase {

    def dateParser

    def void setUp() {
        dateParser = new DateParser()
    }

    def void tearDown() {
        dateParser = null
    }

    def void testParseDateTime() {
        def testDateTime = "15/05/2021 22:33:00"
        def dateTime = LocalDateTime.parse(testDateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        def dateTimeString = dateParser.parseDateTime(dateTime);
        assert "05/15/2021 - 10:33 pm" == dateTimeString
    }

    def void testParseDateWithNull() {
        shouldFail(IllegalArgumentException) {
            def dateTimeString = dateParser.parseDateTime(null)
        }
    }

    def void testParseDateWithNullEvaluatesToFalse() {
        shouldFail(ArgumentEvaluatesToNullException) {
            def dateTimeString = dateParser.parseDateTimeWithNullEvaluates(null)
        }
    }

    def void testParseDateTimeWithoutReturn() {
        def testDateTime = "15/05/2021 22:33:00"
        def dateTime = LocalDateTime.parse(testDateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        def dateTimeString = dateParser.parseDateTimeWithoutReturn(dateTime);
        assert "05/15/2021 - 10:33 pm" == dateTimeString
    }

}
