package sho0126hiro.DiaryShareBackend.infrastructure.entity

import java.nio.ByteBuffer
import java.util.*

fun uuidToBytes(uuid: UUID): ByteArray{
    val buffer = ByteBuffer.wrap(ByteArray(16))
    buffer.putLong(uuid.mostSignificantBits)
    buffer.putLong(uuid.leastSignificantBits)
    return buffer.array()
}

fun bytesToUuid(bytes: ByteArray): UUID {
    val buffer = ByteBuffer.wrap(bytes)
    return UUID(buffer.long, buffer.long)
}
