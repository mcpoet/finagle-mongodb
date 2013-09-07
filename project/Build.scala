import sbt._
import Keys._

object FinagleMongoBuild extends Build {
  lazy val finagle_mongodb = Project (
    "finagle-mongodb",
    file ("."),
    settings = Seq(
      organization := "org.lazyshot",
      version      := "0.0.1",
      scalaVersion := "2.9.2",

      libraryDependencies += "com.twitter" %% "finagle-core"  % "6.5.0"
    )
  )
}