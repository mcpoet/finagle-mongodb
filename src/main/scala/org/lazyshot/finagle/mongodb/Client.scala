package org.lazyshot.finagle.mongodb

import com.twitter.finagle.builder.{Cluster, ClientBuilder, ClientConfig, StaticCluster}
import org.lazyshot.finagle.mongodb.bson._

object Client {
  def apply(host: String): Client = Client(
    ClientBuilder()
      .hosts(host)
      .hostConnectionLimit(1)
      .codec(new Mongodb)
      .build())
}

trait BaseClient[T] {
  def insert(doc: BSONDocument): Future[Boolean]

  def update(query: BSONDocument, doc: BSONDocument): Future[Boolean]

  def find(query: BSONDocument): Future[Steam[BSONDocument]]

  def findOne(query: BSONDocument): Future[Option[BSONDocument]]
}