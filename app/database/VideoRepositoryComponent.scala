package database

import models.Video

trait VideoRepositoryComponent {
  def repository: VideoRepository

  trait VideoRepository {
    def findById(id: Int): Option[Video]
    def findByTitle(title: String): Seq[Video]
    def findByAuthor(author: String): Seq[Video]
    def save(video: Video): Unit
  }
}
