package ru.android.hyrulecompendiumanothermvvm.data.converters

import ru.android.hyrulecompendiumanothermvvm.data.models.HyruleDataDto
import ru.android.hyrulecompendiumanothermvvm.data.models.HyruleInfoDto
import ru.android.hyrulecompendiumanothermvvm.data.models.PropertiesDto
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleData
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleInfo
import ru.android.hyrulecompendiumanothermvvm.domain.models.Properties

fun HyruleInfoDto.toDomain(): HyruleInfo = HyruleInfo(
    data = data?.map { it.toDomain() }
)

fun HyruleDataDto.toDomain(): HyruleData = HyruleData(
    id = id,
    category = category,
    name = name,
    image = image,
    description = description,
    commonLocations = commonLocations,
    properties = properties?.toDomain(),
    drops = drops,
    cookingEffect = cookingEffect,
    heartsRecovered = heartsRecovered,
)

fun PropertiesDto.toDomain(): Properties = Properties(
    attack = attack,
    defense = defense
)