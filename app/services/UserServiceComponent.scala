package services

import models.User
import repositories.users.UserRepositoryComponent

trait UserServiceComponent {
  this: UserRepositoryComponent =>

  val service: UserService = new UserService

  class UserService {
    def find(id: Int): User = {
      repository.find(id)
    }

    def save(user: User): Unit = {
      repository.save(user)
    }
  }
}
