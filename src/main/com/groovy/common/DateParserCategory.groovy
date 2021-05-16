package main.com.groovy.common

import java.time.format.DateTimeFormatter

class DateParserCategory {

    def static String parseDateTime(dateTime, formatString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString)
        return formatter.format(dateTime)
    }

}
