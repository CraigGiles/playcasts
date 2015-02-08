package services

import database.UserRepositoryComponent
import database.slick.UserRepositoryComponentSlick

object ServiceWiring {
  val userServiceComponent = new UserServiceComponent with UserRepositoryComponentSlick {
    override def repository: UserRepository = new SlickUserRepository
  }

  def getUserService = userServiceComponent.service
}

