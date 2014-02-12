package com.mosesn.loadbalance

import com.twitter.util.{Await, Timer, Future}
import com.twitter.server.TwitterServer
import com.twitter.finagle.ThriftMux
import com.twitter.finagle.example.thrift.Hello

object TestThrift extends TwitterServer{
  val result = flag("result", "OK", "the result")
  val server = flag("server", false, "you a server?")

  object ThriftService extends Hello[Future]{
    def hi() = Future.value(result())
  }

  def main(){

    if (server()) {
      val server = ThriftMux.serveIface(":*", ThriftService)
      server.announce("zk!localhost:2181!/search!1")
      Await.ready(server)
    }
    else {
      val client = ThriftMux.newIface[Hello[Future]]("zk!localhost:2181!/search")
      println(Await.result(client.hi()))
      println(Await.result(client.hi()))
      println(Await.result(client.hi()))
      println(Await.result(client.hi()))
      println(Await.result(client.hi()))
      println(Await.result(client.hi()))
    }
  }
}
