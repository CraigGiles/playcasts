package services

import repositories.users.sql.UserRepositorySqlComponent

object ServiceWiring {
  val userServiceComponent = new UserServiceComponent with UserRepositorySqlComponent {
    //expresses dependencies
    override def repository: UserRepository = new UserRepositoryImpl
  }

  def getUserService = userServiceComponent.service
}
