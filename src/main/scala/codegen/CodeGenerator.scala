package codegen

import slick.codegen.SourceCodeGenerator
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile

import scala.concurrent.Await
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration

object CodeGenerator extends App {

  implicit val ec: ExecutionContext = ExecutionContext.global

  val db = PostgresProfile.api.Database.forConfig("slick.dbs.default.db")

  val outputFolder = "src/main/scala"
  val packageName = "models"

  val codegen = db.run {
    PostgresProfile.defaultTables
      .flatMap(tables =>
        PostgresProfile.createModel(Some(DBIO.successful(tables)))
      )
      .flatMap { model =>
        DBIO.successful(new SourceCodeGenerator(model))
      }
  }

  val codeGeneratorFuture = codegen.map { codegen =>
    codegen.writeToFile(
      "slick.jdbc.PostgresProfile",
      outputFolder,
      packageName,
      "Tables",
      "Tables.scala"
    )
  }

  Await.result(codeGeneratorFuture, Duration.Inf)
  db.close()
}
