import main.com.groovy.common.DateParser
import main.com.groovy.common.DateParserCategory

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

def date = LocalDateTime.now()
println "Today's date : "+ date

//def dateParser = new JodaDateParser()
//def formattedDate = dateParser.parseDate(date)
def dateParser = new DateParser()
def formattedDate = dateParser.parseDateTime(date)
println "Formatted date : "+ formattedDate

// enhanced function
println "date.dump() : "+ date.dump()
// if inspect() is not overridden then by default works as toString
println "date.inspect() : "+ date.inspect()

// handling nulls
// See DateParserTest::testParseDateWithNullEvaluatesToFalse
println "null == false : "+ (null == false)
println "!null == false : "+ (!null == false)
println "!!null == false : "+ (!!null == false)

// groovy context concept
date.with {
    println "Date in ISO from within 'with' context of date : "+ format(DateTimeFormatter.ISO_DATE_TIME)
}

// no return type needed
def dateTimeStringWOReturn = dateParser.parseDateTimeWithoutReturn(date)
println "Date time from parser w/o return statement : "+ dateTimeStringWOReturn

// category : to limit scope of method access
use(DateParserCategory) {
    def dateTimeString = date.parseDateTime("dd/MM/yyyy | HH:mm a")
    println "dateTimeString from Category feature : "+ dateTimeString
}
