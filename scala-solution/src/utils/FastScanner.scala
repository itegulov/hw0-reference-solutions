package utils

import java.io._
import java.util.StringTokenizer

case class FastScanner(f: File) {

  var br: BufferedReader = new BufferedReader(new FileReader(f))
  var st: StringTokenizer = null

  def next(): String = {
    while ( {st == null || !st.hasMoreTokens}) try
      st = new StringTokenizer(br.readLine)
    catch {
      case e: IOException =>
        e.printStackTrace()
    }
    st.nextToken
  }

  def nextInt(): Int = next().toInt
  
  def close(): Unit = {
    br.close()
  }
}
