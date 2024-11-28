package com.cis.email.dto;

import java.util.Arrays;

public class EmailDTO {
    private String mail_num;
    private String mail_title;
    private String mail_content;
    private String mail_check;
    private String create_at;
    private String recipient_id;
    private String sender_id;
    private String[] mail_file;

    public String getMail_num() {
        return mail_num;
    }
    public void setMail_num(String mail_num) {
        this.mail_num = mail_num;
    }
    public String getMail_title() {
        return mail_title;
    }
    public void setMail_title(String mail_title) {
        this.mail_title = mail_title;
    }
    public String getMail_content() {
        return mail_content;
    }
    public void setMail_content(String mail_content) {
        this.mail_content = mail_content;
    }
    public String getMail_check() {
        return mail_check;
    }
    public void setMail_check(String mail_check) {
        this.mail_check = mail_check;
    }
    public String getCreate_at() {
        return create_at;
    }
    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
    public String getRecipient_id() {
        return recipient_id;
    }
    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
    }
    public String getSender_id() {
        return sender_id;
    }
    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }
    public String[] getMail_file() {
        return mail_file;
    }
    public void setMail_file(String[] mail_file) {
        this.mail_file = mail_file;
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
                "mail_num='" + mail_num + '\'' +
                ", mail_title='" + mail_title + '\'' +
                ", mail_content='" + mail_content + '\'' +
                ", mail_check='" + mail_check + '\'' +
                ", create_at='" + create_at + '\'' +
                ", recipient_id='" + recipient_id + '\'' +
                ", sender_id='" + sender_id + '\'' +
                ", mail_file=" + Arrays.toString(mail_file) +
                '}';
    }

}
