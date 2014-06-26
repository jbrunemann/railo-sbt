package com.example

import java.io.IOException
import java.util.logging.Logger
import javax.servlet.ServletConfig
import javax.servlet.ServletException
import javax.servlet.ServletOutputStream
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
//remove if not needed
import scala.collection.JavaConversions._

class HelloServlet extends HttpServlet {

  protected override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val out = resp.getOutputStream
    out.write("Hello world".getBytes)
    out.flush()
    out.close()
  }
}