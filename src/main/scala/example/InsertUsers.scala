package example

import models.Tables._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

object InsertUsers extends App {

  // データベース接続の設定
  val db = Database.forConfig("slick.dbs.default.db") // application.conf内のDB設定名

  // 新しいUserRowインスタンスを作成
  val newUser = UserRow(
    id = 0,
    name = "New User",
    createdat = new java.sql.Timestamp(System.currentTimeMillis())
  )

  // Insertアクションを作成
  val insertAction: DBIO[Int] = User += newUser

  // DBアクションを実行
  val insertFuture: Future[Int] = db.run(insertAction)

  // 結果を待つ（実際のアプリケーションではブロッキングを避けるために、Futureの結果を適切に処理する必要があります）
  val insertResult = Await.result(insertFuture, 10.seconds)

  println(s"Insert result: $insertResult")

  // データベース接続を閉じる
  db.close()
}
