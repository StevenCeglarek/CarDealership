package com.dealership.util;

public abstract class DealershipList<T> extends DealershipCollection<T> {

    public abstract void order();

    public abstract int indexOf(T c);

}
