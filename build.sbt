import com.lihaoyi.workbench.Plugin._

enablePlugins(ScalaJSPlugin)

name := "Basic ScalaJS Webapp"

scalaVersion := "2.11.7"

scalaJSUseRhino in Global := false
persistLauncher in Compile := true
persistLauncher in Test := false
skip in packageJSDependencies := false

// Scala dependencies
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0"
libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.0"

// JS dependencies
jsDependencies += RuntimeDOM
jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"

// Test dependencies
libraryDependencies += "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
testFrameworks += new TestFramework("utest.runner.Framework")

workbenchSettings

bootSnippet := "basic.webapp.Main().main();"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)