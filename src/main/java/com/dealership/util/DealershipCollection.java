package com.dealership.util;

public class DealershipCollection {

    public abstract class GymCollection<T> {

        /**
         * Optional size number for non expandable subclasses
         */
        protected int maxSize;

        public abstract T get(T o);

        public abstract void add(T u) throws Exception;

        public abstract int size();

        public abstract void remove(T o);

        public abstract T next();

        public abstract T previous();

        public abstract String toString();

        abstract boolean isEmpty();

        protected abstract void clear();

    }
}
