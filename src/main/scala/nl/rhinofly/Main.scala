package nl.rhinofly

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.fusesource.jansi.AnsiConsole

/**
 * 
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 *
 */
object Main {

  val ANSI_CLS = "\u001b[2J"
  val ANSI_HOME = "\u001b[H"
  val ANSI_BOLD = "\u001b[1m"
  val ANSI_AT55 = "\u001b[10;10H"
  val ANSI_REVERSEON = "\u001b[7m"
  val ANSI_NORMAL = "\u001b[0m"
  val ANSI_WHITEONBLUE = "\u001b[37;44m"

  def main(args: Array[String]) {
      //Look for that variable and default to 8080 if it isn't there.
      var webPort = "8080"
      
      if(args.length > 0) {
          webPort = args(0)
      }

      val webappDirLocation = "src/main/webapp/"
      val server = new Server(Integer.valueOf(webPort))
      val root = new WebAppContext()

      root.setContextPath("/")
      root.setDescriptor(webappDirLocation+"/WEB-INF/web.xml")
      root.setResourceBase(webappDirLocation)
      
      //Parent loader priority is a class loader setting that Jetty accepts.
      //By default Jetty will behave like most web containers in that it will
      //allow your application to replace non-server libraries that are part of the
      //container. Setting parent loader priority to true changes this behavior.
      //Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
      root.setParentLoaderPriority(true)
      
      server.setHandler(root)
      
      server.start()

      AnsiConsole.systemInstall()

      AnsiConsole.out.println(ANSI_WHITEONBLUE + "Railo running on port " + webPort + ANSI_NORMAL)

      server.join()
  }

}
