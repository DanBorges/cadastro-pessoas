resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

resolvers += "Typesafe snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

resolvers += "Sonatype releases" at "http://oss.sonatype.org/content/repositories/releases/"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.7" withJavadoc()  withSources())

// web plugins

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0" withJavadoc()  withSources())

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.0" withJavadoc()  withSources())

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.1" withJavadoc()  withSources())

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.1" withJavadoc()  withSources())

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.0.0" withJavadoc()  withSources())

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.0.0" withJavadoc()  withSources())
