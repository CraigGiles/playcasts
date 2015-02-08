package database.slick

import models.{Users, User}
import database.UserRepositoryComponent
import database.slick.tables.Users
import database.DatabaseDriver.simple._
import scala.slick.lifted.TableQuery

trait UserRepositoryComponentSlick extends UserRepositoryComponent {
  def userRepository = new SlickUserRepository

  class SlickUserRepository extends UserRepository with Slickable {
    lazy val users = TableQuery[Users]

    override def findById(id: Int): Option[User] = {
      database withSession { implicit session =>
        val user = users.list.find(u => u._1 == Some(id))
        user.map(u => Users.create(u))
      }
    }

    override def save(user: User): Unit = {

    }

    override def findByEmail(email: String): Option[User] = {
      None
    }
  }
}
