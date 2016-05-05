
package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 16/4/24.
 */
public class QrCode implements Serializable{

    @JsonProperty("expire_seconds")
    private Integer expireSeconds;

    @JsonProperty("action_name")
    private String actionName;

    @JsonProperty("action_info")
    private ActionInfo actionInfo;

    public static QrCode timeout(Integer expireSeconds, Integer sceneId){
        return new QrCode(expireSeconds,sceneId);
    }

    public static QrCode forever(String sceneStr){
        return new QrCode(sceneStr);
    }

    /**
     * 临时二维码
     * @param expireSeconds
     * @param sceneId
     */
    private QrCode(Integer expireSeconds, Integer sceneId) {
        this.expireSeconds = expireSeconds;
        this.actionName = "QR_SCENE";
        this.actionInfo = new ActionInfo(sceneId);
    }

    /**
     * 永久二维码
     * @param sceneStr
     */
    private QrCode(String sceneStr) {
        this.actionName = "QR_LIMIT_STR_SCENE";
        this.actionInfo = new ActionInfo(sceneStr);
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public String getActionName() {
        return actionName;
    }

    public Integer getSceneId(){
        return actionInfo.scene.sceneId;
    }

    public String getSceneStr(){
        return actionInfo.scene.sceneStr;
    }


    private class ActionInfo implements Serializable{

        @JsonProperty("scene")
        private Scene scene;

        //临时
        public ActionInfo(Integer sceneId) {
            this.scene = new Scene(sceneId);
        }

        //永久
        public ActionInfo(String sceneStr) {
            this.scene = new Scene(sceneStr);
        }

        private class Scene implements Serializable{

            @JsonProperty("scene_id")
            private Integer sceneId;

            @JsonProperty("scene_str")
            private String sceneStr;

            public Scene(Integer sceneId) {
                this.sceneId = sceneId;
            }

            public Scene(String sceneStr) {
                this.sceneStr = sceneStr;
            }


        }
    }
}
