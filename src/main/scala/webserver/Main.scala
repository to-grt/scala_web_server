package webserver

import webserver.library.{Client, Server, WebResponse, WebRequest, EchoServer, Test}


val server_port: Int = 8000

@main def serverSide(): Unit =          // same as server but infinite loop for service
  val myEchoServer = EchoServer(server_port)
  myEchoServer.start

@main def serverTestSide(): Unit =      // one time use
  val myServer = Server(server_port)
  myServer.start

@main def clientSide(): Unit =          // a client aht will be recognized by the server
  val firstClient = Client("127.0.0.1", server_port, "hello server")
  firstClient.start

@main def clientSideStranger(): Unit =  // a client that will not be recognized by the server
  val secondClient = Client("127.0.0.1", server_port, "I send a wrong message")
  secondClient.start





