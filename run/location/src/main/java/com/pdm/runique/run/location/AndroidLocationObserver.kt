package com.pdm.runique.run.location

import android.content.Context
import android.location.LocationManager
import android.os.Looper
import androidx.core.content.getSystemService
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.pdm.runique.core.domain.location.LocationWithAltitude
import com.pdm.runique.run.domain.LocationObserver
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AndroidLocationObserver(
    private val context: Context,
) : LocationObserver {

    private val client = LocationServices.getFusedLocationProviderClient(context)

    override fun observeLocation(interval: Long): Flow<LocationWithAltitude> {
        return callbackFlow {
            val locationManager = context.getSystemService<LocationManager>()!!
            var isGpsEnabled = false
            var isNetworkEnabled = false

            while (!isGpsEnabled && !isNetworkEnabled) {
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    isGpsEnabled = true
                }

                if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    isNetworkEnabled = true
                }

                if (!isGpsEnabled && !isNetworkEnabled) {
                    delay(3000)
                }
            }

            client.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    trySend(
                        location.toLocationWithAltitude()
                    )
                }
            }

            val request = com.google.android.gms.location.LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY,
                interval
            ).build()

            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(result: com.google.android.gms.location.LocationResult) {
                    super.onLocationResult(result)
                    result.locations.lastOrNull()?.let {
                        trySend(
                            it.toLocationWithAltitude()
                        )
                    }
                }
            }

            client.requestLocationUpdates(request, locationCallback, Looper.getMainLooper())

            awaitClose {
                client.removeLocationUpdates(locationCallback)
            }
        }
    }
}