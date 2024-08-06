package com.group.consult.commerce.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @title: BeanCopyUtils
 * @description: Bean conversion
 * @author: Huang, Dylan Bo
 * @date: 2024-04-07
 */
public class BeanCopyUtils {

    /**
     * Transparent data transmission
     *
     * @param k   k
     * @param t   t
     * @param <T> t
     * @param <K> k
     * @return T
     */
    public static <T, K> T copy(K k, Class<? extends T> t) {
        try {
            T r = t.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(k, r);

            return r;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Transparent data transmission
     *
     * @param kl  kl
     * @param t   t
     * @param <T> t
     * @param <K> k
     * @return List
     */
    public static <T, K> List<T> copyList(List<K> kl, Class<? extends T> t) {
        try {
            List<T> l = new ArrayList<>(kl.size());
            for (K k : kl) {
                l.add(copy(k, t));
            }
            return l;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Transparent data transmission
     *
     * @param resourceList resource list
     * @param target       target
     * @param <T>          t
     * @return List
     */
    public static <T> List<T> copyBeanList(List<?> resourceList, Class<T> target) {
        List<T> targetList = new LinkedList<>();
        if (CollectionUtils.isEmpty(resourceList)) {
            return targetList;
        }

        resourceList.forEach(e -> {
            T o = null;
            try {
                o = target.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                throw new RuntimeException(ex);
            } catch (NoSuchMethodException ex) {
                throw new RuntimeException(ex);
            }
            BeanUtils.copyProperties(e, o);
            targetList.add(o);
        });
        return targetList;
    }
}