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
package tobeused.vo.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by user on 2015/6/10.
 */
public class PoiInfo implements Serializable {

    @JsonProperty("base_info")
    private PoiBaseInfo poiBaseInfo;


    public PoiBaseInfo getPoiBaseInfo() {
        return poiBaseInfo;
    }

    public void setPoiBaseInfo(PoiBaseInfo poiBaseInfo) {
        this.poiBaseInfo = poiBaseInfo;
    }
}
