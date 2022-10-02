package com.example.whatsapp_clone

data class Chat(
    val id: Int,
    val name: String,
    val time: String,
    val date: String?,
    val lastMessage: String?,
    val image: Int
)

data class Call(
    val id: Int,
    val name: String,
    val date: String,
    val image: Int,
    val isMissCall: Boolean,
    val isIncoming: Boolean,
)

data class Message(
    val message: String,
    val isPeer: Boolean
)
object DummyData {
    val listChat = listOf(
        Chat(
            id = 0,
            name = "Rohit",
            time = "08:46",
            date = "2 Oct",
            lastMessage = "Hello Bro How are you",
            image = R.drawable.person1
        ),
        Chat(
            id = 1,
            name = "Raunak",
            time = "05:26",
            date = "2 Oct",
            lastMessage = "See You Soon Buddy!!",
            image = R.drawable.person2
        ),
        Chat(
            id = 2,
            name = "Rishi K.",
            time = "03:34",
            date = "2 Oct",
            lastMessage = "Happy Birthday Boss",
            image = R.drawable.person3
        ),
        Chat(
            id = 3,
            name = "Angelina",
            time = "02:40",
            date = "2 Oct",
            lastMessage = "Hey Man! What's up ",
            image = R.drawable.person4
        ),
        Chat(
            id = 4,
            name = "George",
            time = "11:47",
            date = "1 Oct",
            lastMessage = "Is the work done?",
            image = R.drawable.person5
        ),
        Chat(
            id = 5,
            name = "Nishant",
            time = "08:02",
            date = "1 Oct",
            lastMessage = "Which course should i follow?",
            image = R.drawable.person6
        ),
        Chat(
            id = 6,
            name = "Ritika",
            time = "06:35",
            date = "1 Oct",
            lastMessage = "What are the new office timings?",
            image = R.drawable.person7
        ),
        Chat(
            id = 7,
            name = "Aman Malhotra",
            time = "05:20",
            date = "30 Sept",
            lastMessage = "Good Morning...",
            image = R.drawable.person8
        ),
        Chat(
            id = 8,
            name = "Vaibhav",
            time = "03:29",
            date = "30 Sept",
            lastMessage = "See you at the cafe",
            image = R.drawable.person9
        ),
        Chat(
            id = 9,
            name = "Praveen Kumar",
            time = "09:34",
            date = "29 Sept",
            lastMessage = "Waiting for diwali holidays",
            image = R.drawable.person10
        ),
        Chat(
            id = 10,
            name = "Utsav",
            time = "09:31",
            date = "29 Sept",
            lastMessage = "I have a good news for u buddy",
            image = R.drawable.person11
        ),
        )

    val listMessage = listOf(
        Message("Hi Roy how are you ?", false),
        Message("Iam fine, how are you ?", true),
        Message("Iam fine too", false),
        Message("What do you do now ?", true),
        Message("Write a book, and doing my work", false),
        Message("Wow, its so good man", true),
        Message("Yeah", false),
        Message("So What are u doing?", false),
        Message("Just relaxing..", true),
        Message("Great", false),
    )

    val listCall = listOf(
        Call(
            id = 0,
            name = "Rohit",
            date = "2 Oct",
            image = R.drawable.person1,
            isIncoming = true,
            isMissCall = false
        ),
        Call(
            id = 1,
            name = "Raunak",
            date = "2 Oct",
            image = R.drawable.person2,
            isIncoming = true,
            isMissCall = true
        ),
        Call(
            id = 2,
            name = "Rishi K.",
            date = "2 Oct",
            image = R.drawable.person3,
            isIncoming = true,
            isMissCall = false
        ),
        Call(
            id = 3,
            name = "Angelina",
            date = "2 Oct",
            image = R.drawable.person4,
            isIncoming = true,
            isMissCall = true
        ),
        Call(
            id = 4,
            name = "George",
            date = "1 Oct",
            image = R.drawable.person5,
            isIncoming = true,
            isMissCall = false
        ),
        Call(
            id = 5,
            name = "Nishant",
            date = "1 Oct",
            image = R.drawable.person6,
            isIncoming = true,
            isMissCall = true
        ),
        Call(
            id = 6,
            name = "Ritika",
            date = "1 Oct",
            image = R.drawable.person7,
            isIncoming = true,
            isMissCall = false
        ),
        Call(
            id = 7,
            name = "Aman Malhotra",
            date = "30 Sept",
            image = R.drawable.person8,
            isIncoming = true,
            isMissCall = false
        ),
        Call(
            id = 8,
            name = "Vaibhav",
            date = "30 Sept",
            image = R.drawable.person9,
            isIncoming = true,
            isMissCall = false
        ),
        Call(
            id = 9,
            name = "Praveen Kumar",
            date = "29 Sept",
            image = R.drawable.person10,
            isIncoming = true,
            isMissCall = false
        ),
        Call(
            id = 10,
            name = "Utsav",
            date = "29 Sept",
            image = R.drawable.person11,
            isIncoming = true,
            isMissCall = true
        ),

        )

}




