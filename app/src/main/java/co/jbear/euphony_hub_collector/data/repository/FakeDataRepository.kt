package co.jbear.euphony_hub_collector.data.repository

import co.jbear.euphony_hub_collector.domain.entity.CollectorLog

class FakeDataRepository : DataRepository {

    private val list = mutableListOf<CollectorLog>()
    private val mockData = CollectorLog.getMockCollectorLog()

    init {
        val currentTime = System.currentTimeMillis() / 1000
        for(i in 0..15) {
            list.add(mockData.copy(
                timestamp = currentTime + i*1000,
                data = ('A'..'z').map { it }.shuffled().subList(0, 8).joinToString("")
            ))
        }
    }

    override suspend fun insertCollectorLog(collectorLog: CollectorLog) {
        list.add(collectorLog)
    }

    override suspend fun getCollectorLogs(): List<CollectorLog> {
        return list
    }

    override suspend fun deleteCollectorLog(timestamp: Long) {
        list.removeIf { it.timestamp == timestamp }
    }
}