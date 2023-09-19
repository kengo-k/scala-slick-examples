package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = _PrismaMigrations.schema ++ Company.schema ++ User.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table _PrismaMigrations
   *  @param id Database column id SqlType(varchar), PrimaryKey, Length(36,true)
   *  @param checksum Database column checksum SqlType(varchar), Length(64,true)
   *  @param finishedAt Database column finished_at SqlType(timestamptz), Default(None)
   *  @param migrationName Database column migration_name SqlType(varchar), Length(255,true)
   *  @param logs Database column logs SqlType(text), Default(None)
   *  @param rolledBackAt Database column rolled_back_at SqlType(timestamptz), Default(None)
   *  @param startedAt Database column started_at SqlType(timestamptz)
   *  @param appliedStepsCount Database column applied_steps_count SqlType(int4), Default(0) */
  case class _PrismaMigrationsRow(id: String, checksum: String, finishedAt: Option[java.sql.Timestamp] = None, migrationName: String, logs: Option[String] = None, rolledBackAt: Option[java.sql.Timestamp] = None, startedAt: java.sql.Timestamp, appliedStepsCount: Int = 0)
  /** GetResult implicit for fetching _PrismaMigrationsRow objects using plain SQL queries */
  implicit def GetResult_PrismaMigrationsRow(implicit e0: GR[String], e1: GR[Option[java.sql.Timestamp]], e2: GR[Option[String]], e3: GR[java.sql.Timestamp], e4: GR[Int]): GR[_PrismaMigrationsRow] = GR{
    prs => import prs._
    _PrismaMigrationsRow.tupled((<<[String], <<[String], <<?[java.sql.Timestamp], <<[String], <<?[String], <<?[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table _prisma_migrations. Objects of this class serve as prototypes for rows in queries. */
  class _PrismaMigrations(_tableTag: Tag) extends profile.api.Table[_PrismaMigrationsRow](_tableTag, "_prisma_migrations") {
    def * = (id, checksum, finishedAt, migrationName, logs, rolledBackAt, startedAt, appliedStepsCount) <> (_PrismaMigrationsRow.tupled, _PrismaMigrationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(checksum), finishedAt, Rep.Some(migrationName), logs, rolledBackAt, Rep.Some(startedAt), Rep.Some(appliedStepsCount))).shaped.<>({r=>import r._; _1.map(_=> _PrismaMigrationsRow.tupled((_1.get, _2.get, _3, _4.get, _5, _6, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(varchar), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column checksum SqlType(varchar), Length(64,true) */
    val checksum: Rep[String] = column[String]("checksum", O.Length(64,varying=true))
    /** Database column finished_at SqlType(timestamptz), Default(None) */
    val finishedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("finished_at", O.Default(None))
    /** Database column migration_name SqlType(varchar), Length(255,true) */
    val migrationName: Rep[String] = column[String]("migration_name", O.Length(255,varying=true))
    /** Database column logs SqlType(text), Default(None) */
    val logs: Rep[Option[String]] = column[Option[String]]("logs", O.Default(None))
    /** Database column rolled_back_at SqlType(timestamptz), Default(None) */
    val rolledBackAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("rolled_back_at", O.Default(None))
    /** Database column started_at SqlType(timestamptz) */
    val startedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("started_at")
    /** Database column applied_steps_count SqlType(int4), Default(0) */
    val appliedStepsCount: Rep[Int] = column[Int]("applied_steps_count", O.Default(0))
  }
  /** Collection-like TableQuery object for table _PrismaMigrations */
  lazy val _PrismaMigrations = new TableQuery(tag => new _PrismaMigrations(tag))

  /** Entity class storing rows of table Company
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(text)
   *  @param createdat Database column createdAt SqlType(timestamp) */
  case class CompanyRow(id: Int, name: String, createdat: java.sql.Timestamp)
  /** GetResult implicit for fetching CompanyRow objects using plain SQL queries */
  implicit def GetResultCompanyRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[CompanyRow] = GR{
    prs => import prs._
    CompanyRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table Company. Objects of this class serve as prototypes for rows in queries. */
  class Company(_tableTag: Tag) extends profile.api.Table[CompanyRow](_tableTag, "Company") {
    def * = (id, name, createdat) <> (CompanyRow.tupled, CompanyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(createdat))).shaped.<>({r=>import r._; _1.map(_=> CompanyRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(text) */
    val name: Rep[String] = column[String]("name")
    /** Database column createdAt SqlType(timestamp) */
    val createdat: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("createdAt")
  }
  /** Collection-like TableQuery object for table Company */
  lazy val Company = new TableQuery(tag => new Company(tag))

  /** Entity class storing rows of table User
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(text)
   *  @param createdat Database column createdAt SqlType(timestamp) */
  case class UserRow(id: Int, name: String, createdat: java.sql.Timestamp)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table User. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends profile.api.Table[UserRow](_tableTag, "User") {
    def * = (id, name, createdat) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(createdat))).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(text) */
    val name: Rep[String] = column[String]("name")
    /** Database column createdAt SqlType(timestamp) */
    val createdat: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("createdAt")
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
