package main.com.groovy.configurations

class DynamicConfiguration {

    DynamicConfiguration() {

        def basePath = "resources/properties"
        def propertiesFile = new File(basePath + "/application.properties")
        println "Current working directory : "+ System.getProperty("user.dir")
        println "Properties file found ? "+ propertiesFile.exists()

        def configSlurper = new ConfigSlurper()
        def properties = configSlurper.parse(propertiesFile.toURL())

        println ''
        println "Properties dump() : "+ properties.dump()
        println "group properties : ${properties.group.prop1}"
        println "Without group property : ${properties.withoutGroupProperty}"

    }

}