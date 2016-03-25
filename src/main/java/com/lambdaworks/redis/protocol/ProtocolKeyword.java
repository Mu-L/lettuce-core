package com.lambdaworks.redis.protocol;

/**
 * Interface for protocol keywords providing an encoded representation.
 * 
 * @author Mark Paluch
 */
public interface ProtocolKeyword {

    /**
     * 
     * @return byte[] encoded representation.
     * 
     */
    byte[] getBytes();
}
