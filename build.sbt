import android.Keys._

lazy val commonSettings = Seq(
  name := "draconia",
  organization := "com.github.fellowship_of_the_bus",
  scalaVersion := "2.11.7",
  javacOptions ++= Seq(
    "-encoding", "utf8",
    "-source", "1.7",
    "-target", "1.7",
    "-Xlint"
  ),
  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-encoding", "utf8",
    "-target:jvm-1.7",
    "-optimize",
    "-Xlint",
    "-Yinline-warnings",
    "-Yinline",
    "-Yinline-handlers",
    "-Ybackend:GenBCode", // until 2.12 to eliminate inline warnings
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-value-discard",
    "-Ywarn-unused"
  ),
  resolvers ++= Seq(
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    Resolver.url(
      "sbt-plugin-releases",
      new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/")
    )(Resolver.ivyStylePatterns)
  ),
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.6" % "test",
    "junit" % "junit" % "4.12" % "test",
    "com.propensive" %% "rapture-json-jackson" % "2.0.0-M3"
    // "com.github.pathikrit" %% "better-files" % "2.14.0",
    // "com.github.fellowship_of_the_bus" %% "fellowship-of-the-bus-lib" % "0.3-SNAPSHOT" changing()
  )
)

val androidVersionCode = Some(1)

// val androidProguard = """
//   -target 6
//   -keep class scala.collection.SeqLike { public protected *; }
// """

lazy val androidSettings = commonSettings ++
  // AndroidProject.androidSettings ++
  // TypedResources.settings ++
  // AndroidManifestGenerator.settings ++
  // AndroidMarketPublish.settings ++
  androidBuild ++
  Seq(
    platformTarget := "android-23",
    version := "0.1." + androidVersionCode,
    versionCode           := androidVersionCode,
    updateCheck in Android := {}, // disable update check
    unmanagedClasspath in Test ++= (bootClasspath in Android).value,
    proguardCache in Android ++= Seq("org.scaloid"),
    proguardOptions in Android ++= Seq(
      "-dontobfuscate",
      "-dontoptimize",
      "-keepattributes Signature",
      "-printseeds target/seeds.txt",
      "-printusage target/usage.txt",
      "-dontwarn scala.collection.**", // required from Scala 2.11.4
      "-dontwarn org.scaloid.**" // this can be omitted if current Android Build target is android-16
    ),
    // platformName in Android   := "android-23",
    useProguard in Android    := true,
    // proguardOption in Android := androidProguard,
    // keyalias in Android   := "change-me"
    packagingOptions in Android := PackagingOptions(
      pickFirsts = Seq("META-INF/NOTICE", "META-INF/LICENSE")
    ),
    libraryDependencies ++= Seq(
      "org.scaloid" %% "scaloid" % "4.1",
      "org.apache.maven" % "maven-ant-tasks" % "2.1.3" % "test",
      "org.robolectric" % "robolectric" % "3.0" % "test",
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )

lazy val root = (project in file("android"))
  .settings(androidSettings: _*)
