import sys


def parse(_line):
  global line, pos
  line = _line + '#'
  pos = 0

  def skip(s):
    # print(pos)
    global line, pos
    if line.startswith(s, pos):
      pos += len(s)
      return True
    return False

  def e():
    x = dij()
    if skip('->'):
      x = '(->,' + x + ',' + e() + ')'
    return x
  def dij():
    x = con()
    while skip('|'):
      x = '(|,' + x + ',' + con() + ')'
    return x
  def con():
    x = nt()
    while skip('&'):
      x = '(&,' + x + ',' + nt() + ')'
    return x
  def nt():
    global pos, line
    if skip('('):
      x = e()
      skip(')')
      return x
    if skip('!'):
      return '(!' + str(nt()) + ')'
    x = ''
    while line[pos].isdigit() or line[pos].isalpha():
      x += line[pos]
      pos += 1
    return x

  return e()


def main():
  sys.setrecursionlimit(2**30)
  line = ''

  with sys.stdin as f:
    for x in f.readline():
      if not x.isspace():
        line += x

  e = parse(line)

  print(e)


if __name__ == '__main__':
  main()
