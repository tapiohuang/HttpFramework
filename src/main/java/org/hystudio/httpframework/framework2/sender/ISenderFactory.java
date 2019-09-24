package org.hystudio.httpframework.framework2.sender;

import org.hystudio.httpframework.framework2.config.RequestMethod;
import org.hystudio.httpframework.framework2.sender.ISender;
import org.hystudio.httpframework.framework2.session.HttpSession;

public interface ISenderFactory {
    ISender createSender(HttpSession httpSession);
}
