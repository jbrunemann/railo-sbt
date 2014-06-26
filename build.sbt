def ProjectName(name: String,path:String): Project =  Project(name, file(path))

resolvers in Global ++= Seq(Resolver.mavenLocal, "http://cfmlprojects.org/artifacts/" at "http://cfmlprojects.org/artifacts/")

version := "0.1.0"

name := "railo.rhinofly"

organization := "railo.rhinofly"

libraryDependencies in Global ++= Seq("javax.servlet" % "javax.servlet-api" % "3.0.1",
   "org.eclipse.jetty" % "jetty-servlet" % "9.0.3.v20130506",
   "org.eclipse.jetty" % "jetty-webapp" % "9.0.3.v20130506",
   "org.getrailo" % "railo" % "4.3.0.001",
   "org.mortbay.jetty" % "jsp-2.1-glassfish" % "2.1.v20100127",
   "org.owasp.antisamy" % "antisamy" % "1.5.3",
   "org.tuckey" % "urlrewritefilter" % "4.0.3",
   "org.fusesource.jansi" % "jansi" % "1.11")


