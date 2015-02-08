package repositories.users.sql

import models.User
import org.joda.time.DateTime
import repositories.users.UserRepositoryComponent

trait UserRepositorySqlComponent extends UserRepositoryComponent {
  def userRepository = new UserRepositoryImpl

  class UserRepositoryImpl extends UserRepository {
    override def find(id: Int): User = {
      User(1, "Craig Giles", "craig@gilesc.com", "aosdgfoaf38faodsbouy131oasjbdf", new DateTime(), new DateTime(), None)
    }

    override def save(user: User): Unit = {
      println("Saved user: " + user.name)
    }
  }
}