package main.com.groovy.rest

@groovy.lang.Grapes([
        @Grab(group= 'org.codehaus.groovy.modules.http-builder', module= 'http-builder', version= '0.7')
        ,
        @Grab(group= 'org.codehaus.groovy', module= 'groovy-all', version= '3.0.8', type = 'pom')
])

import groovyx.net.http.RESTClient

/**
 * Prerequisite is to have {@project : Static-data-provider} running
 * Link :
 */
def restClient = new RESTClient("http://localhost:8090")
// since get() accepts map, creating and passing map on the fly
def response = restClient.get(path: "/static/weather/data")

println "response.status : ${response.status}"
println "response.data : ${response.data}"

println ''
println "Location -> Region : ${response.data.location.region}"
println "Location -> Lattitude : ${response.data.location.lat}"
println "Location -> Longitude : ${response.data.location.lon}"
println "Current -> Temprature(C) : ${response.data.current.temp_c}"
println "Location -> Temprature(F) : ${response.data.current.temp_f}"
