package models

import org.joda.time._
case class User(id: Long, name: String, email: String, password: String,
    created_at: DateTime, updated_at: DateTime, deleted_at: Option[DateTime])


