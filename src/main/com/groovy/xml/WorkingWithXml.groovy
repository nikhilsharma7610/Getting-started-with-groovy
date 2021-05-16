package main.com.groovy.xml

import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlSlurper

class WorkingWithXml {

    private gpx

    WorkingWithXml() {

        /*
            Reading XML
         */
        def basePath = "resources/xml"
        def inputFile = new File(basePath + "/fells_loop.gpx")
        println "Current working directory : "+ System.getProperty("user.dir")
        println "Input XML file found ? "+ inputFile.exists()

        def xmlSlurper = new XmlSlurper()   // lazy loads & suitable for large xml
        gpx = xmlSlurper.parse(inputFile)
        //println gpx

        println ''
        println gpx.name
        println gpx.desc

        println ''
        println gpx.@creator
        println gpx.@foo    // any invalid childNode / attribute will return empty and not cause error

        (gpx.wpt).each {
            print it.name
            print ' , '
        }
        println ''

        /*
            Writing XML
        */
        def xmlOutput = new StreamingMarkupBuilder().bind {

            route {
                mkp.comment(gpx.name)   // extra feature that StreamingMarkupBuilder has
                (gpx.wpt).each { point ->
                    routePoint(time : point.time.toString()) {  // syntax to create node attribute
                        latitude(point.@lat)                    // syntax to create child node, call method with child node name
                        longitude(point.@lon)
                    }
                }
            }

        }.writeTo( new File(basePath + '/falls_loop_output.xml').newWriter() )

    }

}