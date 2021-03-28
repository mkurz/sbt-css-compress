lazy val `sbt-css-compress` = (project in file(".")).enablePlugins(SbtWebBase)

organization := "net.ground5hark.sbt"

name := "sbt-css-compress"

version := "0.1.5-SNAPSHOT"

resolvers ++= Seq(
  Resolver.mavenLocal
)

addSbtWeb("1.4.4")

publishMavenStyle := true

//scriptedSettings

scriptedLaunchOpts ++= Seq(
  "-Xmx1024M",
  "-XX:MaxPermSize=256M",
  s"-Dproject.version=${version.value}"
)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  Some(if (isSnapshot.value) {
    "snapshots" at nexus + "content/repositories/snapshots"
  } else {
    "releases" at nexus + "service/local/staging/deploy/maven2"
  })
}

pomExtra := (
  <url>https://github.com/ground5hark/sbt-css-compress</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>http://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:ground5hark/sbt-css-compress.git</url>
    <connection>scm:git:git@github.com:ground5hark/sbt-css-compress.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ground5hark</id>
      <name>John Bernardo</name>
      <url>https://github.com/ground5hark</url>
    </developer>
  </developers>)
