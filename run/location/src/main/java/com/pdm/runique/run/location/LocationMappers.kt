package com.pdm.runique.run.location

import android.location.Location
import com.pdm.runique.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude() = LocationWithAltitude(
    com.pdm.runique.core.domain.location.Location(latitude, longitude),
    altitude
)