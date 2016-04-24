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

    /**
     * 临时二维码
     * @param expireSeconds
     * @param sceneId
     */
    public QrCode(Integer expireSeconds, Integer sceneId) {
        this.expireSeconds = expireSeconds;
        this.actionName = "QR_SCENE";
        this.actionInfo = new ActionInfo(sceneId);
    }

    /**
     * 永久二维码
     * @param sceneStr
     */
    public QrCode(String sceneStr) {
        this.actionName = "QR_LIMIT_STR_SCENE";
        this.actionInfo = new ActionInfo(sceneStr);
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public ActionInfo getActionInfo() {
        return actionInfo;
    }

    public void setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
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

        public Scene getScene() {
            return scene;
        }

        public void setScene(Scene scene) {
            this.scene = scene;
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


            public Integer getSceneId() {
                return sceneId;
            }

            public void setSceneId(Integer sceneId) {
                this.sceneId = sceneId;
            }

            public String getSceneStr() {
                return sceneStr;
            }

            public void setSceneStr(String sceneStr) {
                this.sceneStr = sceneStr;
            }
        }
    }
}
