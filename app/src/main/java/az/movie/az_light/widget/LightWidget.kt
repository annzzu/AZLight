package az.movie.az_light.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import az.movie.az_light.BuildConfig
import az.movie.az_light.R

class LightWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context ,
        appWidgetManager: AppWidgetManager ,
        appWidgetIds: IntArray
    ) {
        appWidgetIds.forEach { appWidgetId ->
            val turnOn: Intent = Uri.parse(BuildConfig.BASE_URL.plus(context.getString(R.string.on))).let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            val turnOff: Intent = Uri.parse(BuildConfig.BASE_URL.plus(context.getString(R.string.off))).let { webpage ->
                Intent(Intent.ACTION_VIEW , webpage)
            }

            val turnOnActivity = PendingIntent.getActivity(context , 0 , turnOn , 0)
            val turnOffActivity = PendingIntent.getActivity(context , 0 , turnOff , 0)
            val views: RemoteViews = RemoteViews(
                context.packageName,
                R.layout.light_widget
            ).apply {
                setOnClickPendingIntent(R.id.btnLightOn , turnOnActivity)
                setOnClickPendingIntent(R.id.btnLightOff , turnOffActivity)
            }

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }
}
