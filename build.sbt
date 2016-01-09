import android.Keys._
android.Plugin.androidBuild

lazy val commonSettings = Seq(
  name := "draconia",
  organization := "com.github.fellowship_of_the_bus",
  scalaVersion := "2.11.7",
  javacOptions ++= Seq(
    "-encoding", "utf8",
    "-source", "1.6",
    "-target", "1.6",
    "-Xlint"
  ),
  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-encoding", "utf8",
    "-target:jvm-1.6",
    "-optimize",
    "-Xlint",
    "-Yinline-warnings",
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
    "org.scalatest" %% "scalatest" % "2.2.5" % "test",
    "junit" % "junit" % "4.12" % "test",
    "com.propensive" %% "rapture-json-jackson" % "2.0.0-M2",
    "com.github.pathikrit" %% "better-files" % "2.14.0",
    "com.github.fellowship_of_the_bus" %% "fellowship-of-the-bus-lib" % "0.3-SNAPSHOT" changing()
  )
)

val androidVersionCode = Some(1)

val androidProguard = """
  -target 6
  -keep class scala.collection.SeqLike { public protected *; }
"""

lazy val androidSettings = Seq(
  version := "0.1." + androidVersionCode,
  // scalaVersion          := "2.10.1",
  versionCode           := androidVersionCode,
  // AndroidKeys.platformName in Android   := "android-23",
  // useProguard in Android    := true,
  // proguardOption in Android := androidProguard,
  // keyalias in Android   := "change-me"
  libraryDependencies ++= Seq(
    "org.scaloid" %% "scaloid" % "4.1",
    "org.apache.maven" % "maven-ant-tasks" % "2.1.3" % "test",
    "org.robolectric" % "robolectric" % "3.0" % "test",
    "com.novocode" % "junit-interface" % "0.11" % "test"
  )
) ++ commonSettings
// ++ AndroidProject.androidSettings ++
//   TypedResources.settings ++
//   AndroidManifestGenerator.settings ++
//   AndroidMarketPublish.settings ++

updateCheck in Android := {} // disable update check
proguardCache in Android ++= Seq("org.scaloid")

proguardOptions in Android ++= Seq(
  "-dontobfuscate",
  "-dontoptimize",
  "-keepattributes Signature",
  "-printseeds target/seeds.txt",
  "-printusage target/usage.txt",
  "-dontwarn scala.collection.**", // required from Scala 2.11.4
  "-dontwarn org.scaloid.**" // this can be omitted if current Android Build target is android-16
)

lazy val root = (project in file("."))
  .settings(androidSettings: _*)

unmanagedClasspath in Test ++= (bootClasspath in Android).value
