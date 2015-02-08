package database.slick

import play.api.Play

import scala.slick.driver.MySQLDriver.simple._

trait Slickable {

  /**
   * Gets the database session for the application
   *
   * @return
   */
  def database = {
    val drv = Play.current.configuration.getString("db.default.driver")
    val url = Play.current.configuration.getString("db.default.url")
    val usr = Play.current.configuration.getString("db.default.user")
    val pass = Play.current.configuration.getString("db.default.password")

    Database.forURL(url.get, driver = drv.get, user = usr.get, password = pass.get)
  }
}
