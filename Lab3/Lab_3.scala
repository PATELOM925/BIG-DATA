// Databricks notebook source
//converting List to RDD
var a = sc.parallelize(List("A","B","C","D"))

// COMMAND ----------

// RDD Transformations are spark operations when executed on RDD, it result in a single or multiple new without updating an existing one hence this creates an RDD lineage
// Resilient Distributed Dataset- kind of data structure - it is scattered data struture in a cluster
// it helps in memory efficiency as it is scattered
// easy to process parallel computing as it is very lazy
// Driver program can be accessed. by parallezing existing connection

// COMMAND ----------

val b = a.map(x => (x,1))
b.collect

// COMMAND ----------

val c = a.map(x => (x.length))
c.collect

// COMMAND ----------

val a = sc.parallelize(List(1,2,3,4,5)).map(x => (x,x+1,x+2))
a.collect

// COMMAND ----------

val a = sc.parallelize(List(1,2,3,4,5)).flatMap(x => List(x,x+1,x+2))
a.collect

// COMMAND ----------

val rrda = sc.parallelize(List("aaaa","bbbb","ccc"))
rrda.filter(_.equals("aaaa")).collect

// COMMAND ----------

var city = sc.parallelize(List(("Mumbai",4000),("Delhi",2000),("Chennai",10000),("Kolkatta",7000),("Ahmedabad",3000)))

// COMMAND ----------

city.filter(_._1.contains("ai")).collect

// COMMAND ----------

val fc = city.filter(city => city._2 > 1000 && city._2 < 7000)
fc.collect

// COMMAND ----------

val ab = city.filter(city => city._1.contains("ta") || city._1.contains("hi"))
ab.collect


// COMMAND ----------

val bc = city.filter(city => city._1.contains("i") && city._2<4000)
bc.collect

// COMMAND ----------

city.filter(_._2>3000).filter(_._2<6000).collect

// COMMAND ----------

city.filter(x => x._2>3000 && x._2<6000).collect

// COMMAND ----------

// Generating Arraty of many values in a single call
val x = sc.parallelize( 1 to 1000)
x.collect


// COMMAND ----------

//This line is sampling around 20% of the elements from the RDD x all of them will be unique(without replacement (false)).
var x20 = x.sample(false,0.2)
x20.collect

// COMMAND ----------

x20.count()

// COMMAND ----------


//This line is sampling around 20% of the elements from the RDD x where some of them may be repeated(with replacement (true)).
var xtrue = x.sample(true,0.2)
xtrue.collect

// COMMAND ----------

xtrue.count()

// COMMAND ----------

val z = sc.parallelize( 8 to 15)
z.collect

// COMMAND ----------

val y = sc.parallelize(1 to 5)
y.collect

// COMMAND ----------

var zy_union = z.union(y).collect

// COMMAND ----------

var yz_union = y.union(z).collect

// COMMAND ----------

var zy_intersection = z.intersection(y).collect

// COMMAND ----------


