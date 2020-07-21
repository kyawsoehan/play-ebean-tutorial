
name := """tutorial"""
organization := "com.innoveller"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.3"

libraryDependencies += guice

libraryDependencies ++= Seq(
  javaJdbc,
  "org.postgresql" % "postgresql" % "42.1.4"
)
