package org.yingqu.framework.assist;


import java.util.Set;
public interface Condition {

    public Set<Messenger> getMessages();
    public void clearCache();
}
