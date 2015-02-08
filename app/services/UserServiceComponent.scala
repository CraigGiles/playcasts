package services

import database.UserRepositoryComponent
import models.User

trait UserServiceComponent {
  this: UserRepositoryComponent =>

  val service: UserService = new UserService

  class UserService {
    def find(id: Int): Option[User] = {
      repository.findById(id)
    }

    def save(user: User): Unit = {
      repository.save(user)
    }
  }
}
