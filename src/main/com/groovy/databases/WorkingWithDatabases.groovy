package main.com.groovy.databases

@groovy.lang.GrabConfig(systemClassLoader = true)
@Grapes(
        @Grab(group='com.h2database', module='h2', version='1.1.101')
)

import groovy.sql.Sql

import java.sql.Timestamp

def tableName = "person"
String deleteTable = "DROP TABLE IF EXISTS ${tableName};"
String createTable = "CREATE TABLE IF NOT EXISTS ${tableName} (\n" +
        "                id int PRIMARY KEY AUTO_INCREMENT,\n" +
        "                name varchar NOT NULL UNIQUE,\n" +
        "                age int,\n" +
        "                salary double,\n" +
        "                updatedAt timestamp DEFAULT CURRENT_TIMESTAMP\n" +
        "            );"
String selectAll = "SELECT * FROM ${tableName}"
String updateTable = "UPDATE ${tableName} SET age = 50 WHERE salary >= 100.0"

println "Table name : ${tableName}"
println "Delete table : ${deleteTable}"
println "Create table : ${createTable}"
println "selectAll : ${selectAll}"
println "Update table : ${updateTable}"
println "-----------"

// create sql instance
def sqlInstance = Sql.newInstance("jdbc:h2:${tableName}","root","root","org.h2.Driver")

// Drop table if exists
sqlInstance.execute(deleteTable)

// create table
sqlInstance.execute(createTable)

def tablePerson = sqlInstance.dataSet(tableName)
tablePerson.add(
        "id" : "1",
        "name" : "ABC",
        "age" : 30,
        "salary" : 100.0,
        "updatedAt" : new Timestamp(System.currentTimeMillis())
        )

tablePerson.eachRow(selectAll) {
        println "ID : ${it.id}, Name : ${it.name}, Age : ${it.age}, Salary : ${it.salary}, Updated At : ${it.updatedAt}"
}

tablePerson.executeUpdate(updateTable)

println "After updating"
tablePerson.eachRow(selectAll) {
        println "ID : ${it.id}, Name : ${it.name}, Age : ${it.age}, Salary : ${it.salary}, Updated At : ${it.updatedAt}"
}
