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
package junit;

import com.github.izerui.weixin.mappings.Users;
import org.junit.Test;

/**
 * Created by serv on 16/4/21.
 */
public class UserJunit extends BaseJunit {

    @Test
    public void get(){

        Users users = engine.getUserService(accessToken).get(null);
        System.out.println(users);
    }
}
