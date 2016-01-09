resolvers ++= Seq(
  Resolver.url("scalasbt releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)
)

addSbtPlugin("com.hanhuy.sbt" % "android-sdk-plugin" % "1.5.12")

libraryDependencies += "net.sf.proguard" % "proguard-base" % "5.2.1"
