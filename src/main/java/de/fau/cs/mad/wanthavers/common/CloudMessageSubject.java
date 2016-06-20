package de.fau.cs.mad.wanthavers.common;


public class CloudMessageSubject {
    /*
        Structure of com.google.firebase.messaging.RemoteMessage (JSON):
        {
            "to": "<token>",
            "notification": {
                "body": ...,
                "title": ...
                "icon" ...
            }
            "data": {
                "subject": <subject>
                ["sender": "Yoda" (optional)]
            }
        }
     */

    public static String NEWMESSAGE = "NewMessage";
    public static String NEWMESSAGE_SENDER = "sender";
    public static String NEWMESSAGE_SENDERID = "senderId";
    public static String NEWMESSAGE_CHATID = "chatId";

    public static String DESIREUPDATE = "DesireUpdate";

    public static String DESIRECOMPLETE = "DesireComplete";
    public static String DESIRECOMPLETE_DESIREID = "desireId";
    public static String DESIRECOMPLETE_DESIRETITLE = "desireTitle";

    public static String HAVERACCEPTED = "HaverAccepted";
    public static String HAVERACCEPTED_DESIREID = DESIRECOMPLETE_DESIREID;
    public static String HAVERACCPETED_DESIRETITLE = DESIRECOMPLETE_DESIRETITLE;
}
