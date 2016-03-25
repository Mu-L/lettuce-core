package com.lambdaworks.redis.output;

import java.nio.ByteBuffer;

import com.lambdaworks.redis.codec.RedisCodec;
import com.lambdaworks.redis.protocol.CommandOutput;

/**
 * Streaming-Output of Values. Returns the count of all values (including null).
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 */
public class ValueStreamingOutput<K, V> extends CommandOutput<K, V, Long> {
    private final ValueStreamingChannel<V> channel;

    public ValueStreamingOutput(RedisCodec<K, V> codec, ValueStreamingChannel<V> channel) {
        super(codec, Long.valueOf(0));
        this.channel = channel;
    }

    @Override
    public void set(ByteBuffer bytes) {

        channel.onValue(bytes == null ? null : codec.decodeValue(bytes));
        output = output.longValue() + 1;
    }

}
