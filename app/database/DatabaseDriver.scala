package database

import play.api.Play

import scala.slick.driver.{H2Driver, JdbcProfile, MySQLDriver, PostgresDriver}

object DatabaseDriver {
  val simple = profile.simple

  lazy val profile: JdbcProfile = {
    Play.current.configuration.getString("db.default.type") match {
      case Some("mysql")    => MySQLDriver
      case Some("postgres") => PostgresDriver
      case _                => H2Driver
    }
  }
}
