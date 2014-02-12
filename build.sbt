libraryDependencies ++= Seq(
  "com.twitter" %% "twitter-server" % "1.4.1",
  "com.twitter" %% "finagle-example" % "6.11.1",
  "com.twitter" %% "finagle-thriftmux" % "6.11.1"
)

conflictWarning := ConflictWarning.disable

resolvers += "Twitter Maven repo" at "http://maven.twttr.com/"

scalaVersion := "2.9.2"
