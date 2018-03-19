HC=/opt/ghc/7.10.3/bin/ghc
#HC=ghc
LIBS=$(strip $(wildcard ./lib/*))
LPATH=$(shell echo $(LIBS) | tr ' ' ':')
SOURCES=src/Main.hs src/Grammar.hs
GEN_SOURCES=src/Lexer.x src/Parser.y
GENERATED=src/Lexer.hs src/Parser.hs
PACKAGE=hw0.zip
#MACROS=-D'MIN_VERSION_base(a, b, c)=0' -D'MIN_VERSION_mtl(a, b, c)=0'

.PHONY: pack all run clean

all: parser

run: parser
	./parser

clean:
	rm -rf src/*.o src/*.hi
	rm -rf $(GENERATED)
	rm -f parser

parser: $(GENERATED) $(SOURCES)
	$(HC) -i./src -tmpdir . ./src/Main.hs -o parser

$(GENERATED): $(GEN_SOURCES) $(SOURCES)
	alex src/Lexer.x -o src/Lexer.hs
	happy src/Parser.y -o src/Parser.hs

pack: $(GENERATED)
	zip $(PACKAGE) -r Makefile src
