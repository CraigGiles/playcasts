package services

import database.UserRepositoryComponent
import database.slick.{VideoRepositoryComponentSlick, UserRepositoryComponentSlick}

object ServiceWiring {
  val userServiceComponent = new UserServiceComponent with UserRepositoryComponentSlick {
    override def repository = new SlickUserRepository
  }

  val videoServiceComponent = new VideoServiceComponent with VideoRepositoryComponentSlick {
    override def repository = new SlickVideoRepository
  }

  def getUserService = userServiceComponent.service
  def getVideoService = videoServiceComponent.service
}

