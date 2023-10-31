package edu.austral.dissis.common.util;

import java.util.Optional;

public interface Result<K, V> {
    K getKey();

    Optional<V> getValue();
}
