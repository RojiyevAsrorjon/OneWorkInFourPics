package uz.gita.onewordinfourpics.data.entities

data class GameQuestionData(val id: Long, var questionImages: QuestionImages, var answer: String) {
    private val letters = ArrayList<String>()
    fun getLetter(): List<String> {
        for (i in 0 until 12) {
            if (i < answer.length) {
                letters.add(answer[i].toString())
            } else {
                var string = ('a'..'z').random().toString()
                while (letters.contains(string)) {
                    string = ('a'..'z').random().toString()
                }
                letters.add(string)
            }
        }
        letters.shuffle()
        return letters
    }
}

