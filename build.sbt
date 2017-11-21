name := "cadastro_pessoas"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
)





libraryDependencies += filters

libraryDependencies += "net.sf.jasperreports" % "jasperreports" % "6.0.0"

libraryDependencies += "commons-io" % "commons-io" % "2.4"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.35"

libraryDependencies += "org.jsoup" % "jsoup" % "1.8.3"

libraryDependencies += "com.googlecode.json-simple" % "json-simple" % "1.1"

libraryDependencies += "com.typesafe.play" %% "play-mailer" % "2.4.0"

resolvers += "Jasper" at "http://jasperreports.sourceforge.net/maven2"

resolvers +=  "olap4j" at "http://jaspersoft.artifactoryonline.com/jaspersoft/third-party-ce-artifacts"

resolvers += "BeDataDriven" at "https://nexus.bedatadriven.com/content/groups/public/"

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/releases/"
