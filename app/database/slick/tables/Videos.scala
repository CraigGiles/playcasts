package database.slick.tables

import org.joda.time.DateTime
import database.DatabaseDriver.simple._
import scala.slick.lifted.ProvenShape
import com.github.tototoshi.slick.MySQLJodaSupport._

class Videos(tag: Tag) extends Table[(Option[Int], String, String, String, DateTime, DateTime, Option[DateTime])](tag, "videos") {
  def id: Column[Option[Int]] = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def title: Column[String] = column[String]("title")
  def author: Column[String] = column[String]("author")
  def link: Column[String] = column[String]("link")
  def created_at: Column[DateTime] = column[DateTime]("created_at")
  def updated_at: Column[DateTime] = column[DateTime]("updated_at")
  def deleted_at: Column[Option[DateTime]] = column[Option[DateTime]]("deleted_at", O.Nullable)

  def * : ProvenShape[(Option[Int], String, String, String, DateTime, DateTime, Option[DateTime])] =
    (id, title, author, link, created_at, updated_at, deleted_at)
}

