package services

import models.User
import repositories.users.UserRepositoryComponent

trait UserServiceComponent {
  def service: UserService

  trait UserService {
    def find(id: Int): User
    def save(user: User): Unit
  }
}

trait DefaultUserServiceComponent extends UserServiceComponent {
  this: UserRepositoryComponent =>

  def service = new DefaultUserService

  class DefaultUserService extends UserService {
    override def find(id: Int): User = {
      repository.find(id)
    }

    override def save(user: User): Unit = {
      repository.save(user)
    }
  }
}