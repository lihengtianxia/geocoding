package io.patamon.geocoding.core.impl

import io.patamon.geocoding.core.AddressPersister
import io.patamon.geocoding.core.RegionCache
import io.patamon.geocoding.model.RegionEntity

/**
 * Desc: 地址持久层的操作, 这边暂时只是对标准地址库的处理.
 *      暂时不将标准化后的地址存储在数据出中。
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2017/1/17
 */
open class DefaultAddressPersister (
        // 行政规划准地址库
        private val regoinCache: RegionCache
) : AddressPersister {

    /**
     * 获取行政规划地址树状结构关系
     */
    override fun getRootRegion(): RegionEntity {
        return regoinCache.get()
    }

    /**
     * 根据id获取
     */
    override fun getRegion(id: Long): RegionEntity? {
        return regoinCache.getCache()[id]
    }

}