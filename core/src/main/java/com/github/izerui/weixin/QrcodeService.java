package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.QrCode;
import com.github.izerui.weixin.mappings.Ticket;

import java.net.URL;

/**
 * Created by serv on 16/4/24.
 */
public interface QrcodeService {

    Ticket create(QrCode qrCode);

    URL url(String ticket);
}
