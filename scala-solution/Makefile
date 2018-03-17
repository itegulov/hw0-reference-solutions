SCALAC = lib/scala-2.12.4/bin/scalac
SCALA = lib/scala-2.12.4/bin/scala
SOURCES = $(shell find src -type f -name "*.scala")
CLASSES = $(patsubst src/%.scala,out/%.class,$(SOURCES))
DEPS = lib/parboiled_2.12-2.1.4.jar:lib/shapeless_2.12-2.3.3.jar
MAINCLASS = Main

all: out compile

run:
	${SCALA} -cp out:${DEPS} ${MAINCLASS}

clean:
	rm -rf out

compile: ${SOURCES}
	${SCALAC} -cp src:${DEPS} $^ -d out

out:
	mkdir -p out
