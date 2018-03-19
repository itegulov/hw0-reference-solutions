.PHONY: prepare-scala
SCALAC=scala-2.12.4/bin/scalac
SCALA=scala-2.12.4/bin/scala

prepare-scala:
	cat scala-2.12.b64 | base64 --decode > scala-2.12.zip
	unzip -n -q scala-2.12.zip
