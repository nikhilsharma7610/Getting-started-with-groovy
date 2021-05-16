package main.com.groovy.common

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

@Grapes(
        @Grab(group = 'joda-time', module='joda-time', version='2.10.10')
)

class JodaDateParser {

    def String parseDate(dateTime) {
        def printableDateTime = new DateTime(dateTime)
        def formatter = DateTimeFormat.forPattern("MM/dd/yyyy - hh:mm aa")
        return printableDateTime.toString(formatter)
    }

}