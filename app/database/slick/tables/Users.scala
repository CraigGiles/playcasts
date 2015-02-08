package database.slick.tables

import org.joda.time.DateTime
import database.DatabaseDriver.simple._
import scala.slick.lifted.ProvenShape
import com.github.tototoshi.slick.MySQLJodaSupport._

class Users(tag: Tag) extends Table[(Option[Int], String, String, String, DateTime, DateTime, Option[DateTime])](tag, "users") {
  def id: Column[Option[Int]] = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def name: Column[String] = column[String]("name")
  def email: Column[String] = column[String]("email")
  def password: Column[String] = column[String]("password")
  def created_at: Column[DateTime] = column[DateTime]("created_at")
  def updated_at: Column[DateTime] = column[DateTime]("updated_at")
  def deleted_at: Column[Option[DateTime]] = column[Option[DateTime]]("deleted_at", O.Nullable)

  def * : ProvenShape[(Option[Int], String, String, String, DateTime, DateTime, Option[DateTime])] =
    (id, name, email, password, created_at, updated_at, deleted_at)
}


