package main.com.groovy.common

import java.time.format.DateTimeFormatter

class DateParser {

    def String parseDateTime(dateTime) {
        if (dateTime == null)
            throw new IllegalArgumentException()

        def formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm a")
        return formatter.format(dateTime)
    }

    def String parseDateTimeWithNullEvaluates(dateTime) {
        if (!dateTime)
            throw new ArgumentEvaluatesToNullException()

        return parseDateTime(dateTime)
    }

    def String parseDateTimeWithoutReturn(dateTime) {
        parseDateTime(dateTime)
    }

}
