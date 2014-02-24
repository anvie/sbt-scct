organization := "reaktor"

name := "sbt-scct"

version := "0.2-SNAPSHOT"

//scalaVersion := "2.10.0-RC3" (not yet, sbt itself uses 2.9)
scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.10.0-RC3", "2.9.2", "2.9.1-1", "2.9.1", "2.9.0-1", "2.9.0")

sbtPlugin := true

// Load scct from remote:
resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

resolvers += "Local Repo" at "file://" + Path.userHome + "/.m2/repository"

// For local development:
// resolvers += "scct-repository" at "file:///Users/mtkopone/dev/scct-root/gh-pages/maven-repo"

libraryDependencies += "reaktor" %% "scct" % "0.2-SNAPSHOT"

publishTo <<= version {
    (v: String) =>
        val ansviaRepo = "http://scala.repo.ansvia.com/nexus"
        if (v.trim.endsWith("SNAPSHOT"))
            Some("snapshots" at ansviaRepo + "/content/repositories/snapshots")
        else
            Some("releases" at ansviaRepo + "/content/repositories/releases")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials-ansvia")
