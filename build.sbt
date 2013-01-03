organization := "com.github.play2war.ext"

name := "jboss7-reflections-vfs-integration-play2"

crossScalaVersions := Seq("2.9.1", "2.10.0-RC1")

scalaVersion := "2.10.0"

resolvers += "Typesafe releases" at "http://repo.typesafe.com/typesafe/releases"

autoScalaLibrary := false

libraryDependencies <+= (scalaVersion) { scalaVersion: String =>
  val playVersion = if (scalaVersion.contains("2.9")) "2.0.4"
                    else "2.1-RC1"
  "play" %% "play" % playVersion % "provided->default"  
}

libraryDependencies += "com.dlecan.reflections" % "jboss7-reflections-vfs-integration-core" % "1.1.0-SNAPSHOT"

resolvers += "Local Maven Repository" at "file:///D:/Dev/m2-repository"

publishTo <<= (version) { version: String =>
  val cloudbees = "https://repository-play-war.forge.cloudbees.com/"
  val repo = if (version.trim.endsWith("SNAPSHOT")) Resolver.url("snapshot",  url(cloudbees + "snapshot/"))
//  val repo = if (version.trim.endsWith("SNAPSHOT")) Resolver.file("file",  file(Path.userHome.absolutePath + "/.ivy2/publish"))
             else Resolver.file("file",  file(Path.userHome.absolutePath + "/.ivy2/publish"))
//             else Resolver.url("release",  url(cloudbees + "release/"))
  Some(repo)
}

publishMavenStyle := true

releaseSettings

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")