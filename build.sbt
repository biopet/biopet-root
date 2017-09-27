organization := "nl.biopet"
name := "biopetRoot"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.11"

resolvers += Resolver.mavenLocal

lazy val root = (project in file("."))
  .aggregate(biopetSummary, biopetSummaryTool, biopetReport, biopetUtils)

lazy val biopetUtils = project in file("biopet-utils")
//lazy val biopetToolUtils = project in file("biopet-utils/biopet-tool-utils")
//lazy val biopetNgsUtils = project in file("biopet-utils/biopet-ngs-utils")
//lazy val biopetConfigUtils = project in file("biopet-utils/biopet-config-utils")
lazy val biopetSummary = (project in file("biopet-summary"))
  .dependsOn(biopetUtils)
lazy val biopetSummaryTool = (project in file("biopet-summary-tool"))
  .dependsOn(biopetSummary, biopetUtils)
lazy val biopetReport = (project in file("biopet-report"))
  .enablePlugins(PlayScala)
  .dependsOn(biopetSummary, biopetUtils)

libraryDependencies += "com.h2database" % "h2" % "1.4.196"
