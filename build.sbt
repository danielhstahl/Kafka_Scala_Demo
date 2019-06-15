scalaVersion := "2.11.12"

name := "kafkatest"
organization := "ml.dhs"

libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "2.2.1",
    "org.apache.kafka" % "kafka-clients" % "2.2.1",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.json4s" %% "json4s-native" % "3.2.11"
)