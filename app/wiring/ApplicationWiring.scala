package wiring

import repositories.users.sql.UserRepositorySqlComponent
import services.UserServiceComponent

object ApplicationWiring {
  val userServiceComponent = new UserServiceComponent with UserRepositorySqlComponent {
    //expresses dependencies
    override def repository: UserRepository = new UserRepositoryImpl
  }

  def getUserService = userServiceComponent.service
}
