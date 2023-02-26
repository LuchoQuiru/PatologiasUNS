package com.example.patologiasuns.utils

import android.content.Context
import android.content.res.Resources

class Utils {
    companion object{

        fun resIdByName(context: Context , resIdName: String?, resType: String): Int {
            resIdName?.let {
                return context.resources.getIdentifier(it, resType, context.packageName)
            }
            throw Resources.NotFoundException()
        }

        fun getVirusImageWithAzar(context: Context) : Int {
            val random = (1 .. 6).shuffled().last()
            if(random == 1)
                return resIdByName(context,"virusrojo","drawable")
            if(random == 2)
                return resIdByName(context,"virusverde","drawable")
            if(random == 3)
                return resIdByName(context,"virusazul","drawable")
            if(random == 4)
                return resIdByName(context,"virusrosa","drawable")
            if(random == 5)
                return resIdByName(context,"virusvioleta","drawable")
            if(random == 6)
                return resIdByName(context,"virusamarillo","drawable")

            return 0
        }
    }

}
