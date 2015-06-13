package com.eb.warehouse.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;

import java.io.Serializable;
import java.util.Set;


public final class OneOf extends AbstractMatcher<TypeLiteral<?>> implements Serializable {

    private static final long serialVersionUID = 0L;
    private final Set<Matcher<TypeLiteral<?>>> matchers;

    public OneOf(Matcher<TypeLiteral<?>>... matchers) {
        this.matchers = ImmutableSet.copyOf(Preconditions.checkNotNull(matchers, "matchers"));
    }

    public OneOf(Set<Matcher<TypeLiteral<?>>> matchers) {
        this.matchers = Preconditions.checkNotNull(matchers, "matchers");
    }

    @Override
    public boolean matches(TypeLiteral<?> obj) {
        for (Matcher<TypeLiteral<?>> m : matchers) {
            if (m.matches(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return ((other instanceof OneOf) && (((OneOf) other).matchers.equals(matchers)));
    }

    @Override
    public int hashCode() {
        return (37 * matchers.hashCode());
    }

    @Override
    public String toString() {
        return "oneOf(" + matchers + ")";
    }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
