organization := "com.github.biopet"
name := "Root"

scalaVersion := "2.11.11"

biopetUrlName := "root"

biopetIsTool := false

developers += Developer(id="ffinfo", name="Peter van 't Hof", email="pjrvanthof@gmail.com", url=url("https://github.com/ffinfo"))

lazy val root = (project in file("."))
  .aggregate(utils, tools)

lazy val utils = project in file("utils")
lazy val tools = (project in file("tools"))
  .dependsOn(utils)
