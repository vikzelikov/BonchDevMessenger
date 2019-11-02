package bonch.dev.school.models

import java.util.*

data class Message(val messageId: Int, val messageText: String, val sentDate: Date, val isUser: Boolean)