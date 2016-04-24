/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 serv<liuyuhua69@gmail.com>
 *
 * 任何人都有复制与发布本协议的原始或修改过的版本的权利。
 * 若本协议被修改，须修改协议名称。
 *
 *          你他妈的想干嘛就干嘛公共许可证
 *              复制、发布和修改条款
 *
 *  0. 你只要他妈的想干嘛就干嘛好了。
 */
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
