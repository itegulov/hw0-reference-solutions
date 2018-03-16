package utils;

import java.util.*;
import java.io.*;

public class FastScanner implements AutoCloseable {
  BufferedReader br;
  StringTokenizer st;

  public FastScanner(File f) {
    try {
      br = new BufferedReader(new FileReader(f));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public String next() {
    while (st == null || !st.hasMoreTokens()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  @Override
  public void close() throws IOException {
    br.close();
  }
}
