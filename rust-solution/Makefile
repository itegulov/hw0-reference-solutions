SOURCES = Cargo.toml *.rs src/*.rs src/*.lalrpop
TARGET = x86_64-unknown-linux-musl
EXECUTABLE = target/${TARGET}/release/hw0

all:

run: # ${EXECUTABLE}
	${EXECUTABLE} < input.txt > output.txt

Cargo.lock:
	cargo update

${EXECUTABLE}: ${SOURCES}
	cargo build --target ${TARGET} --release

hw0.zip: Makefile Cargo.lock ${SOURCES} ${EXECUTABLE}
	zip $@ $^

binary: ${EXECUTABLE}

pack: hw0.zip

.PHONY: all binary pack
