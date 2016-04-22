/**
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */
package tobeused.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by serv on 2015/5/14.
 */
public class DeviceInfo extends Identifiers {

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("page_ids")
    private String page_ids;

    @JsonProperty("status")
    private String status;

    @JsonProperty("poiId")
    private String poiId;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPage_ids() {
        return page_ids;
    }

    public void setPage_ids(String page_ids) {
        this.page_ids = page_ids;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
}
