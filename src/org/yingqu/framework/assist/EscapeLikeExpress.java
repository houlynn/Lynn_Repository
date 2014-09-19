package org.yingqu.framework.assist;

import org.hibernate.criterion.LikeExpression;

public class EscapeLikeExpress extends LikeExpression {

    public EscapeLikeExpress(String propertyName, String value, Character escapeChar, boolean ignoreCase) {
        super(propertyName, value, escapeChar, ignoreCase);
    }

}
