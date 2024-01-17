// Databricks notebook source
// MAGIC %python
// MAGIC print('Hello World')

// COMMAND ----------

// MAGIC %md
// MAGIC SCALA BASICS

// COMMAND ----------

// MAGIC %md
// MAGIC typecasting isn't needed in scala , + in scala refers to concatenation

// COMMAND ----------


var value  =  5

// COMMAND ----------

println("Hello World")
println("hey"+value)


// COMMAND ----------

var num = List(1,2,3,45,6)

// COMMAND ----------

var str = List("om","krishna","a","b")

// COMMAND ----------

var k = List(1,2,"om","Krishna")

// COMMAND ----------

num.head

// COMMAND ----------

// where we dont give any parameter , we shouldn't use paranthesis , as it works like property
num.tail

// COMMAND ----------

num.sum

// COMMAND ----------

// num.take throwns first n values
num.take(2)

// COMMAND ----------

var temp = List(1,1,1,2,3,3,2,4,5,6,7,8,7,8,5)
//variable_name.distinct returns the distinct values from the list
temp.distinct

// COMMAND ----------

temp(0)

// COMMAND ----------

// variable_name(index) used for getting the element at that index
temp(4)

// COMMAND ----------

temp(12)

// COMMAND ----------

temp(15)
// index outofboundexception will be thrown , which shows that java runs in background of scala.

// COMMAND ----------

num(1) = 10
//as lists are immutable (cant update) in java , so here too we get the error
// lists can be concanted


// COMMAND ----------

temp.size
// variable_name.size/length both gives length of our list

// COMMAND ----------

temp.length

// COMMAND ----------

println("Min Value: ",temp.min) //returns the min value from the list
println("Max Value: ",temp.max) //returns max value from list

// COMMAND ----------

temp.isEmpty

// COMMAND ----------

// As java is faster than python , scala's statistical analysis is faster than python.

var empty = List()
empty.isEmpty

// COMMAND ----------

var num = Array(1,2,3,4,5,6)
//we can create two tyoes of array num , string/characters

// COMMAND ----------

var str = Array("om","Krishna","dev")

// COMMAND ----------

//Array are mutable 
num(1)

// COMMAND ----------

num(1) = 55

// COMMAND ----------

num

// COMMAND ----------

str(2)

// COMMAND ----------

str(2) = "Dev"

// COMMAND ----------

str

// COMMAND ----------

str.tail

// COMMAND ----------

num.tail
// List functions are applicable on array to

// COMMAND ----------

// Array Buffer  : 

// Mutable Collection: ArrayBuffer is a mutable collection in Scala, meaning you can modify its elements after creation.
// Resizable: It allows dynamic resizing, making it convenient for scenarios where the size of the collection needs to change.
// Efficient Operations: ArrayBuffer provides efficient append and remove operations compared to regular arrays, which require resizing or creating new arrays.
// Indexed Access: Elements in an ArrayBuffer are accessed by index, similar to arrays.

// COMMAND ----------

import scala.collection.mutable.ArrayBuffer

// COMMAND ----------

var cars = new ArrayBuffer[String]

// COMMAND ----------

cars += "Jaguar"

// COMMAND ----------

cars += "BMW"

// COMMAND ----------

cars

// COMMAND ----------

cars += "AUDI"

// COMMAND ----------

// .trimend(n) lets u trim n values from end
cars.trimEnd(1)

// COMMAND ----------

cars

// COMMAND ----------

cars.insert(2,"range rover")

// COMMAND ----------

cars

// COMMAND ----------

cars.insert(0,"TATA")

// COMMAND ----------

cars

// COMMAND ----------

cars.isEmpty

// COMMAND ----------

cars.size

// COMMAND ----------

// Unique Scala functionalities

//Transform & Map
var num = List(1,2,3,4)

// COMMAND ----------

val a = num.map( x => x+3 )

// COMMAND ----------

val b = a.map( x => -x)

// COMMAND ----------

val c = b.map( x => x*x )

// COMMAND ----------

val fruits = List("Orange","banana","Apple","kiwi","grapes")

// COMMAND ----------

var fruits_size = fruits.map(x => (x,x.size))

// COMMAND ----------

val fruit_char = fruits.map( x => x.toCharArray )

// COMMAND ----------

val fruit_larger = fruits.filter( x => ( x.length>5 ))


// COMMAND ----------

var fruit_smallest = fruits.filter( x => (x.size <= 4))

// COMMAND ----------

//practice
// 1) multiply by 10
// 2) filter more than 75
// 3) filter and save between 60 & 75 ,convert back to 1 to 10
var ratings  = List(2.4,5.6,8.9,7.3)

// COMMAND ----------

var rat_10 = ratings.map( x=> x*10)


// COMMAND ----------

var rat_high = rat_10.filter( x => x>75)

// COMMAND ----------

var between_rat = rat_10.filter( x => (x>60 && x<75))

// COMMAND ----------

var normal_rating = between_rat.map( x => x/10)

// COMMAND ----------

// functions

// COMMAND ----------

//here 100,200 are default value
// Double = is must before {} , as it specifies what we will getin return
// not writing = / double will throw error

def add(a:Double=100,b:Double=200):Double =
{
  var sum: Double = 0
  sum = a+b
  return sum
}

// COMMAND ----------

add(11,12)

// COMMAND ----------

//conditional

def cond(a:Double=2,b:Double=3):Boolean = {
  a > b
}

// COMMAND ----------

cond(2,3)

// COMMAND ----------

//if else 
def CheckNumber(num: Int): String = {
  if(num<0) { "Negative Number "}
  else if (num == 0) {" Zero "}
  else { " Positive Number "}
}



// COMMAND ----------

var answer = CheckNumber(-5)


// COMMAND ----------

var answer = CheckNumber(7)


// COMMAND ----------

var answer = CheckNumber(0)


// COMMAND ----------

def multiplyMatrices(matrixA: Array[Array[Int]], matrixB: Array[Array[Int]]): Array[Array[Int]] = {
  
  require(matrixA.nonEmpty && matrixA(0).nonEmpty && matrixB.nonEmpty && matrixB(0).nonEmpty,
    "Input matrices must not be empty")

  val rowsA = matrixA.length
  val colsA = matrixA(0).length
  val colsB = matrixB(0).length

  require(matrixB.length == colsA, "Number of columns in matrixA must be equal to the number of rows in matrixB")

  val result = Array.ofDim[Int](rowsA, colsB)

  for (i <- 0 until rowsA) {
    for (j <- 0 until colsB) {
      var sum = 0
      for (k <- 0 until colsA) {
        sum += matrixA(i)(k) * matrixB(k)(j)
      }
      result(i)(j) = sum
    }
  }

  result
}

// Example usage:
val matrixA = Array(Array(1, 2, 3), Array(4, 5, 6))
val matrixB = Array(Array(7, 8, 0), Array(11, 12, 9),Array(1,2,3))

val resultMatrix = multiplyMatrices(matrixA, matrixB)

// Display the result matrix
println("RESULT")
resultMatrix.foreach(row => println(row.mkString("\t")))
println("\n\n")

