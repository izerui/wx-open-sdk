
package com.github.izerui.weixin.mappings;

import java.io.Serializable;

/**
 * Created by serv on 16/4/25.
 */
public class Media implements Serializable {

    private String fileName;
    private Type type;
    private byte[] data;
    private String title;
    private String introduction;


    private Media(){

    }
    private Media(String fileName, Type type, byte[] data) {
        this.fileName = fileName;
        this.type = type;
        this.data = data;
    }

    private Media(String fileName, String title, String introduction, byte[] data) {
        this.fileName = fileName;
        this.title = title;
        this.introduction = introduction;
        this.data = data;
        this.type = Type.video;
    }

    public static Media image(String fileName, byte[] data){
        return new Media(fileName,Type.image,data);
    }

    public static Media voice(String fileName,byte[] data){
        return new Media(fileName,Type.voice,data);
    }

    public static Media thumb(String fileName,byte[] data){
        return new Media(fileName,Type.thumb,data);
    }

    public static Media video(String fileName,String title,String introduction , byte[] data){
        return new Media(fileName, title, introduction, data);
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public enum Type{
        image,voice,video,thumb;
    }
}
