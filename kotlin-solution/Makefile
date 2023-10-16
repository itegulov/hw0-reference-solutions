.PHONY: all compile run pack clean out

SOURCES = $(shell find src -type f -name "*.kt")
CLASSES = $(patsubst src/%.kt,out/%.class,$(SOURCES))
DEPS = lib/better-parse-0.3.2.jar
MAINCLASS = Main
KOTLINC=kotlinc
KOTLIN=kotlin

all: out compile

run:
	${KOTLIN} -cp out:${DEPS} -Djava.io.tmpdir=tmp ${MAINCLASS}

pack:
	rm -f hw0.zip
	zip hw0.zip -r Makefile src lib

clean:
	rm -rf out
	rm -rf tmp

compile: ${SOURCES}
	${KOTLINC} -cp src:${DEPS} -Djava.io.tmpdir=kotlin-tmp $^ -d out

out:
	mkdir -p out
