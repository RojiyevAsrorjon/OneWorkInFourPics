package uz.gita.onewordinfourpics.data.entities

import androidx.annotation.DrawableRes

data class QuestionImages(@DrawableRes var image1 : Int,
                          @DrawableRes var image2 : Int,
                          @DrawableRes var image3 : Int,
                          @DrawableRes var image4 : Int)