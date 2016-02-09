package tasks

import java.io.File
import shared.Conf
import scala.sys.process._

/**
 * Created by nico on 09/02/16.
 */
object Download {
  def main(args: Array[String]) {
    val outDirPath = Conf.getString("data.path")
    val outDir = new File(outDirPath)
    if(outDir.exists()) {
      if(!outDir.isDirectory) {
        println("Error: the path is not a directory")
        System.exit(0)
      }
    } else {
      outDir.mkdirs()
    }
    s"wget ${Conf.getString("dump.url")}${Conf.getString("dump.file")}.bz2 -P ${outDirPath}".!!
  }
}
