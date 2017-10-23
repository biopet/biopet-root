organization := "com.github.biopet"
name := "root"

scalaVersion := "2.11.11"

resolvers += Resolver.sonatypeRepo("snapshots")

useGpg := true

lazy val root = (project in file("."))
  .aggregate(utils, tools)

lazy val utils = project in file("utils")
lazy val tools = (project in file("tools"))
  .dependsOn(utils)
