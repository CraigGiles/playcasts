package models

import org.joda.time.DateTime


case class Video(id: Option[Int],
                 title: String,
                 author: String,
                 link: String,
                 created_at: DateTime,
                 updated_at: DateTime,
                 deleted_at: Option[DateTime])


object Videos {
  def create(u: (Option[Int], String, String, String, DateTime, DateTime, Option[DateTime])) = Video.tupled(u)
}
