package com.bsoft.office.common.sort;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListBeanSort {

    @SuppressWarnings("unchecked")
    public static <T> void sort(List<T> list, String fieldName, boolean asc) {
        Comparator<?> mycmp = ComparableComparator.getInstance();
        mycmp = ComparatorUtils.nullLowComparator(mycmp); // 允许null
        if (!asc) {
            mycmp = ComparatorUtils.reversedComparator(mycmp); // 逆序
        }
        Collections.sort(list, new BeanComparator(fieldName, mycmp));
    }
}
