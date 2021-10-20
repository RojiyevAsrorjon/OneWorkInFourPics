package uz.gita.onewordinfourpics.data.entities

import com.asrorxon.onewordinfourpics.R

class Questions {
    private val questions = ArrayList<GameQuestionData>()

    init {
        questions.add(
            GameQuestionData(
                0,
                QuestionImages(
                    R.drawable.uzb,
                    R.drawable.russia,
                    R.drawable.japan, R.drawable.usa
                ),
                "flag"
            )
        )
        questions.add(
            GameQuestionData(
                1,
                QuestionImages(
                    R.drawable.image2_1,
                    R.drawable.image2_2,
                    R.drawable.image2_3, R.drawable.image2_4
                ),
                "pet"
            )
        )
        questions.add(
            GameQuestionData(
                2,
                QuestionImages(
                    R.drawable.child1,
                    R.drawable.child2,
                    R.drawable.child3, R.drawable.child4
                ),
                "Children"
            )
        )
        questions.add(
            GameQuestionData(
                3,
                QuestionImages(
                    R.drawable.tie1,
                    R.drawable.tie2,
                    R.drawable.tie3, R.drawable.tie4
                ),
                "Tie"
            )
        )
        questions.add(
            GameQuestionData(
                4,
                QuestionImages(
                    R.drawable.summer1,
                    R.drawable.summer2,
                    R.drawable.summer3, R.drawable.summer4
                ),
                "Summer"
            )
        )
        questions.add(
            GameQuestionData(
                5,
                QuestionImages(
                    R.drawable.angry1,
                    R.drawable.angry2,
                    R.drawable.angry3, R.drawable.angry4
                ),
                "Angry"
            )
        )
        questions.add(
            GameQuestionData(
                6,
                QuestionImages(
                    R.drawable.small1,
                    R.drawable.small2,
                    R.drawable.small3, R.drawable.small4
                ),
                "Small"
            )
        )
        questions.add(
            GameQuestionData(
                7,
                QuestionImages(
                    R.drawable.lazy1,
                    R.drawable.lazy2,
                    R.drawable.lazy3, R.drawable.lazy4
                ),
                "Lazy"
            )
        )

        questions.add(
            GameQuestionData(
                8,
                QuestionImages(
                    R.drawable.cold1,
                    R.drawable.cold2,
                    R.drawable.cold3, R.drawable.cold4
                ),
                "Cold"
            )
        )
        questions.add(
            GameQuestionData(
                9,
                QuestionImages(
                    R.drawable.building1,
                    R.drawable.building2,
                    R.drawable.building3, R.drawable.building4
                ),
                "Building"
            )
        )
        questions.add(
            GameQuestionData(
                10,
                QuestionImages(
                    R.drawable.ill1,
                    R.drawable.ill2,
                    R.drawable.ill3, R.drawable.ill4
                ),
                "Ill"
            )
        )
        questions.add(
            GameQuestionData(
                11,
                QuestionImages(
                    R.drawable.jogging1,
                    R.drawable.jogging2,
                    R.drawable.jogging3, R.drawable.jogging4
                ),
                "Jogging"
            )
        )


    }

    fun getQuestions() = questions
}