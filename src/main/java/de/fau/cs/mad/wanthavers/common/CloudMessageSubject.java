package de.fau.cs.mad.wanthavers.common;


public class CloudMessageSubject {
    /*
        Structure of com.google.firebase.messaging.RemoteMessage (JSON):
        {
            "data": {
                "subject": <subject>
                "message": <message>
                ["sender": "Yoda" (optional)]
            },
            "registration_ids": [<token1>, <token2>, ...] -OR (for only one token)- "to": <token>
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

    public static String HAVERREJECTED = "HaverRejected";
    public static String HAVERREJECTED_DESIREID = DESIRECOMPLETE_DESIREID;
    public static String HAVERREJECTED_DESIRETITLE = DESIRECOMPLETE_DESIRETITLE;

    public static String NEWHAVER = "NewHaver";
    public static String NEWHAVER_DESIREID = DESIRECOMPLETE_DESIREID;
    public static String NEWHAVER_DESIRETITLE = DESIRECOMPLETE_DESIRETITLE;
}
