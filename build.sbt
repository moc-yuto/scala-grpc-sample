import scalapb.compiler.Version.protobufVersion

name := "scala-grpc-sample"
scalacOptions := Seq("-deprecation", "-unchecked", "-Xlint", "-Yno-adapted-args")
libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.2"
)


PB.targets in Compile := Seq(
  PB.gens.java(protobufVersion) -> ((sourceManaged in Compile).value / "protobuf-java"),
  scalapb.gen(javaConversions=true) -> ((sourceManaged in Compile).value / "protobuf-scala")
)