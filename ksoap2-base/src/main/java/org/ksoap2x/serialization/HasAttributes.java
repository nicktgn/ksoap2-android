package org.ksoap2x.serialization;

/**
 * Common inteface for classes which want to serialize attributes to outgoing soap message
 * @author robocik
 */
public interface HasAttributes
{
    int getAttributeCount();

    void getAttributeInfo(int index, AttributeInfo info);
}
