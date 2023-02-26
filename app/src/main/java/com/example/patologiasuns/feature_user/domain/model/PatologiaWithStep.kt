package com.example.patologiasuns.feature_user.domain.model

import androidx.room.Embedded
import androidx.room.Relation


class PatologiaWithStep {
    @Embedded
    public var patologia: Patologia? = null

    @Relation(parentColumn = "id", entityColumn = "patologia_id")
    public var steps: List<Step>? = null
}