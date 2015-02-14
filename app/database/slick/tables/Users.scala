package database.slick.tables

import org.joda.time.DateTime
import database.DatabaseDriver.simple._
import scala.slick.lifted.ProvenShape
import com.github.tototoshi.slick.MySQLJodaSupport._
import models.User

class Users(tag: Tag) extends Table[User](tag, "users") {
  def id: Column[Option[Int]] = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def name: Column[String] = column[String]("name")
  def email: Column[String] = column[String]("email")
  def password: Column[String] = column[String]("password")
  def created_at: Column[DateTime] = column[DateTime]("created_at")
  def updated_at: Column[DateTime] = column[DateTime]("updated_at")
  def deleted_at: Column[Option[DateTime]] = column[Option[DateTime]]("deleted_at", O.Nullable)

  def * = (id, name, email, password, created_at, updated_at, deleted_at) <> ((User.apply _).tupled, User.unapply)
}


