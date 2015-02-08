package services

import repositories.users.UserRepositoryComponent
import repositories.users.sql.UserRepositoryComponentSlick

object ServiceWiring {
  val userServiceComponent = new UserServiceComponent with UserRepositoryComponentSlick {
    override def repository: UserRepository = new DefaultUserRepository
  }

  def getUserService = userServiceComponent.service
}

