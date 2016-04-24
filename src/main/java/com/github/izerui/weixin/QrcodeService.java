package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.QrCode;
import com.github.izerui.weixin.mappings.Ticket;

/**
 * Created by serv on 16/4/24.
 */
public interface QrcodeService {

    Ticket create(QrCode qrCode);
}
