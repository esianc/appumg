package marco.umg.com.proyectochat.Activity;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MiFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG = "NOTICIAS";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje de "+from);

        if (remoteMessage.getNotification()!=null){
            Log.d(TAG,"Notificacion: "+remoteMessage.getNotification().getBody());
        }
    }
}
