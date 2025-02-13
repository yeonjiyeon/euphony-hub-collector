package co.jbear.euphony_hub_collector.data.repository

import co.jbear.euphony_hub_collector.data.dao.CollectorLogDao
import co.jbear.euphony_hub_collector.domain.entity.CollectorLog

class DataRepositoryImpl(private val collectorLogDao: CollectorLogDao): DataRepository {

    override suspend fun insertCollectorLog(collectorLog: CollectorLog) = collectorLogDao.insert(collectorLog)
    override suspend fun getCollectorLogs() = collectorLogDao.getAll()
    override suspend fun deleteCollectorLog(timestamp: Long) = collectorLogDao.delete(timestamp)
}