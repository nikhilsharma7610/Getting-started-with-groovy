System.out.println("Printing string");
println "Printing without class path"

// Collections
def arr = ['Name1','Name2','Name3']
for (int i=0; i<arr.size(); i++) {
    def greeting = "Hello, "
    println "$greeting" + "${arr[i]}"
}
println ''
for (arrElem in arr) {
    def greeting = "Hello, "
    println "$greeting" + "$arrElem"
}
println ''
// Ranges
def numbers = 1..10
for (num in numbers) {
    println num
}
println ''
def chars = 'a'..'n'
for (_char in chars) {
    println _char
}
println ''
enum DAYS {
    SUN, MON, TUE, WED, THU, FRI, SAT
}
def weekdays = DAYS.MON..DAYS.FRI
for (weekday in weekdays) {
    println weekday
}
println 'weekdays.from '+ weekdays.from
println 'weekdays.to '+ weekdays.to

println ''
// Functions
def isEven(num) {
    num % 2 == 0
}
for (num in numbers) {
    println "$num is even ? "+ isEven(num)
}

// Closures
def myClosure = {
    println 'My closure'
}
(1..3).each(myClosure)
(1..3).each({ println 'My closure as argument' })
(1..3).each({ i -> println "My Closure with $i"})
(1..10).findAll({ return it%2==0})
        .each({ i -> println "My closure even $i"})
(1..10).findAll({ it%2==0}).each({ println "My closure even trimmed $it"})
println ''

// Dynamic capabilities
def cat = "meow"
def one = 1

println cat
println cat.getClass()
println cat.toUpperCase()

println one
println one.getClass()
//println one.toUpperCase() // will throw error

one = "one" // duck typing
println one
println one.getClass()
println one.toUpperCase()
