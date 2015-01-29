name := "predix-seed"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-all" % "1.9.5" % "test",
  "com.ge.dsv" %% "predix-v-runtime" % "1.9.0")

lazy val root = (project in file(".")).enablePlugins(PlayJava)

credentials += Credentials("Artifactory Realm", "devcloud.swcoe.ge.com", "502398775", "{DESede}/O9QTuX+WMKXBCwL9/LJUQ==")

resolvers += "Artifactory Realm" at "https://devcloud.swcoe.ge.com/artifactory/repo/"

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node

pipelineStages := Seq(rjs)

includeFilter in rjs := new FileFilter {
  val scriptsDir = (baseDirectory.value / "public" ).getAbsolutePath
  def accept(file: File) = file.getAbsolutePath.startsWith(scriptsDir)
}

RjsKeys.mainModule := "app"

RjsKeys.mainConfigFile := new File("scripts/build.js")

RjsKeys.baseUrl := "scripts"
