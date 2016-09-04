package io.qameta.htmlelements.element;

import io.qameta.htmlelements.extension.ConvertMethod;
import io.qameta.htmlelements.extension.DescriptionProvider;
import io.qameta.htmlelements.extension.FilterMethod;
import io.qameta.htmlelements.extension.SelectorProvider;
import org.hamcrest.Matcher;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface ExtendedList<ItemType> extends List<ItemType> {

    @SelectorProvider
    String getSelector();

    @DescriptionProvider
    String getDescription();

    @FilterMethod
    ExtendedList<ItemType> filter(Predicate<ItemType> predicate);

    default ExtendedList<ItemType> filter(String description, Predicate<ItemType> predicate) {
        return filter(predicate);
    }

    default ExtendedList<ItemType> filter(Matcher matcher) {
        return filter(matcher::matches);
    }

    @ConvertMethod
    <R> ExtendedList<R> convert(Function<ItemType, R> function);

    default ExtendedList<ItemType> waitUntil(String description, Predicate<ExtendedList<ItemType>> predicate) {
        return waitUntil(predicate);
    }

    default ExtendedList<ItemType> waitUntil(Matcher matcher) {
        return waitUntil(matcher.toString(), matcher::matches);
    }

    ExtendedList<ItemType> waitUntil(Predicate<ExtendedList<ItemType>> predicate);

    ExtendedList<ItemType> should(Matcher matcher);

}