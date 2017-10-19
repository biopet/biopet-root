organization := "com.github.biopet"
name := "biopetRoot"

scalaVersion := "2.11.11"

resolvers += Resolver.mavenLocal

useGpg := true

lazy val biopetRoot = (project in file("."))
  .aggregate(biopetUtils, biopetTools)

lazy val biopetUtils = project in file("biopet-utils")
lazy val biopetTools = (project in file("biopet-tools"))
  .dependsOn(biopetUtils)
