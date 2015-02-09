package services

import database.VideoRepositoryComponent
import models.Video

trait VideoServiceComponent {
  this: VideoRepositoryComponent =>

  val service: VideoService = new VideoService

  class VideoService {
    def getAllVideos(): Seq[Video] = {
      repository.all()
    }
//    def find(id: Int): Option[User] = repository.findById(id)
//    def findByEmail(email: String): Option[User] = repository.findByEmail(email)
//    def save(user: User): Unit = repository.save(user)
  }
}
