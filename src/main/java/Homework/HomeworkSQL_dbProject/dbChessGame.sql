Table players {
  player_id int
  username varchar(64)
  email varchar(64)
  password_hash varchar(64)
  registered_at timestamp
  last_login_at timestamp
}

Table matches {
  match_id int
  player_white_id int
  player_black_id int
  map_id int
  start_time timestamp
  end_time timestamp
  result varchar(64)
}

Table maps {
  map_id int
  map_name varchar(64)
  map_description varchar(64)
}

Table chats {
  chat_id int
  match_id int
}

Table messages {
  message_id int
  chat_id int
  sender_id int
  sent_at timestamp
}



Ref: "players"."player_id" < "matches"."player_white_id"

Ref: "players"."player_id" < "matches"."player_black_id"

Ref: "chats"."chat_id" < "messages"."chat_id"

Ref: "players"."player_id" < "messages"."sender_id"

Ref: "matches"."match_id" - "chats"."match_id"

Ref: "matches"."map_id" < "maps"."map_id"