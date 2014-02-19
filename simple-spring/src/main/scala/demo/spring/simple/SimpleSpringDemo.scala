package demo.spring.jms

import java.nio.file.{FileSystems, Files}
import org.apache.camel.spring.Main

/**
 * todo  
 */
object SimpleSpringDemo extends App{

  if (!Files.exists(FileSystems.getDefault.getPath("target", "scala-2.10", "classes", "camel", "in","file1.xml")))
    sys.error("wrong working directory")

  val m  = new Main()
  m.setApplicationContextUri("spring-camel-context.xml")
  m.enableHangupSupport()
  m.run()


}
