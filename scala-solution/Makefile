.PHONY: all run pack clean out

SOURCES = $(shell find src -type f -name "*.scala")
CLASSES = $(patsubst src/%.scala,out/%.class,$(SOURCES))
DEPS = lib/parboiled_2.12-2.1.4.jar:lib/shapeless_2.12-2.3.3.jar
MAINCLASS = Main

all: prepare-scala out ${CLASSES}

run:
	${SCALA} -cp out:${DEPS} ${MAINCLASS}

pack:
	zip hw0.zip -r Makefile src lib

clean:
	rm -rf out

${CLASSES}: ${SOURCES}
	${SCALAC} -cp src:${DEPS} $^ -d out

out:
	mkdir -p out

include scala.mk
