package org.ksoap2x.samples.amazon.search.messages;

import org.ksoap2x.serialization.*;

public abstract class BaseObject implements KvmSerializable {

    protected static final String NAMESPACE = "http://webservices.amazon.com/AWSECommerceService/2006-05-17";

    public BaseObject() {
        super();
    }
}
