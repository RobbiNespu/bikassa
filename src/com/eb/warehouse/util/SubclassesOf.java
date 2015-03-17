
package com.eb.warehouse.util;

import java.io.Serializable;

import com.google.common.base.Preconditions;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;


public class SubclassesOf extends AbstractMatcher<TypeLiteral<?>> implements Serializable {
  private final Class<?> superclass;
  private static final long serialVersionUID = 0L;

  public SubclassesOf(Class<?> superclass) {
    this.superclass = (Preconditions.checkNotNull(superclass, "superclass"));
  }

  /** {@inheritDoc} */
  @Override
  public boolean matches(TypeLiteral<?> obj) {
    return superclass.isAssignableFrom(obj.getRawType());
  }

  @Override
  public boolean equals(Object other) {
    return ((other instanceof SubclassesOf) && (((SubclassesOf) other).superclass.equals(superclass)));
  }

  @Override
  public int hashCode() {
    return (37 * superclass.hashCode());
  }

  @Override
  public String toString() {
    return "subclassesOf(" + superclass.getSimpleName() + ".class)";
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
