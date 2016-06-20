package de.fau.cs.mad.wanthavers.common;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class AppChatLastSeen {

    @DatabaseField(id = true)
    private String chatId;

    @DatabaseField
    private Date lastSeen;

    @DatabaseField
    private String lastMessage;

}
