package de.fau.cs.mad.wanthavers.common;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider;

import java.util.Date;

@DatabaseTable
public class AppChatLastSeen {

    @DatabaseField(id = true)
    private String chatId;

    @DatabaseField
    private Date lastSeen;

    @DatabaseField
    private String lastMessage;

    public AppChatLastSeen() { }

    public AppChatLastSeen(String chatId, Date lastSeen, String lastMessage) {
        this.chatId = chatId;
        this.lastSeen = lastSeen;
        this.lastMessage = lastMessage;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
